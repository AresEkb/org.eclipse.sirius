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

import org.eclipse.emf.common.util.EList;

import org.eclipse.sirius.description.tool.RepresentationCreationDescription;
import org.eclipse.sirius.description.tool.RepresentationNavigationDescription;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Representation Element Mapping</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationElementMapping#getDetailDescriptions
 * <em>Detail Descriptions</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationElementMapping#getNavigationDescriptions
 * <em>Navigation Descriptions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationElementMapping()
 * @model abstract="true"
 * @generated
 */
public interface RepresentationElementMapping extends IdentifiedElement {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Detail Descriptions</b></em>' reference
     * list. The list contents are of type
     * {@link org.eclipse.sirius.description.tool.RepresentationCreationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * All details that can be created from this node. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Detail Descriptions</em>' reference list.
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationElementMapping_DetailDescriptions()
     * @model
     * @generated
     */
    EList<RepresentationCreationDescription> getDetailDescriptions();

    /**
     * Returns the value of the '<em><b>Navigation Descriptions</b></em>'
     * reference list. The list contents are of type
     * {@link org.eclipse.sirius.description.tool.RepresentationNavigationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * All details that can be created from this node. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Navigation Descriptions</em>' reference
     *         list.
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationElementMapping_NavigationDescriptions()
     * @model
     * @generated
     */
    EList<RepresentationNavigationDescription> getNavigationDescriptions();

} // RepresentationElementMapping
