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
package org.eclipse.sirius.description.concern.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.sirius.description.DescriptionPackage;
import org.eclipse.sirius.description.IdentifiedElement;
import org.eclipse.sirius.description.concern.ConcernDescription;
import org.eclipse.sirius.description.concern.ConcernPackage;
import org.eclipse.sirius.description.filter.FilterDescription;
import org.eclipse.sirius.description.impl.DocumentedElementImpl;
import org.eclipse.sirius.description.tool.BehaviorTool;
import org.eclipse.sirius.description.validation.ValidationRule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.description.concern.impl.ConcernDescriptionImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.concern.impl.ConcernDescriptionImpl#getLabel
 * <em>Label</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.concern.impl.ConcernDescriptionImpl#getFilters
 * <em>Filters</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.concern.impl.ConcernDescriptionImpl#getRules
 * <em>Rules</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.description.concern.impl.ConcernDescriptionImpl#getBehaviors
 * <em>Behaviors</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConcernDescriptionImpl extends DocumentedElementImpl implements ConcernDescription {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<FilterDescription> filters;

    /**
     * The cached value of the '{@link #getRules() <em>Rules</em>}' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRules()
     * @generated
     * @ordered
     */
    protected EList<ValidationRule> rules;

    /**
     * The cached value of the '{@link #getBehaviors() <em>Behaviors</em>}'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBehaviors()
     * @generated
     * @ordered
     */
    protected EList<BehaviorTool> behaviors;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConcernDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ConcernPackage.Literals.CONCERN_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConcernPackage.CONCERN_DESCRIPTION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConcernPackage.CONCERN_DESCRIPTION__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<FilterDescription> getFilters() {
        if (filters == null) {
            filters = new EObjectResolvingEList<FilterDescription>(FilterDescription.class, this, ConcernPackage.CONCERN_DESCRIPTION__FILTERS);
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ValidationRule> getRules() {
        if (rules == null) {
            rules = new EObjectResolvingEList<ValidationRule>(ValidationRule.class, this, ConcernPackage.CONCERN_DESCRIPTION__RULES);
        }
        return rules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<BehaviorTool> getBehaviors() {
        if (behaviors == null) {
            behaviors = new EObjectResolvingEList<BehaviorTool>(BehaviorTool.class, this, ConcernPackage.CONCERN_DESCRIPTION__BEHAVIORS);
        }
        return behaviors;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ConcernPackage.CONCERN_DESCRIPTION__NAME:
            return getName();
        case ConcernPackage.CONCERN_DESCRIPTION__LABEL:
            return getLabel();
        case ConcernPackage.CONCERN_DESCRIPTION__FILTERS:
            return getFilters();
        case ConcernPackage.CONCERN_DESCRIPTION__RULES:
            return getRules();
        case ConcernPackage.CONCERN_DESCRIPTION__BEHAVIORS:
            return getBehaviors();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ConcernPackage.CONCERN_DESCRIPTION__NAME:
            setName((String) newValue);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__LABEL:
            setLabel((String) newValue);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__FILTERS:
            getFilters().clear();
            getFilters().addAll((Collection<? extends FilterDescription>) newValue);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__RULES:
            getRules().clear();
            getRules().addAll((Collection<? extends ValidationRule>) newValue);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__BEHAVIORS:
            getBehaviors().clear();
            getBehaviors().addAll((Collection<? extends BehaviorTool>) newValue);
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
        case ConcernPackage.CONCERN_DESCRIPTION__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__LABEL:
            setLabel(LABEL_EDEFAULT);
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__FILTERS:
            getFilters().clear();
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__RULES:
            getRules().clear();
            return;
        case ConcernPackage.CONCERN_DESCRIPTION__BEHAVIORS:
            getBehaviors().clear();
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
        case ConcernPackage.CONCERN_DESCRIPTION__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ConcernPackage.CONCERN_DESCRIPTION__LABEL:
            return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        case ConcernPackage.CONCERN_DESCRIPTION__FILTERS:
            return filters != null && !filters.isEmpty();
        case ConcernPackage.CONCERN_DESCRIPTION__RULES:
            return rules != null && !rules.isEmpty();
        case ConcernPackage.CONCERN_DESCRIPTION__BEHAVIORS:
            return behaviors != null && !behaviors.isEmpty();
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
        if (baseClass == IdentifiedElement.class) {
            switch (derivedFeatureID) {
            case ConcernPackage.CONCERN_DESCRIPTION__NAME:
                return DescriptionPackage.IDENTIFIED_ELEMENT__NAME;
            case ConcernPackage.CONCERN_DESCRIPTION__LABEL:
                return DescriptionPackage.IDENTIFIED_ELEMENT__LABEL;
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
        if (baseClass == IdentifiedElement.class) {
            switch (baseFeatureID) {
            case DescriptionPackage.IDENTIFIED_ELEMENT__NAME:
                return ConcernPackage.CONCERN_DESCRIPTION__NAME;
            case DescriptionPackage.IDENTIFIED_ELEMENT__LABEL:
                return ConcernPackage.CONCERN_DESCRIPTION__LABEL;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", label: ");
        result.append(label);
        result.append(')');
        return result.toString();
    }

} // ConcernDescriptionImpl
