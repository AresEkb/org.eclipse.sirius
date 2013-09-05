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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.sirius.description.style.StylePackage
 * @generated
 */
public interface StyleFactory extends EFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    StyleFactory eINSTANCE = org.eclipse.sirius.description.style.impl.StyleFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Bordered Style Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Bordered Style Description</em>'.
     * @generated
     */
    BorderedStyleDescription createBorderedStyleDescription();

    /**
     * Returns a new object of class '<em>Basic Label Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Basic Label Style Description</em>'.
     * @generated
     */
    BasicLabelStyleDescription createBasicLabelStyleDescription();

    /**
     * Returns a new object of class '<em>Label Style Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Label Style Description</em>'.
     * @generated
     */
    LabelStyleDescription createLabelStyleDescription();

    /**
     * Returns a new object of class '<em>Label Border Styles</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Label Border Styles</em>'.
     * @generated
     */
    LabelBorderStyles createLabelBorderStyles();

    /**
     * Returns a new object of class '<em>Label Border Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Label Border Style Description</em>'.
     * @generated
     */
    LabelBorderStyleDescription createLabelBorderStyleDescription();

    /**
     * Returns a new object of class '<em>Custom Style Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Custom Style Description</em>'.
     * @generated
     */
    CustomStyleDescription createCustomStyleDescription();

    /**
     * Returns a new object of class '<em>Square Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Square Description</em>'.
     * @generated
     */
    SquareDescription createSquareDescription();

    /**
     * Returns a new object of class '<em>Bundled Image Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Bundled Image Description</em>'.
     * @generated
     */
    BundledImageDescription createBundledImageDescription();

    /**
     * Returns a new object of class '<em>Note Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Note Description</em>'.
     * @generated
     */
    NoteDescription createNoteDescription();

    /**
     * Returns a new object of class '<em>Dot Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Dot Description</em>'.
     * @generated
     */
    DotDescription createDotDescription();

    /**
     * Returns a new object of class '<em>Gauge Composite Style Description</em>
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Gauge Composite Style Description</em>
     *         '.
     * @generated
     */
    GaugeCompositeStyleDescription createGaugeCompositeStyleDescription();

    /**
     * Returns a new object of class '<em>Flat Container Style Description</em>
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Flat Container Style Description</em>
     *         '.
     * @generated
     */
    FlatContainerStyleDescription createFlatContainerStyleDescription();

    /**
     * Returns a new object of class '<em>Shape Container Style Description</em>
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Shape Container Style Description</em>
     *         '.
     * @generated
     */
    ShapeContainerStyleDescription createShapeContainerStyleDescription();

    /**
     * Returns a new object of class '<em>Workspace Image Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Workspace Image Description</em>'.
     * @generated
     */
    WorkspaceImageDescription createWorkspaceImageDescription();

    /**
     * Returns a new object of class '<em>Edge Style Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Edge Style Description</em>'.
     * @generated
     */
    EdgeStyleDescription createEdgeStyleDescription();

    /**
     * Returns a new object of class '<em>Bracket Edge Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Bracket Edge Style Description</em>'.
     * @generated
     */
    BracketEdgeStyleDescription createBracketEdgeStyleDescription();

    /**
     * Returns a new object of class '<em>Tooltip Style Description</em>'. <!--
     * begin-user-doc -->
     * 
     * @since 2.0 <!-- end-user-doc -->
     * @return a new object of class '<em>Tooltip Style Description</em>'.
     * @generated
     */
    TooltipStyleDescription createTooltipStyleDescription();

    /**
     * Returns a new object of class '<em>Gauge Section Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Gauge Section Description</em>'.
     * @generated
     */
    GaugeSectionDescription createGaugeSectionDescription();

    /**
     * Returns a new object of class '<em>Begin Label Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Begin Label Style Description</em>'.
     * @generated
     */
    BeginLabelStyleDescription createBeginLabelStyleDescription();

    /**
     * Returns a new object of class '<em>Center Label Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Center Label Style Description</em>'.
     * @generated
     */
    CenterLabelStyleDescription createCenterLabelStyleDescription();

    /**
     * Returns a new object of class '<em>End Label Style Description</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>End Label Style Description</em>'.
     * @generated
     */
    EndLabelStyleDescription createEndLabelStyleDescription();

    /**
     * Returns a new object of class '<em>Ellipse Node Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Ellipse Node Description</em>'.
     * @generated
     */
    EllipseNodeDescription createEllipseNodeDescription();

    /**
     * Returns a new object of class '<em>Lozenge Node Description</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Lozenge Node Description</em>'.
     * @generated
     */
    LozengeNodeDescription createLozengeNodeDescription();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    StylePackage getStylePackage();

} // StyleFactory
