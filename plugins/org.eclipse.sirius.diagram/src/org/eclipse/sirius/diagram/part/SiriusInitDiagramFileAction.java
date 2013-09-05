/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import org.eclipse.sirius.common.tools.api.resource.ResourceSetFactory;
import org.eclipse.sirius.diagram.internal.edit.parts.DDiagramEditPart;

/**
 * @was-generated
 */
public class SiriusInitDiagramFileAction implements IObjectActionDelegate {

    /**
     * @was-generated
     */
    private IWorkbenchPart targetPart;

    /**
     * @was-generated
     */
    private URI domainModelURI;

    /**
     * @was-generated
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        this.targetPart = targetPart;
    }

    /**
     * @was-generated
     */
    public void selectionChanged(IAction action, ISelection selection) {
        domainModelURI = null;
        action.setEnabled(false);
        if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
            return;
        }
        IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
        domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        action.setEnabled(true);
    }

    /**
     * @was-generated
     */
    private Shell getShell() {
        return targetPart.getSite().getShell();
    }

    /**
     * @was-generated
     */
    public void run(IAction action) {
        final ResourceSet set = ResourceSetFactory.createFactory().createResourceSet(domainModelURI);
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain(set);
        EObject diagramRoot = null;
        try {
            Resource resource = set.getResource(domainModelURI, true);
            diagramRoot = (EObject) resource.getContents().get(0);
        } catch (WrappedException ex) {
            SiriusDiagramEditorPlugin.getInstance().logError("Unable to load resource: " + domainModelURI, ex); //$NON-NLS-1$
        }
        if (diagramRoot == null) {
            MessageDialog.openError(getShell(), Messages.SiriusInitDiagramFileAction_InitDiagramFileResourceErrorDialogTitle,
                    Messages.SiriusInitDiagramFileAction_InitDiagramFileResourceErrorDialogMessage);
            return;
        }
        Wizard wizard = new SiriusNewDiagramFileWizard(domainModelURI, diagramRoot, editingDomain);
        wizard.setWindowTitle(NLS.bind(Messages.SiriusInitDiagramFileAction_InitDiagramFileWizardTitle, DDiagramEditPart.MODEL_ID));
        SiriusDiagramEditorUtil.runWizard(getShell(), wizard, "InitDiagramFile"); //$NON-NLS-1$
    }
}
