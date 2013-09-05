/*******************************************************************************
 * Copyright (c) 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.editor.tools.internal.presentation;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.common.tools.api.util.Options;
import org.eclipse.sirius.business.api.componentization.SiriusRegistry;
import org.eclipse.sirius.business.api.query.SiriusQuery;
import org.eclipse.sirius.description.DescriptionPackage;
import org.eclipse.sirius.description.Sirius;

/**
 * A dialog box which allows a Sirius specifier to select a sub-set of the
 * available Siriuss to configure the <code>Sirius.reuses</code> and
 * <code>Sirius.customizes</code> references.
 * 
 * @author pierre-charles.david@obeo.fr
 */
public class SiriusDependenciesSelectionDialog {
    /**
     * The viewpoint to configure.
     */
    private final Sirius viewpoint;

    /**
     * Constructor.
     * 
     * @param viewpoint
     *            the viewpoint to configure.
     */
    public SiriusDependenciesSelectionDialog(Sirius viewpoint) {
        this.viewpoint = viewpoint;
    }

    /**
     * Opens a dialog box allowing the user to select the list of Siriuss
     * this element will reuse.
     * 
     * @param shell
     *            the shell to use to open the dialog box.
     * @return the Sirius logical URIs of all the Siriuss selected for
     *         reuse by the end-user, or {@link Options#newNone()} if the user
     *         canceled the dialog.
     */
    public Option<Set<URI>> selectReusedSiriuss(Shell shell) {
        return selectSiriuss(shell, DescriptionPackage.eINSTANCE.getSirius_Reuses(), "Reused Siriuss", "Select the Siriuss from which this viewpoint will reuse elements:");
    }

    /**
     * Opens a dialog box allowing the user to select the list of Siriuss
     * this element will customize.
     * 
     * @param shell
     *            the shell to use to open the dialog box.
     * @return the Sirius logical URIs of all the Siriuss selected for
     *         customization by the end-user, or {@link Options#newNone()} if
     *         the user canceled the dialog.
     */
    public Option<Set<URI>> selectCustomizedSiriuss(Shell shell) {
        return selectSiriuss(shell, DescriptionPackage.eINSTANCE.getSirius_Customizes(), "Customized Siriuss", "Select the Siriuss this viewpoint will customize:");
    }

    /**
     * Opens a dialog box allowing the user to select the list of Siriuss
     * this element is in conflict with
     * 
     * @param shell
     *            the shell to use to open the dialog box.
     * @return the Sirius logical URIs of all the Siriuss selected for
     *         conflict by the end-user, or {@link Options#newNone()} if
     *         the user canceled the dialog.
     */
    public Option<Set<URI>> selectConflictsSiriuss(Shell shell) {
        return selectSiriuss(shell, DescriptionPackage.eINSTANCE.getSirius_Customizes(), "Conflicting Sirius", "Select the Siriuss this viewpoint is in conflict with:");
    }

    private Option<Set<URI>> selectSiriuss(Shell shell, EAttribute attribute, String title, String message) {
        List<URI> available = getAvailableSiriussURIs();
        available.remove(new SiriusQuery(viewpoint).getSiriusURI().get());
        Collections.sort(available, Ordering.usingToString());

        List<URI> selected = getSelectedSiriusURIs(viewpoint, attribute);

        ListSelectionDialog lsd = new ListSelectionDialog(shell, available, new SiriusURIContentProvider(), new LabelProvider(), message);
        lsd.setInitialElementSelections(selected);
        lsd.setTitle(title);
        if (lsd.open() == Window.OK) {
            Set<URI> result = ImmutableSet.copyOf(Iterators.filter(Iterators.forArray(lsd.getResult()), URI.class));
            return Options.newSome(result);
        } else {
            return Options.newNone();
        }
    }

    @SuppressWarnings("unchecked")
    private List<URI> getSelectedSiriusURIs(Sirius viewpoint, EStructuralFeature feature) {
        return Lists.newArrayList(Iterables.filter((List<URI>) viewpoint.eGet(feature), Predicates.notNull()));
    }

    private List<URI> getAvailableSiriussURIs() {
        return Lists.newArrayList(Iterables.filter(Iterables.transform(SiriusRegistry.getInstance().getSiriuss(), new Function<Sirius, URI>() {
            public URI apply(Sirius from) {
                Option<URI> uri = new SiriusQuery(from).getSiriusURI();
                if (uri.some()) {
                    return uri.get();
                } else {
                    return null;
                }
            }
        }), Predicates.notNull()));
    }

    private static class SiriusURIContentProvider implements IStructuredContentProvider {
        /**
         * {@inheritDoc}
         */
        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof List<?>) {
                Iterable<URI> uris = Iterables.filter((List<?>) inputElement, URI.class);
                return Iterables.toArray(uris, URI.class);
            } else {
                return new Object[0];
            }
        }

        /**
         * {@inheritDoc}
         */
        public void dispose() {
            // Nothing to do.
        }

        /**
         * {@inheritDoc}
         */
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // Nothing to do.
        }
    }
}
