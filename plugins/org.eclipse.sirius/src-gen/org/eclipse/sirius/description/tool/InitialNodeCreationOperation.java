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
package org.eclipse.sirius.description.tool;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Initial Node Creation Operation</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.tool.InitialNodeCreationOperation#getFirstModelOperations
 * <em>First Model Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.tool.ToolPackage#getInitialNodeCreationOperation()
 * @model
 * @generated
 */
public interface InitialNodeCreationOperation extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>First Model Operations</b></em>'
     * containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Model Operations</em>' containment
     * reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>First Model Operations</em>' containment
     *         reference.
     * @see #setFirstModelOperations(ModelOperation)
     * @see org.eclipse.sirius.description.tool.ToolPackage#getInitialNodeCreationOperation_FirstModelOperations()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    ModelOperation getFirstModelOperations();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.tool.InitialNodeCreationOperation#getFirstModelOperations
     * <em>First Model Operations</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>First Model Operations</em>'
     *            containment reference.
     * @see #getFirstModelOperations()
     * @generated
     */
    void setFirstModelOperations(ModelOperation value);

} // InitialNodeCreationOperation
