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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.description.NavigationTargetType;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Navigation Link</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> A link for a navigable. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.DNavigationLink#getTargetType <em>Target
 * Type</em>}</li>
 * <li>{@link org.eclipse.sirius.DNavigationLink#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getDNavigationLink()
 * @model abstract="true"
 * @generated
 */
public interface DNavigationLink extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Target Type</b></em>' attribute. The
     * literals are from the enumeration
     * {@link org.eclipse.sirius.description.NavigationTargetType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The type of the target.
     * <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Target Type</em>' attribute.
     * @see org.eclipse.sirius.description.NavigationTargetType
     * @see #setTargetType(NavigationTargetType)
     * @see org.eclipse.sirius.SiriusPackage#getNavigationLink_TargetType()
     * @model
     * @generated
     */
    NavigationTargetType getTargetType();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.DNavigationLink#getTargetType
     * <em>Target Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target Type</em>' attribute.
     * @see org.eclipse.sirius.description.NavigationTargetType
     * @see #getTargetType()
     * @generated
     */
    void setTargetType(NavigationTargetType value);

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute. The default
     * value is <code>"link to..."</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The label of the
     * navigation. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.eclipse.sirius.SiriusPackage#getNavigationLink_Label()
     * @model default="link to..."
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.DNavigationLink#getLabel <em>Label</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * Return true if the navigation is available. <!-- end-model-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    boolean isAvailable();

} // DNavigationLink
