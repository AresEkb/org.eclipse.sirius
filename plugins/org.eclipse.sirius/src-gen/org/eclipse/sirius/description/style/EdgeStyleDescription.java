/*******************************************************************************
 * Copyright (c) 2007-2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.description.style;

import org.eclipse.sirius.EdgeArrows;
import org.eclipse.sirius.EdgeRouting;
import org.eclipse.sirius.LineStyle;
import org.eclipse.sirius.description.ColorDescription;
import org.eclipse.sirius.description.FoldingStyle;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Edge Style Description</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> The style of an edge. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getStrokeColor
 * <em>Stroke Color</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getLineStyle
 * <em>Line Style</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getSourceArrow
 * <em>Source Arrow</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getTargetArrow
 * <em>Target Arrow</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getSizeComputationExpression
 * <em>Size Computation Expression</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getRoutingStyle
 * <em>Routing Style</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getFoldingStyle
 * <em>Folding Style</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getBeginLabelStyleDescription
 * <em>Begin Label Style Description</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getCenterLabelStyleDescription
 * <em>Center Label Style Description</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getEndLabelStyleDescription
 * <em>End Label Style Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription()
 * @model
 * @generated
 */
public interface EdgeStyleDescription extends StyleDescription {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Stroke Color</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> The color of the edge. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Stroke Color</em>' containment reference.
     * @see #setStrokeColor(ColorMapping)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_StrokeColor()
     * @model required="true"
     * @generated
     */
    ColorDescription getStrokeColor();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getStrokeColor
     * <em>Stroke Color</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Stroke Color</em>' reference.
     * @see #getStrokeColor()
     * @generated
     */
    void setStrokeColor(ColorDescription value);

    /**
     * Returns the value of the '<em><b>Line Style</b></em>' attribute. The
     * literals are from the enumeration {@link org.eclipse.sirius.LineStyle}
     * . <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * The style of the line. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Line Style</em>' attribute.
     * @see org.eclipse.sirius.LineStyle
     * @see #setLineStyle(LineStyle)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_LineStyle()
     * @model
     * @generated
     */
    LineStyle getLineStyle();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getLineStyle
     * <em>Line Style</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Line Style</em>' attribute.
     * @see org.eclipse.sirius.LineStyle
     * @see #getLineStyle()
     * @generated
     */
    void setLineStyle(LineStyle value);

    /**
     * Returns the value of the '<em><b>Source Arrow</b></em>' attribute. The
     * default value is <code>"NoDecoration"</code>. The literals are from the
     * enumeration {@link org.eclipse.sirius.EdgeArrows}. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> The source decoration.
     * <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Source Arrow</em>' attribute.
     * @see org.eclipse.sirius.EdgeArrows
     * @see #setSourceArrow(EdgeArrows)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_SourceArrow()
     * @model default="NoDecoration" required="true"
     * @generated
     */
    EdgeArrows getSourceArrow();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getSourceArrow
     * <em>Source Arrow</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source Arrow</em>' attribute.
     * @see org.eclipse.sirius.EdgeArrows
     * @see #getSourceArrow()
     * @generated
     */
    void setSourceArrow(EdgeArrows value);

    /**
     * Returns the value of the '<em><b>Target Arrow</b></em>' attribute. The
     * default value is <code>"OutputArrow"</code>. The literals are from the
     * enumeration {@link org.eclipse.sirius.EdgeArrows}. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> The target decoration.
     * <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Target Arrow</em>' attribute.
     * @see org.eclipse.sirius.EdgeArrows
     * @see #setTargetArrow(EdgeArrows)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_TargetArrow()
     * @model default="OutputArrow" required="true"
     * @generated
     */
    EdgeArrows getTargetArrow();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getTargetArrow
     * <em>Target Arrow</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target Arrow</em>' attribute.
     * @see org.eclipse.sirius.EdgeArrows
     * @see #getTargetArrow()
     * @generated
     */
    void setTargetArrow(EdgeArrows value);

