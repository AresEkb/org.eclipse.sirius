/*******************************************************************************
 * Copyright (c) 2011, 2016, 2019 THALES GLOBAL SERVICES and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.tools.internal.views.modelexplorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.ui.tools.internal.views.common.action.DeleteRepresentationAction;
import org.eclipse.sirius.ui.tools.internal.views.common.item.RepresentationItemImpl;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;

import com.google.common.collect.Iterables;

/**
 * An handler which redirect to the appropriate delete action depending on the selection.
 * 
 * @author mchauvin
 */
public class DeleteActionHandler extends Action {

    private ISelectionProvider selectionProvider;

    private ISelectionChangedListener selectionListener;

    /**
     * Create a new instance.
     * 
     * @param selectionProvider
     *            the selection provider
     */
    public DeleteActionHandler(ISelectionProvider selectionProvider) {
        this.selectionProvider = selectionProvider;
        this.selectionListener = event -> setEnabled(!getRepresentationDescriptors().isEmpty());
        this.selectionProvider.addSelectionChangedListener(selectionListener);
    }

    private Collection<DRepresentationDescriptor> getRepresentationDescriptors() {
        ISelection selection = selectionProvider.getSelection();
        if (selection instanceof IStructuredSelection) {
            Collection<?> selections = ((IStructuredSelection) selection).toList();
            if (selections != null && !selections.isEmpty()) {
                Collection<DRepresentationDescriptor> selectedRepDescriptors = new LinkedHashSet<>();
                
                selections.stream().filter(DRepresentationDescriptor.class::isInstance).collect(Collectors.toCollection(() -> selectedRepDescriptors));
                Iterables.addAll(selectedRepDescriptors, Iterables.filter(selections, DRepresentationDescriptor.class));
                Iterables.addAll(selectedRepDescriptors, Iterables.transform(Iterables.filter(selections, RepresentationItemImpl.class), RepresentationItemImpl.REPRESENTATION_ITEM_TO_REPRESENTATION));
                return selectedRepDescriptors;
            }
        }
        return Collections.emptyList();
    }

    public void dispose() {
        this.selectionProvider.removeSelectionChangedListener(this.selectionListener);
        this.selectionListener = null;
        this.selectionProvider = null;
    }

    @Override
    public void run() {
        Action deleteAction = new DeleteRepresentationAction(getRepresentationDescriptors());
        deleteAction.run();
    }
}
