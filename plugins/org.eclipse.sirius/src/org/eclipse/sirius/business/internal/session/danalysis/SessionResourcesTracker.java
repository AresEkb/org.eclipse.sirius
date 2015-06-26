/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.session.danalysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.business.api.query.URIQuery;
import org.eclipse.sirius.common.tools.DslCommonPlugin;
import org.eclipse.sirius.tools.api.profiler.SiriusTasksKey;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.Messages;
import org.eclipse.sirius.viewpoint.SiriusPlugin;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * This class is responsible for keeping track of which resources in the
 * ResourceSet correspond to what kind of model (semantic,
 * session/analysis/representation, description...).
 * 
 * @author pcdavid
 */
class SessionResourcesTracker {
    /**
     * The session for which we keep track of resources.
     */
    private DAnalysisSessionImpl session;

    /** The semantic resources collection. */
    private Collection<Resource> semanticResources;

    /** The semantic resources collection updater. */
    private SemanticResourcesUpdater semanticResourcesUpdater;

    private ControlledResourcesDetector controlledResourcesDetector;

    private DAnalysisRefresher dAnalysisRefresher;

    /**
     * Creates a new tracker for the specified session.
     * 
     * @param session
     *            the session to track.
     */
    SessionResourcesTracker(DAnalysisSessionImpl session) {
        this.session = Preconditions.checkNotNull(session);
        this.controlledResourcesDetector = new ControlledResourcesDetector(session);
        dAnalysisRefresher = new DAnalysisRefresher(session);
    }

    void initialize(IProgressMonitor monitor) {
        DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.RESOLVE_ALL_KEY);
        manageAutomaticallyLoadedResources(session);
        monitor.worked(1);

        DslCommonPlugin.PROFILER.stopWork(SiriusTasksKey.RESOLVE_ALL_KEY);
        // Look for controlled resources after load of every linked
        // resources.
        // Detect actual controlled resources.
        ControlledResourcesDetector.refreshControlledResources(session);
        if (controlledResourcesDetector != null) {
            controlledResourcesDetector.initialize();
        }
        // Reset semanticResources to have getSemanticResources() ignores
        // controlledResources which are computed only at this step
        if (semanticResourcesUpdater != null) {
            semanticResourcesUpdater.dispose();
            semanticResourcesUpdater = null;
        }
        semanticResources = null;
        monitor.worked(1);
        dAnalysisRefresher.initialize();
    }

    void addAdaptersOnAnalysis(final DAnalysis analysis) {
        if (semanticResourcesUpdater != null && !analysis.eAdapters().contains(semanticResourcesUpdater)) {
            analysis.eAdapters().add(semanticResourcesUpdater);
        }
    }

    void removeAdaptersOnAnalysis(final DAnalysis analysis) {
        if (semanticResourcesUpdater != null && analysis.eAdapters().contains(semanticResourcesUpdater)) {
            analysis.eAdapters().remove(semanticResourcesUpdater);
        }
    }

    Collection<Resource> getSemanticResources() {
        if (semanticResources == null) {
            semanticResources = new CopyOnWriteArrayList<Resource>();
            if (semanticResourcesUpdater == null) {
                semanticResourcesUpdater = new SemanticResourcesUpdater(session);
            }
            semanticResourcesUpdater.setSemanticResources(semanticResources);

            RunnableWithResult<Collection<Resource>> semanticResourcesGetter = new RunnableWithResult.Impl<Collection<Resource>>() {
                @Override
                public void run() {
                    setResult(SemanticResourceGetter.collectTopLevelSemanticResources(session));
                }
            };
            try {
                TransactionUtil.runExclusive(session.getTransactionalEditingDomain(), semanticResourcesGetter);
            } catch (InterruptedException e) {
                SiriusPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, SiriusPlugin.ID, Messages.SessionResourcesTracker_semanticResourcesAccessErrorMsg));
            }
            ((CopyOnWriteArrayList<Resource>) semanticResources).addAllAbsent(semanticResourcesGetter.getResult());
        }
        return Collections.unmodifiableCollection(semanticResources);
    }

    /**
     * Allow semanticResources to be recomputed when calling
     * <code>getSemanticResources()</code>.
     */
    void setSemanticResourcesNotUptodate() {
        semanticResources.clear();
        semanticResources = null;
    }

    /**
     * Discover semantic and session resources that we now depend on (i.e. they
     * were loading when resolving the session), and make sure they are
     * registered in the session if not already known.
     */
    static void manageAutomaticallyLoadedResources(final DAnalysisSessionImpl session) {
        registerNewlyReferencedSessionResources(session);

        Set<Resource> knownSemanticResources = Sets.newHashSet(session.getSemanticResources());
        Set<Resource> allSemanticResources = Sets.newHashSet();
        IResourceCollector irc = session.getResourceCollector();
        for (Resource resource : knownSemanticResources) {
            allSemanticResources.add(resource);
            allSemanticResources.addAll(irc.getAllReferencedResources(resource));
        }
        final Set<Resource> newSemanticResources = Sets.difference(allSemanticResources, knownSemanticResources);

        Predicate<Resource> resourcesToIgnore = new Predicate<Resource>() {
            public boolean apply(Resource resource) {
                // Remove empty resource and the Sirius environment
                return resource.getContents().isEmpty() || new URIQuery(resource.getURI()).isEnvironmentURI();
            }
        };
        Iterables.removeIf(newSemanticResources, resourcesToIgnore);
        if (!newSemanticResources.isEmpty()) {
            TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
            domain.getCommandStack().execute(new RecordingCommand(domain, Messages.SessionResourcesTracker_addReferencedSemanticResourcesMsg) {
                @Override
                protected void doExecute() {
                    for (Resource resource : newSemanticResources) {
                        session.addSemanticResource(resource.getURI(), new NullProgressMonitor());
                    }
                }
            });
        }
    }

    private static void registerNewlyReferencedSessionResources(final DAnalysisSessionImpl session) {
        TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
        Set<Resource> allResources = Sets.newLinkedHashSet(domain.getResourceSet().getResources());
        Collection<Resource> newReferencedSessionResources = Lists.newArrayList(Iterables.filter(allResources, Predicates.in(session.getReferencedSessionResources())));
        for (Resource newReferencedSessionResource : newReferencedSessionResources) {
            session.registerResourceInCrossReferencer(newReferencedSessionResource);
            for (DAnalysis refAnalysis : Iterables.filter(newReferencedSessionResource.getContents(), DAnalysis.class)) {
                session.addAdaptersOnAnalysis(refAnalysis);
            }
        }
    }

    void dispose() {
        session = null;
        if (dAnalysisRefresher != null) {
            dAnalysisRefresher.dispose();
            dAnalysisRefresher = null;
        }
        if (controlledResourcesDetector != null) {
            controlledResourcesDetector.dispose();
            controlledResourcesDetector = null;
        }
        if (semanticResourcesUpdater != null) {
            semanticResourcesUpdater.dispose();
            semanticResourcesUpdater = null;
        }
        if (semanticResources != null) {
            semanticResources.clear();
        }
    }

    void detectControlledResources() {
        ControlledResourcesDetector.refreshControlledResources(session);
    }
}
