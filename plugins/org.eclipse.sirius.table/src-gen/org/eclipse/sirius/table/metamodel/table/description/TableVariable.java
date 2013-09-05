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
package org.eclipse.sirius.table.metamodel.table.description;

import org.eclipse.sirius.description.tool.AbstractVariable;
import org.eclipse.sirius.description.tool.VariableContainer;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Table Variable</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.TableVariable#getDocumentation
 * <em>Documentation</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage#getTableVariable()
 * @model
 * @generated
 */
public interface TableVariable extends AbstractVariable, VariableContainer {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation\n";

    /**
     * Returns the value of the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Documentation</em>' attribute.
     * @see #setDocumentation(String)
     * @see org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage#getTableVariable_Documentation()
     * @model
     * @generated
     */
    String getDocumentation();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.table.metamodel.table.description.TableVariable#getDocumentation
     * <em>Documentation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Documentation</em>' attribute.
     * @see #getDocumentation()
     * @generated
     */
    void setDocumentation(String value);

} // TableVariable
