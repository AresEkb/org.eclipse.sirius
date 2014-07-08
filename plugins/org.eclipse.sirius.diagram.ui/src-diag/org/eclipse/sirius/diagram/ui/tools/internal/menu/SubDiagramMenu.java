/*******************************************************************************
 * Copyright (c) 2007, 2014 THALES GLOBAL SERVICES and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.menu;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.ui.services.action.internal.contributionitem.IContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.NoteEditPart;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.ui.edit.api.part.ISiriusEditPart;
import org.eclipse.sirius.diagram.ui.part.SiriusDiagramEditor;
import org.eclipse.sirius.diagram.ui.tools.internal.actions.CreateRepresentationFromRepresentationCreationDescription;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.tool.RepresentationCreationDescription;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This menu contribution add a "create" menu in the DDiagram diagram editor.
 * 
 * @author cbrun
 * 
 */
public class SubDiagramMenu implements IContributionItemProvider {

    private static final String CREATE_REPRESENTATION_GROUP_SEPARATOR = "createRepresentationGroup";

    /**
     * {@inheritDoc}
     */
    public void contributeToActionBars(final IActionBars arg0, final IWorkbenchPartDescriptor arg1) {
        // Nothing to contribute

    }

    /**
     * {@inheritDoc}
     */
    public void contributeToPopupMenu(final IMenuManager menu, final IWorkbenchPart part) {

        if (part instanceof SiriusDiagramEditor) {

            final SiriusDiagramEditor diagrampart = (SiriusDiagramEditor) part;

            final EditPart editpart = diagrampart.getDiagramGraphicalViewer().getFocusEditPart();

            if (editpart instanceof IGraphicalEditPart && !(editpart instanceof NoteEditPart)) {
                final IGraphicalEditPart curPart = (IGraphicalEditPart) editpart;
                final EObject eObj = curPart.resolveSemanticElement();
                // Deletion of semantic elements when automatic
                // refresh is off causes exceptions
                // ensuring that semantic element is valid
                if (eObj instanceof DRepresentationElement) {
                    EObject target = ((DRepresentationElement) eObj).getTarget();
                    if (target == null || target.eResource() == null) {
                        return;
                    }
                }
                if (editpart instanceof ISiriusEditPart) {
                    final IMenuManager navigate = (IMenuManager) menu.find("navigateMenu");
                    final Separator createGroup = new Separator(CREATE_REPRESENTATION_GROUP_SEPARATOR);
                    navigate.add(createGroup);
                    if (eObj instanceof DDiagramElement) {
                        createDetailsActions((DDiagramElement) eObj, navigate, diagrampart.getEditingDomain(), curPart);
                    }
                } else {
                    // no focused edit part
                }
            }
        }

    }

    private boolean isFromActiveSirius(final Session session, final RepresentationDescription description) {
        final Viewpoint vp = ViewpointRegistry.getInstance().getViewpoint(description);
        return vp != null && session.getSelectedViewpoints(false).contains(vp);
    }

    private void createDetailsActions(final DDiagramElement dde, final IMenuManager navigate, final TransactionalEditingDomain editingDomain, final IGraphicalEditPart curPart) {
        if (dde.getMapping() != null) {
            for (RepresentationCreationDescription desc : dde.getMapping().getDetailDescriptions()) {
                boolean append = true;

                final EList<EObject> semanticElements = dde.getSemanticElements();
                if (semanticElements != null && !semanticElements.isEmpty()) {
                    final Session session = SessionManager.INSTANCE.getSession(semanticElements.get(0));
                    if (!isFromActiveSirius(session, desc.getRepresentationDescription())) {
                        append = false;
                    }
                } else if (dde.getTarget() != null) {
                    final Session session = SessionManager.INSTANCE.getSession(dde.getTarget());
                    if (!isFromActiveSirius(session, desc.getRepresentationDescription())) {
                        append = false;
                    }
                }

                final String precondition = desc.getPrecondition();
                if (append && precondition != null && !StringUtil.isEmpty(precondition.trim())) {
                    append = false;
                    final IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(dde);
                    try {
                        append = interpreter.evaluateBoolean(dde.getTarget(), precondition);
                    } catch (final EvaluationException e) {
                        // do nothing
                    }
                }
                if (append) {
                    navigate.appendToGroup(CREATE_REPRESENTATION_GROUP_SEPARATOR, new CreateRepresentationFromRepresentationCreationDescription(desc, dde, editingDomain, curPart));
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void disposeContributions(final IWorkbenchPartDescriptor arg0) {
        // Nothing to contribute

    }

    /**
     * {@inheritDoc}
     */
    public void updateActionBars(final IActionBars arg0, final IWorkbenchPartDescriptor arg1) {
        // Nothing to contribute

    }

    /**
     * {@inheritDoc}
     */
    public void addProviderChangeListener(final IProviderChangeListener arg0) {
        // Nothing to contribute

    }

    /**
     * {@inheritDoc}
     */
    public boolean provides(final IOperation arg0) {
        // Always provide
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void removeProviderChangeListener(final IProviderChangeListener arg0) {
        // Nothing to contribute

    }

}
