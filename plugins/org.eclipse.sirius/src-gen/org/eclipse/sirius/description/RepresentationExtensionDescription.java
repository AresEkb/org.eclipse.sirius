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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Representation Extension Description</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getSiriusURI
 * <em>Sirius URI</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getRepresentationName
 * <em>Representation Name</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getMetamodel
 * <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationExtensionDescription()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface RepresentationExtensionDescription extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationExtensionDescription_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Sirius URI</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sirius URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The logical URI of the
     * viewpoint you want to extend, in the form of
     * viewpoint:/pluginID/SiriusName <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Sirius URI</em>' attribute.
     * @see #setSiriusURI(String)
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationExtensionDescription_SiriusURI()
     * @model required="true"
     * @generated
     */
    String getSiriusURI();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getSiriusURI
     * <em>Sirius URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Sirius URI</em>' attribute.
     * @see #getSiriusURI()
     * @generated
     */
    void setSiriusURI(String value);

    /**
     * Returns the value of the '<em><b>Representation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Representation Name</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The name of the
     * Representation you are extending. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Representation Name</em>' attribute.
     * @see #setRepresentationName(String)
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationExtensionDescription_RepresentationName()
     * @model required="true"
     * @generated
     */
    String getRepresentationName();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.description.RepresentationExtensionDescription#getRepresentationName
     * <em>Representation Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Representation Name</em>' attribute.
     * @see #getRepresentationName()
     * @generated
     */
    void setRepresentationName(String value);

    /**
     * Returns the value of the '<em><b>Metamodel</b></em>' reference list. The
     * list contents are of type {@link org.eclipse.emf.ecore.EPackage}. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> You
     * might use this reference to statically bind your representation extension
     * with a set of Ecore packages. Keep in mind that this is not mandatory.
     * <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Metamodel</em>' reference list.
     * @see org.eclipse.sirius.description.DescriptionPackage#getRepresentationExtensionDescription_Metamodel()
     * @model
     * @generated
     */
    EList<EPackage> getMetamodel();

} // RepresentationExtensionDescription
