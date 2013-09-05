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
 * <em><b>Meta Model Extension</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> Represent a Meta Model extension. A meta model
 * extension adds types, attributes and references into an existing meta model
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.MetaModelExtension#getExtensionGroup <em>
 * Extension Group</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getMetaModelExtension()
 * @model
 * @generated
 */
public interface MetaModelExtension extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Extension Group</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extension Group</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The referenced meta model
     * extension. It should be an instance of ExtensionGroup. <!-- end-model-doc
     * -->
     * 
     * @return the value of the '<em>Extension Group</em>' reference.
     * @see #setExtensionGroup(EObject)
     * @see org.eclipse.sirius.SiriusPackage#getMetaModelExtension_ExtensionGroup()
     * @model required="true"
     * @generated
     */
    EObject getExtensionGroup();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.MetaModelExtension#getExtensionGroup
     * <em>Extension Group</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Extension Group</em>' reference.
     * @see #getExtensionGroup()
     * @generated
     */
    void setExtensionGroup(EObject value);

} // MetaModelExtension