    /**
     * Returns the value of the '<em><b>Size Computation Expression</b></em>'
     * attribute. The default value is <code>"<%eContents().nSize%>"</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * The acceleo expression that computes the width of the link. <!--
     * end-model-doc -->
     * 
     * @return the value of the '<em>Size Computation Expression</em>'
     *         attribute.
     * @see #setSizeComputationExpression(String)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_SizeComputationExpression()
     * @model default="<%eContents().nSize%>"
     *        dataType="org.eclipse.sirius.description.AcceleoExpression"
     * @generated
     */
    String getSizeComputationExpression();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getSizeComputationExpression
     * <em>Size Computation Expression</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Size Computation Expression</em>'
     *            attribute.
     * @see #getSizeComputationExpression()
     * @generated
     */
    void setSizeComputationExpression(String value);

    /**
     * Returns the value of the '<em><b>Routing Style</b></em>' attribute. The
     * default value is <code>"straight"</code>. The literals are from the
     * enumeration {@link org.eclipse.sirius.EdgeRouting}. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
     * routing style. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Routing Style</em>' attribute.
     * @see org.eclipse.sirius.EdgeRouting
     * @see #setRoutingStyle(EdgeRouting)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_RoutingStyle()
     * @model default="straight" required="true"
     * @generated
     */
    EdgeRouting getRoutingStyle();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getRoutingStyle
     * <em>Routing Style</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Routing Style</em>' attribute.
     * @see org.eclipse.sirius.EdgeRouting
     * @see #getRoutingStyle()
     * @generated
     */
    void setRoutingStyle(EdgeRouting value);

    /**
     * Returns the value of the '<em><b>Folding Style</b></em>' attribute. The
     * literals are from the enumeration
     * {@link org.eclipse.sirius.description.FoldingStyle}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Folding Style</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Folding Style</em>' attribute.
     * @see org.eclipse.sirius.description.FoldingStyle
     * @see #setFoldingStyle(FoldingStyle)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_FoldingStyle()
     * @model
     * @generated
     */
    FoldingStyle getFoldingStyle();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getFoldingStyle
     * <em>Folding Style</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Folding Style</em>' attribute.
     * @see org.eclipse.sirius.description.FoldingStyle
     * @see #getFoldingStyle()
     * @generated
     */
    void setFoldingStyle(FoldingStyle value);

    /**
     * Returns the value of the '<em><b>Begin Label Style Description</b></em>'
     * containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Begin Label Style Description</em>'
     * containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Begin Label Style Description</em>'
     *         containment reference.
     * @see #setBeginLabelStyleDescription(BeginLabelStyleDescription)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_BeginLabelStyleDescription()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    BeginLabelStyleDescription getBeginLabelStyleDescription();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getBeginLabelStyleDescription
     * <em>Begin Label Style Description</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Begin Label Style Description</em>'
     *            containment reference.
     * @see #getBeginLabelStyleDescription()
     * @generated
     */
    void setBeginLabelStyleDescription(BeginLabelStyleDescription value);

    /**
     * Returns the value of the '<em><b>Center Label Style Description</b></em>'
     * containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Center Label Style Description</em>'
     * containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Center Label Style Description</em>'
     *         containment reference.
     * @see #setCenterLabelStyleDescription(CenterLabelStyleDescription)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_CenterLabelStyleDescription()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    CenterLabelStyleDescription getCenterLabelStyleDescription();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getCenterLabelStyleDescription
     * <em>Center Label Style Description</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Center Label Style Description</em>'
     *            containment reference.
     * @see #getCenterLabelStyleDescription()
     * @generated
     */
    void setCenterLabelStyleDescription(CenterLabelStyleDescription value);

    /**
     * Returns the value of the '<em><b>End Label Style Description</b></em>'
     * containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Label Style Description</em>' containment
     * reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>End Label Style Description</em>'
     *         containment reference.
     * @see #setEndLabelStyleDescription(EndLabelStyleDescription)
     * @see org.eclipse.sirius.description.style.StylePackage#getEdgeStyleDescription_EndLabelStyleDescription()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EndLabelStyleDescription getEndLabelStyleDescription();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.style.EdgeStyleDescription#getEndLabelStyleDescription
     * <em>End Label Style Description</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>End Label Style Description</em>'
     *            containment reference.
     * @see #getEndLabelStyleDescription()
     * @generated
     */
    void setEndLabelStyleDescription(EndLabelStyleDescription value);

} // EdgeStyleDescription
