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

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Absolute Bounds Filter</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> Graphical filter to store absolute bounds. <!--
 * end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.AbsoluteBoundsFilter#getX <em>X</em>}</li>
 * <li>{@link org.eclipse.sirius.AbsoluteBoundsFilter#getY <em>Y</em>}</li>
 * <li>{@link org.eclipse.sirius.AbsoluteBoundsFilter#getHeight <em>Height
 * </em>}</li>
 * <li>{@link org.eclipse.sirius.AbsoluteBoundsFilter#getWidth <em>Width
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getAbsoluteBoundsFilter()
 * @model
 * @generated
 */
public interface AbsoluteBoundsFilter extends GraphicalFilter {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>X</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>X</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>X</em>' attribute.
     * @see #setX(Integer)
     * @see org.eclipse.sirius.SiriusPackage#getAbsoluteBoundsFilter_X()
     * @model
     * @generated
     */
    Integer getX();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.AbsoluteBoundsFilter#getX <em>X</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>X</em>' attribute.
     * @see #getX()
     * @generated
     */
    void setX(Integer value);

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setY(Integer)
     * @see org.eclipse.sirius.SiriusPackage#getAbsoluteBoundsFilter_Y()
     * @model
     * @generated
     */
    Integer getY();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.AbsoluteBoundsFilter#getY <em>Y</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Y</em>' attribute.
     * @see #getY()
     * @generated
     */
    void setY(Integer value);

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(Integer)
     * @see org.eclipse.sirius.SiriusPackage#getAbsoluteBoundsFilter_Height()
     * @model
     * @generated
     */
    Integer getHeight();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.AbsoluteBoundsFilter#getHeight
     * <em>Height</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(Integer value);

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(Integer)
     * @see org.eclipse.sirius.SiriusPackage#getAbsoluteBoundsFilter_Width()
     * @model
     * @generated
     */
    Integer getWidth();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.AbsoluteBoundsFilter#getWidth
     * <em>Width</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth(Integer value);

} // AbsoluteBoundsFilter
