/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.tools.internal.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.swt.graphics.Color;

import com.google.common.collect.Iterables;

import org.eclipse.sirius.BorderedStyle;
import org.eclipse.sirius.DStylizable;
import org.eclipse.sirius.RGBValues;
import org.eclipse.sirius.description.style.LabelBorderStyleDescription;
import org.eclipse.sirius.diagram.tools.api.graphical.edit.styles.IContainerLabelOffsets;
import org.eclipse.sirius.diagram.ui.tools.api.figure.ViewNodeContainerFigureDesc;
import org.eclipse.sirius.diagram.ui.tools.api.figure.SiriusWrapLabel;

/**
 * A figure that draw a line around the container label to represent a title
 * block.
 * 
 * @author smonnier
 */
public class ContainerWithTitleBlockFigure extends DefaultSizeNodeFigure {

    private static final int ACCEPTED_POSITION_DELTA = 3;

    private DStylizable viewNode;

    private LabelBorderStyleDescription labelBorderStyleDescription;

    /**
     * Create a new {@link ContainerWithTitleBlockFigure}.
     * 
     * @param width
     *            the width.
     * @param height
     *            the height.
     * @param viewNode
     *            the node.
     * @param labelBorderStyleDescription
     *            the LabelBorderStyleDescription.
     */
    public ContainerWithTitleBlockFigure(int width, int height, DStylizable viewNode, LabelBorderStyleDescription labelBorderStyleDescription) {
        super(width, height);
        this.viewNode = viewNode;
        this.labelBorderStyleDescription = labelBorderStyleDescription;
    }

    /**
     * This method is overridden to draw a line over the border node.
     * 
     * {@inheritDoc}
     */
    @Override
    protected void paintBorder(Graphics graphics) {
        super.paintBorder(graphics);
        Rectangle rect = getBounds().getCopy();
        graphics.setLineStyle(Graphics.LINE_SOLID);
        graphics.setLineWidth(getBorderWidth());
        graphics.setForegroundColor(geBorderColor());

        Iterable<ViewNodeContainerFigureDesc> filter = Iterables.filter(getChildren(), ViewNodeContainerFigureDesc.class);
        if (Iterables.size(filter) == 1) {
            ViewNodeContainerFigureDesc child = filter.iterator().next();
            SiriusWrapLabel containerLabelFigure = child.getLabelFigure();

            if (containerLabelFigure != null && LabelBorderStyleIds.getLabelBorderStyleWithBeveledCornersIds().equals(labelBorderStyleDescription.getId())) {
                Rectangle containerLabelFigureBounds = containerLabelFigure.getBounds();
                // Only LabelBorderStyleWithBeveledCorner is supported has
                // LabelBorderStyleDescription
                paintTitleBlockOnLabel(graphics, rect, containerLabelFigureBounds);
            }
        }
    }

    /**
     * Finds where is located the label in the container.
     * 
     * @param graphics
     *            the Graphics that draw lines
     * @param container
     *            the parent container
     * @param label
     *            the label to draw a border around
     */
    private void paintTitleBlockOnLabel(Graphics graphics, Rectangle container, Rectangle label) {
        if (container.getLeft().x == label.getLeft().x) {
            paintTitleBlockOnLabelOnLeft(graphics, label);
        } else if (Math.abs(container.getCenter().x - label.getCenter().x) <= ACCEPTED_POSITION_DELTA) {
            paintTitleBlockOnCenteredLabel(graphics, label);
        } else if (Math.abs(container.getRight().x - label.getRight().x) <= ACCEPTED_POSITION_DELTA) {
            paintTitleBlockOnLabelOnRight(graphics, label);
        }
    }

    /**
     * Calculate the PointLists corresponding to the west border.
     * 
     * @param label
     *            the label to draw a border around
     * @return the PointLists corresponding to the west border.
     */
    private PointList paintTitleBlockOnLabelWest(Rectangle label) {
        int cornerHeight = labelBorderStyleDescription.getCornerHeight();
        int cornerWidth = labelBorderStyleDescription.getCornerWidth();
        PointList pointList = new PointList();
        // Draw west vertical line
        pointList.addPoint(label.x - cornerWidth, label.y - IContainerLabelOffsets.LABEL_OFFSET);
        pointList.addPoint(label.x - cornerWidth, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET - cornerHeight);
        // Draw west corner
        pointList.addPoint(label.x - cornerWidth, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET - cornerHeight);
        pointList.addPoint(label.x, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET);
        return pointList;
    }

