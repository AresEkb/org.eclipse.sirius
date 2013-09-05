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
package org.eclipse.sirius.diagram.sequence.description.tool.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.sirius.description.tool.impl.NodeCreationDescriptionImpl;
import org.eclipse.sirius.diagram.sequence.description.MessageEndVariable;
import org.eclipse.sirius.diagram.sequence.description.tool.ObservationPointCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.OrderedElementCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.SequenceDiagramToolDescription;
import org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Observation Point Creation Tool</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.diagram.sequence.description.tool.impl.ObservationPointCreationToolImpl#getStartingEndPredecessor
 * <em>Starting End Predecessor</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.diagram.sequence.description.tool.impl.ObservationPointCreationToolImpl#getFinishingEndPredecessor
 * <em>Finishing End Predecessor</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ObservationPointCreationToolImpl extends NodeCreationDescriptionImpl implements ObservationPointCreationTool {
    /**
     * The cached value of the '{@link #getStartingEndPredecessor()
     * <em>Starting End Predecessor</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStartingEndPredecessor()
     * @generated
     * @ordered
     */
    protected MessageEndVariable startingEndPredecessor;

    /**
     * The cached value of the '{@link #getFinishingEndPredecessor()
     * <em>Finishing End Predecessor</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFinishingEndPredecessor()
     * @generated
     * @ordered
     */
    protected MessageEndVariable finishingEndPredecessor;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ObservationPointCreationToolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ToolPackage.Literals.OBSERVATION_POINT_CREATION_TOOL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MessageEndVariable getStartingEndPredecessor() {
        return startingEndPredecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetStartingEndPredecessor(MessageEndVariable newStartingEndPredecessor, NotificationChain msgs) {
        MessageEndVariable oldStartingEndPredecessor = startingEndPredecessor;
        startingEndPredecessor = newStartingEndPredecessor;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR, oldStartingEndPredecessor,
                    newStartingEndPredecessor);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setStartingEndPredecessor(MessageEndVariable newStartingEndPredecessor) {
        if (newStartingEndPredecessor != startingEndPredecessor) {
            NotificationChain msgs = null;
            if (startingEndPredecessor != null)
                msgs = ((InternalEObject) startingEndPredecessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR, null, msgs);
            if (newStartingEndPredecessor != null)
                msgs = ((InternalEObject) newStartingEndPredecessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR, null, msgs);
            msgs = basicSetStartingEndPredecessor(newStartingEndPredecessor, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR, newStartingEndPredecessor, newStartingEndPredecessor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MessageEndVariable getFinishingEndPredecessor() {
        return finishingEndPredecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFinishingEndPredecessor(MessageEndVariable newFinishingEndPredecessor, NotificationChain msgs) {
        MessageEndVariable oldFinishingEndPredecessor = finishingEndPredecessor;
        finishingEndPredecessor = newFinishingEndPredecessor;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR, oldFinishingEndPredecessor,
                    newFinishingEndPredecessor);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFinishingEndPredecessor(MessageEndVariable newFinishingEndPredecessor) {
        if (newFinishingEndPredecessor != finishingEndPredecessor) {
            NotificationChain msgs = null;
            if (finishingEndPredecessor != null)
                msgs = ((InternalEObject) finishingEndPredecessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR, null, msgs);
            if (newFinishingEndPredecessor != null)
                msgs = ((InternalEObject) newFinishingEndPredecessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR, null, msgs);
            msgs = basicSetFinishingEndPredecessor(newFinishingEndPredecessor, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR, newFinishingEndPredecessor, newFinishingEndPredecessor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
            return basicSetStartingEndPredecessor(null, msgs);
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            return basicSetFinishingEndPredecessor(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
            return getStartingEndPredecessor();
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            return getFinishingEndPredecessor();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
            setStartingEndPredecessor((MessageEndVariable) newValue);
            return;
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            setFinishingEndPredecessor((MessageEndVariable) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
            setStartingEndPredecessor((MessageEndVariable) null);
            return;
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            setFinishingEndPredecessor((MessageEndVariable) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
            return startingEndPredecessor != null;
        case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            return finishingEndPredecessor != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == SequenceDiagramToolDescription.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == OrderedElementCreationTool.class) {
            switch (derivedFeatureID) {
            case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR:
                return ToolPackage.ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR;
            case ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
                return ToolPackage.ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == SequenceDiagramToolDescription.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == OrderedElementCreationTool.class) {
            switch (baseFeatureID) {
            case ToolPackage.ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR:
                return ToolPackage.OBSERVATION_POINT_CREATION_TOOL__STARTING_END_PREDECESSOR;
            case ToolPackage.ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR:
                return ToolPackage.OBSERVATION_POINT_CREATION_TOOL__FINISHING_END_PREDECESSOR;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // ObservationPointCreationToolImpl
