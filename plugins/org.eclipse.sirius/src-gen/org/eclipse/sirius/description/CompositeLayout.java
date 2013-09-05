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
package org.eclipse.sirius.description;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Composite Layout</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.description.CompositeLayout#getPadding <em>
 * Padding</em>}</li>
 * <li>{@link org.eclipse.sirius.description.CompositeLayout#getDirection
 * <em>Direction</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.DescriptionPackage#getCompositeLayout()
 * @model
 * @generated
 */
public interface CompositeLayout extends Layout {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Padding</b></em>' attribute. The default
     * value is <code>"30"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Padding</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Padding</em>' attribute.
     * @see #setPadding(int)
     * @see org.eclipse.sirius.description.DescriptionPackage#getCompositeLayout_Padding()
     * @model default="30" required="true"
     * @generated
     */
    int getPadding();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.CompositeLayout#getPadding
     * <em>Padding</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Padding</em>' attribute.
     * @see #getPadding()
     * @generated
     */
    void setPadding(int value);

    /**
     * Returns the value of the '<em><b>Direction</b></em>' attribute. The
     * default value is <code>"30"</code>. The literals are from the enumeration
     * {@link org.eclipse.sirius.description.LayoutDirection}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Direction</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Direction</em>' attribute.
     * @see org.eclipse.sirius.description.LayoutDirection
     * @see #setDirection(LayoutDirection)
     * @see org.eclipse.sirius.description.DescriptionPackage#getCompositeLayout_Direction()
     * @model default="30" required="true"
     * @generated
     */
    LayoutDirection getDirection();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.CompositeLayout#getDirection
     * <em>Direction</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Direction</em>' attribute.
     * @see org.eclipse.sirius.description.LayoutDirection
     * @see #getDirection()
     * @generated
     */
    void setDirection(LayoutDirection value);

} // CompositeLayout