    /**
     * Calculate the PointLists corresponding to the south border.
     * 
     * @param label
     *            the label to draw a border around
     * @return the PointLists corresponding to the south border.
     */
    private PointList paintTitleBlockOnLabelSouth(Rectangle label) {
        PointList pointList = new PointList();
        // Draw horizontal line
        pointList.addPoint(label.x, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET);
        pointList.addPoint(label.x + label.width, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET);
        return pointList;
    }

    /**
     * Calculate the PointLists corresponding to the east border.
     * 
     * @param label
     *            the label to draw a border around
     * @return the PointLists corresponding to the east border.
     */
    private PointList paintTitleBlockOnLabelEast(Rectangle label) {
        int cornerHeight = labelBorderStyleDescription.getCornerHeight();
        int cornerWidth = labelBorderStyleDescription.getCornerWidth();
        PointList pointList = new PointList();
        // Draw east corner
        pointList.addPoint(label.x + label.width, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET);
        pointList.addPoint(label.x + label.width + cornerWidth, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET - cornerHeight);
        // Draw east vertical line
        pointList.addPoint(label.x + label.width + cornerWidth, label.y + label.height + IContainerLabelOffsets.LABEL_OFFSET - cornerHeight);
        pointList.addPoint(label.x + label.width + cornerWidth, label.y - IContainerLabelOffsets.LABEL_OFFSET);
        return pointList;
    }

    /**
     * Paint a border when the label is on the left of its container.
     * 
     * @param graphics
     *            the Graphics that draw lines
     * @param label
     *            the label to draw a border around
     */
    private void paintTitleBlockOnLabelOnLeft(Graphics graphics, Rectangle label) {
        PointList pointList = new PointList();
        pointList.addAll(paintTitleBlockOnLabelSouth(label));
        pointList.addAll(paintTitleBlockOnLabelEast(label));
        graphics.drawPolyline(pointList);
    }

    /**
     * Paint a border when the label is centered of its container.
     * 
     * @param graphics
     *            the Graphics that draw lines
     * @param label
     *            the label to draw a border around
     */
    private void paintTitleBlockOnCenteredLabel(Graphics graphics, Rectangle label) {
        PointList pointList = new PointList();
        pointList.addAll(paintTitleBlockOnLabelWest(label));
        pointList.addAll(paintTitleBlockOnLabelSouth(label));
        pointList.addAll(paintTitleBlockOnLabelEast(label));
        graphics.drawPolyline(pointList);
    }

    /**
     * Paint a border when the label is on the right of its container.
     * 
     * @param graphics
     *            the Graphics that draw lines
     * @param label
     *            the label to draw a border around
     */
    private void paintTitleBlockOnLabelOnRight(Graphics graphics, Rectangle label) {
        PointList pointList = new PointList();
        pointList.addAll(paintTitleBlockOnLabelWest(label));
        pointList.addAll(paintTitleBlockOnLabelSouth(label));
        graphics.drawPolyline(pointList);
    }

    /**
     * Investigate the border color of the DDiagramElement to use it as the
     * color of the title block.
     * 
     * @return the defined color of the title block
     */
    private Color geBorderColor() {
        if (viewNode.getStyle() instanceof BorderedStyle) {
            RGBValues borderColor = ((BorderedStyle) viewNode.getStyle()).getBorderColor();
            return new Color(null, borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue());
        }
        return ColorConstants.black;
    }

    /**
     * Investigate the border size of the DDiagramElement to use it as the width
     * of the title block.
     * 
     * @return the defined width of the title block
     */
    public int getBorderWidth() {
        if (viewNode.getStyle() instanceof BorderedStyle) {
            // The title block width must value at least 1
            return Math.max(((BorderedStyle) viewNode.getStyle()).getBorderSize(), 1);
        }
        return 1;
    }
}
