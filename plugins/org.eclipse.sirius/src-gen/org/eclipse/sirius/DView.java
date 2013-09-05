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

import org.eclipse.sirius.description.Sirius;

/**
 * <!-- begin-user-doc -->
 * <p>
 * A representation of the model object '<em><b>DView</b></em>'.
 * </p>
 * <p>
 * An analysis is the root element of a view (.aird, .airview). It contains
 * viewpoints and Meta Model extensions.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> An view is the root element <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.DView#getOwnedRepresentations <em>Owned
 * Representations</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#getOwnedExtensions <em>Owned
 * Extensions</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#getAllRepresentations <em>All
 * Representations</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#getHiddenRepresentations <em>Hidden
 * Representations</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#getReferencedRepresentations <em>
 * Referenced Representations</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#isInitialized <em>Initialized</em>}</li>
 * <li>{@link org.eclipse.sirius.DView#getSirius <em>Sirius</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.SiriusPackage#getDView()
 * @model
 * @generated
 */
public interface DView extends DRefreshable {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * Returns the value of the '<em><b>Owned Representations</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.eclipse.sirius.DRepresentation}. <!-- begin-user-doc -->
     * <!-- end-user-doc --> <!-- begin-model-doc --> The viewpoints that are
     * owned by this analysis. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Owned Representations</em>' containment
     *         reference list.
     * @see org.eclipse.sirius.SiriusPackage#getDView_OwnedRepresentations()
     * @model type="org.eclipse.sirius.DRepresentation" containment="true"
     *        resolveProxies="true"
     * @generated
     */
    EList<DRepresentation> getOwnedRepresentations();

    /**
     * Returns the value of the '<em><b>Owned Extensions</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * Return the Meta model extension that is applied on this {@link DView}.
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The Meta Model extension
     * for this analysis. It may be null. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Owned Extensions</em>' containment
     *         reference.
     * @see #setOwnedExtensions(MetaModelExtension)
     * @see org.eclipse.sirius.SiriusPackage#getAnalysis_OwnedExtensions()
     * @model containment="true"
     * @generated
     */
    MetaModelExtension getOwnedExtensions();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.DView#getOwnedExtensions
     * <em>Owned Extensions</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Owned Extensions</em>' containment
     *            reference.
     * @see #getOwnedExtensions()
     * @generated
     */
    void setOwnedExtensions(MetaModelExtension value);

    /**
     * Returns the value of the '<em><b>All Representations</b></em>' reference
     * list. The list contents are of type
     * {@link org.eclipse.sirius.DRepresentation}. <!-- begin-user-doc -->
     * <!-- end-user-doc --> <!-- begin-model-doc --> All viewpoints of this
     * analysis <!-- end-model-doc -->
     * 
     * @return the value of the '<em>All Representations</em>' reference list.
     * @see org.eclipse.sirius.SiriusPackage#getDView_AllRepresentations()
     * @model type="org.eclipse.sirius.DRepresentation" transient="true"
     *        changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<DRepresentation> getAllRepresentations();

    /**
     * Returns the value of the '<em><b>Hidden Representations</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.eclipse.sirius.DRepresentation}. <!-- begin-user-doc -->
     * <!-- end-user-doc --> <!-- begin-model-doc --> All hidden viewpoints of
     * this analysis. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Hidden Representations</em>' containment
     *         reference list.
     * @see org.eclipse.sirius.SiriusPackage#getDView_HiddenRepresentations()
     * @model type="org.eclipse.sirius.DRepresentation" containment="true"
     *        resolveProxies="true"
     * @generated
     */
    EList<DRepresentation> getHiddenRepresentations();

    /**
     * Returns the value of the '<em><b>Referenced Representations</b></em>'
     * reference list. The list contents are of type
     * {@link org.eclipse.sirius.DRepresentation}. <!-- begin-user-doc -->
     * <!-- end-user-doc --> <!-- begin-model-doc --> Siriuss referenced but
     * not contained in this analysis. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Referenced Representations</em>' reference
     *         list.
     * @see org.eclipse.sirius.SiriusPackage#getDView_ReferencedRepresentations()
     * @model type="org.eclipse.sirius.DRepresentation"
     * @generated
     */
    EList<DRepresentation> getReferencedRepresentations();

    /**
     * Returns the value of the '<em><b>Initialized</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialized</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Initialized</em>' attribute.
     * @see #setInitialized(boolean)
     * @see org.eclipse.sirius.SiriusPackage#getDView_Initialized()
     * @model required="true"
     * @generated
     */
    boolean isInitialized();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.DView#isInitialized
     * <em>Initialized</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Initialized</em>' attribute.
     * @see #isInitialized()
     * @generated
     */
    void setInitialized(boolean value);

    /**
     * Returns the value of the '<em><b>Sirius</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
     * viewpoint that is used for this view <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Sirius</em>' reference.
     * @see #setSirius(Sirius)
     * @see org.eclipse.sirius.SiriusPackage#getDView_Sirius()
     * @model required="true"
     * @generated
     */
    Sirius getSirius();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.DView#getSirius
     * <em>Sirius</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Sirius</em>' reference.
     * @see #getSirius()
     * @generated
     */
    void setSirius(Sirius value);

} // DView
