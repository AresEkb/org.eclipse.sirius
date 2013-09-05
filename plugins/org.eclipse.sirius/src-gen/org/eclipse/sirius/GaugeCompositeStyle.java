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
package org.eclipse.sirius;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Gauge Composite Style</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> This style groups many GaugeSection. <!--
 * end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.GaugeCompositeStyle#getAlignment <em>
 * Alignment</em>}</li>
 * <li>{@link org.eclipse.sirius.GaugeCompositeStyle#getSections <em>Sections
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getGaugeCompositeStyle()
 * @model
 * @generated
 */
public interface GaugeCompositeStyle extends NodeStyle {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Alignment</b></em>' attribute. The
     * default value is <code>"SQUARE"</code>. The literals are from the
     * enumeration {@link org.eclipse.sirius.AlignmentKind}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alignment</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The alignment of the
     * gauges <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Alignment</em>' attribute.
     * @see org.eclipse.sirius.AlignmentKind
     * @see #setAlignment(AlignmentKind)
     * @see org.eclipse.sirius.SiriusPackage#getGaugeCompositeStyle_Alignment()
     * @model default="SQUARE"
     * @generated
     */
    AlignmentKind getAlignment();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.GaugeCompositeStyle#getAlignment
     * <em>Alignment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Alignment</em>' attribute.
     * @see org.eclipse.sirius.AlignmentKind
     * @see #getAlignment()
     * @generated
     */
    void setAlignment(AlignmentKind value);

    /**
     * Returns the value of the '<em><b>Sections</b></em>' containment reference
     * list. The list contents are of type
     * {@link org.eclipse.sirius.GaugeSection}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sections</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The sections. <!--
     * end-model-doc -->
     * 
     * @return the value of the '<em>Sections</em>' containment reference list.
     * @see org.eclipse.sirius.SiriusPackage#getGaugeCompositeStyle_Sections()
     * @model type="viewpoint.GaugeSection" containment="true"
     *        resolveProxies="true"
     * @generated
     */
    EList<GaugeSection> getSections();

} // GaugeCompositeStyle
