/*******************************************************************************
 * Copyright (c) 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.tools.api.control;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.sirius.business.api.control.SiriusUncontrolCommand;
import org.eclipse.sirius.provider.SiriusEditPlugin;

/**
 * Implements the UI part of the "Uncontrol" operation. This class gathers the
 * required parameters from the user and the invokes the properly configured
 * {@link org.eclipse.sirius.business.internal.command.control.UncontrolCommand}
 * .
 * 
 * @since 2.1.0
 * 
 * @author pcdavid
 */
public class SiriusUncontrolHandler extends AbstractHandler {
    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final EObject semanticRoot = getSelectedEObject(event);
        if (semanticRoot != null) {
            try {
                new ProgressMonitorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell()).run(false, false, new WorkspaceModifyOperation() {

                    @Override
                    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
                        try {
                            monitor.beginTask("Uncontrol resources", 1);
                            performUncontrol(HandlerUtil.getActiveShell(event), semanticRoot, new SubProgressMonitor(monitor, 1));
                        } finally {
                            monitor.done();
                        }
                    }
                });
            } catch (InvocationTargetException e) {
                SiriusEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, SiriusEditPlugin.ID, e.getLocalizedMessage(), e));
            } catch (InterruptedException e) {
                SiriusEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, SiriusEditPlugin.ID, e.getLocalizedMessage(), e));
            }

        }
        return null;
    }

    /**
     * Performs the uncontrol operation.
     * 
     * @param shell
     *            the shell to use to interact with users.
     * @param semanticRoot
     *            the semantic root element to uncontrol.
     * @deprecated use
     *             {@link SiriusUncontrolHandler#performUncontrol(Shell, EObject, IProgressMonitor)}
     *             instead
     */
    public void performUncontrol(final Shell shell, final EObject semanticRoot) {
        performUncontrol(shell, semanticRoot, new NullProgressMonitor());
    }

    /**
     * Performs the uncontrol operation.
     * 
     * @param shell
     *            the shell to use to interact with users.
     * @param semanticRoot
     *            the semantic root element to uncontrol.
     * @param monitor
     *            a {@link IProgressMonitor} to show progression of uncontrol
     */
    public void performUncontrol(final Shell shell, final EObject semanticRoot, IProgressMonitor monitor) {
        final boolean uncontrolRepresentations = shouldUncontrolRepresentations(shell);
        Command vuc = new SiriusUncontrolCommand(semanticRoot, uncontrolRepresentations, new SubProgressMonitor(monitor, 1));
        TransactionUtil.getEditingDomain(semanticRoot).getCommandStack().execute(vuc);
    }

    /**
     * Show dialog to uncontrol or not the representations.
     * 
     * @param shell
     *            the shell to use to interact with users.
     * @return if the representations are uncontrolled
     */
    protected boolean shouldUncontrolRepresentations(final Shell shell) {
        return MessageDialog.openQuestion(shell, "Uncontrol representations?", "Do you want to uncontrol representations in addition to the semantic elements?");
    }

    private EObject getSelectedEObject(final ExecutionEvent event) {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection) {
            final IStructuredSelection iss = (IStructuredSelection) selection;
            final Object obj = iss.getFirstElement();
            if (obj instanceof EObject) {
                return (EObject) obj;
            }
        }
        return null;
    }
}
