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

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>EObject Link</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> A link that references an EObject. <!--
 * end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.DEObjectLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getDEObjectLink()
 * @model
 * @generated
 */
public interface DEObjectLink extends DNavigationLink {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(EObject)
     * @see org.eclipse.sirius.SiriusPackage#getEObjectLink_Target()
     * @model required="true"
     * @generated
     */
    EObject getTarget();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.DEObjectLink#getTarget <em>Target</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(EObject value);

} // DEObjectLink
