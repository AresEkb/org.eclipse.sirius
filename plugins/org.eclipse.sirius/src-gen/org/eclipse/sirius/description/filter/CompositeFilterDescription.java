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
package org.eclipse.sirius.description.filter;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Composite Filter Description</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> A composite filter description. <!-- end-model-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.filter.CompositeFilterDescription#getFilters
 * <em>Filters</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.filter.FilterPackage#getCompositeFilterDescription()
 * @model
 * @generated
 */
public interface CompositeFilterDescription extends FilterDescription {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Filters</b></em>' containment reference
     * list. The list contents are of type
     * {@link org.eclipse.sirius.description.filter.Filter}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filters</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> All filters. <!--
     * end-model-doc -->
     * 
     * @return the value of the '<em>Filters</em>' containment reference list.
     * @see org.eclipse.sirius.description.filter.FilterPackage#getCompositeFilterDescription_Filters()
     * @model type="viewpoint.description.filter.Filter" containment="true"
     *        resolveProxies="true" required="true"
     * @generated
     */
    EList<Filter> getFilters();

} // CompositeFilterDescription
