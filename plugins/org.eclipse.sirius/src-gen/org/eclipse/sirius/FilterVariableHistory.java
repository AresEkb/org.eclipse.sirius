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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Filter Variable History</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.FilterVariableHistory#getOwnedValues <em>
 * Owned Values</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getFilterVariableHistory()
 * @model
 * @generated
 */
public interface FilterVariableHistory extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Owned Values</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.eclipse.sirius.FilterVariableValue}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Owned Values</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Owned Values</em>' containment reference
     *         list.
     * @see org.eclipse.sirius.SiriusPackage#getFilterVariableHistory_OwnedValues()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<FilterVariableValue> getOwnedValues();

} // FilterVariableHistory
