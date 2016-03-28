/*******************************************************************************
 * Copyright (c) 2014, 2015 THALES GLOBAL SERVICES.
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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.common.tools.api.util.LazyCrossReferencer;

import com.google.common.collect.Iterables;

/**
 * A LazyCrossReferencer for the session.
 * {@link LazyCrossReferencer#initialize()} is overridden in order to only add
 * the adapter at the first use.
 * 
 * @author <a href="mailto:mickael.lanoe@obeo.fr">Mickael LANOE</a>
 *
 */
public class SessionLazyCrossReferencer extends LazyCrossReferencer {
    private DAnalysisSessionImpl session;

    private CrossReferenceTracker xrefTracker;

    /**
     * Construct from an opened session.
     * 
     * @param session
     *            an opened session
     * @param xrefTracker
     *            an optional {@link CrossReferenceTracker} to notify when
     *            cross-references are added or removed between elements.
     */
    public SessionLazyCrossReferencer(DAnalysisSessionImpl session, CrossReferenceTracker xrefTracker) {
        this.session = session;
        this.xrefTracker = xrefTracker;
    }

    @Override
    protected InverseCrossReferencer createInverseCrossReferencer() {
        if (xrefTracker != null) {
            return new InverseCrossReferencerWithCallback();
        } else {
            return super.createInverseCrossReferencer();
        }
    }

    @Override
    protected void initialize() {
        super.initialize();

        Collection<Resource> semanticResources = session.getSemanticResources();
        EList<Resource> controlledResources = session.getControlledResources();
        Set<Resource> allSessionResources = session.getAllSessionResources();

        Iterable<Resource> resources = Iterables.concat(semanticResources, controlledResources, allSessionResources);
        for (Resource resource : resources) {
            List<Adapter> adapters = resource.eAdapters();
            // add only if it was not added between creation and
            // initialization
            if (!adapters.contains(this)) {
                adapters.add(this);
            }
        }
    }

    class InverseCrossReferencerWithCallback extends InverseCrossReferencer {

        private static final long serialVersionUID = 1L;

        @Override
        protected void add(InternalEObject eObject, EReference eReference, EObject crossReferencedEObject) {
            super.add(eObject, eReference, crossReferencedEObject);
            xrefTracker.onReferenceAdded(eObject, eReference, crossReferencedEObject);
        }

        @Override
        public void remove(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
            super.remove(eObject, eReference, crossReferencedEObject);
            xrefTracker.onReferenceRemoved(eObject, eReference, crossReferencedEObject);
        }
    }
}
