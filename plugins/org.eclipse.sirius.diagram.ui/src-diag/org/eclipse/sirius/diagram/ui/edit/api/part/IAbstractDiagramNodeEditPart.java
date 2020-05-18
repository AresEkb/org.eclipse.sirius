/*******************************************************************************
 * Copyright (c) 2007, 2008, 2009 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.diagram.ui.edit.api.part;

import java.util.function.Supplier;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderedShapeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.ext.gmf.runtime.gef.ui.figures.SiriusWrapLabel;

/**
 * This type regroups all nodes of the Diagram (DNodes, DContainer, DList).
 * 
 * @author ymortier
 */
public interface IAbstractDiagramNodeEditPart extends IDiagramElementEditPart, IBorderedShapeEditPart {

    /**
     * Returns the label of the node.
     * 
     * @return the label of the node.
     * @since 3.1
     */
    SiriusWrapLabel getNodeLabel();

    /**
     * Create a {@link IBorderItemLocator} for the specified figure.
     * 
     * @param figure
     *            the figure.
     * @param vpElementBorderItem
     *            the view point element to add on the border.
     * @return a {@link IBorderItemLocator} for the specified figure.
     */
    IBorderItemLocator createBorderItemLocator(IFigure figure, DDiagramElement vpElementBorderItem);

    /**
     * Sets the text of the element's tooltip.
     * 
     * @param text
     *            the text to show in the tooltip. If <code>null</code> or the empty string, the element's tooltip is
     *            disabled.
     * @since 0.9.0
     * @deprecated Use {@link #setTooltipTextProvider(Supplier)}
     */
    @Deprecated
    void setTooltipText(String text);

    /**
     * Sets the text of the element's tooltip.
     * 
     * @param textSupplier
     *            the supplier from which to obtain the text to show in the tooltip. If it returns <code>null</code> or
     *            the empty string, the element's tooltip is disabled.
     * @since 6.4.0
     */
    void setTooltipTextProvider(Supplier<String> textSupplier);

    /**
     * Get the zoom manager.
     * 
     * @return the zoom manager
     */
    ZoomManager getZoomManager();
}
