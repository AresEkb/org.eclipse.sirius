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
package org.eclipse.sirius.table.metamodel.table.description.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.description.DocumentedElement;
import org.eclipse.sirius.description.IdentifiedElement;
import org.eclipse.sirius.description.tool.AbstractToolDescription;
import org.eclipse.sirius.description.tool.EditMaskVariables;
import org.eclipse.sirius.description.tool.ToolEntry;
import org.eclipse.sirius.description.tool.ToolFilterDescription;
import org.eclipse.sirius.description.tool.ToolPackage;
import org.eclipse.sirius.table.metamodel.table.description.CreateCellTool;
import org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage;
import org.eclipse.sirius.table.metamodel.table.description.IntersectionMapping;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Create Cell Tool</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getDocumentation
 * <em>Documentation</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getLabel
 * <em>Label</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getPrecondition
 * <em>Precondition</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#isForceRefresh
 * <em>Force Refresh</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getFilters
 * <em>Filters</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getMask
 * <em>Mask</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.table.metamodel.table.description.impl.CreateCellToolImpl#getMapping
 * <em>Mapping</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateCellToolImpl extends TableToolImpl implements CreateCellTool {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation\n";

    /**
     * The default value of the '{@link #getDocumentation()
     * <em>Documentation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDocumentation()
     * @generated
     * @ordered
     */
    protected static final String DOCUMENTATION_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getDocumentation()
     * <em>Documentation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDocumentation()
     * @generated
     * @ordered
     */
    protected String documentation = DOCUMENTATION_EDEFAULT;

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
     * The default value of the '{@link #getPrecondition()
     * <em>Precondition</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPrecondition()
     * @generated
     * @ordered
     */
    protected static final String PRECONDITION_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPrecondition()
     * @generated
     * @ordered
     */
    protected String precondition = PRECONDITION_EDEFAULT;

    /**
     * The default value of the '{@link #isForceRefresh()
     * <em>Force Refresh</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isForceRefresh()
     * @generated
     * @ordered
     */
    protected static final boolean FORCE_REFRESH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForceRefresh() <em>Force Refresh</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isForceRefresh()
     * @generated
     * @ordered
     */
    protected boolean forceRefresh = FORCE_REFRESH_EDEFAULT;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<ToolFilterDescription> filters;

    /**
     * The cached value of the '{@link #getMask() <em>Mask</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMask()
     * @generated
     * @ordered
     */
    protected EditMaskVariables mask;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateCellToolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DescriptionPackage.Literals.CREATE_CELL_TOOL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDocumentation(String newDocumentation) {
        String oldDocumentation = documentation;
        documentation = newDocumentation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION, oldDocumentation, documentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPrecondition() {
        return precondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPrecondition(String newPrecondition) {
        String oldPrecondition = precondition;
        precondition = newPrecondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION, oldPrecondition, precondition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isForceRefresh() {
        return forceRefresh;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setForceRefresh(boolean newForceRefresh) {
        boolean oldForceRefresh = forceRefresh;
        forceRefresh = newForceRefresh;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH, oldForceRefresh, forceRefresh));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ToolFilterDescription> getFilters() {
        if (filters == null) {
            filters = new EObjectContainmentEList.Resolving<ToolFilterDescription>(ToolFilterDescription.class, this, DescriptionPackage.CREATE_CELL_TOOL__FILTERS);
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditMaskVariables getMask() {
        return mask;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMask(EditMaskVariables newMask, NotificationChain msgs) {
        EditMaskVariables oldMask = mask;
        mask = newMask;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__MASK, oldMask, newMask);
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
    public void setMask(EditMaskVariables newMask) {
        if (newMask != mask) {
            NotificationChain msgs = null;
            if (mask != null)
                msgs = ((InternalEObject) mask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DescriptionPackage.CREATE_CELL_TOOL__MASK, null, msgs);
            if (newMask != null)
                msgs = ((InternalEObject) newMask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DescriptionPackage.CREATE_CELL_TOOL__MASK, null, msgs);
            msgs = basicSetMask(newMask, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__MASK, newMask, newMask));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IntersectionMapping getMapping() {
        if (eContainerFeatureID() != DescriptionPackage.CREATE_CELL_TOOL__MAPPING)
            return null;
        return (IntersectionMapping) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMapping(IntersectionMapping newMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newMapping, DescriptionPackage.CREATE_CELL_TOOL__MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMapping(IntersectionMapping newMapping) {
        if (newMapping != eInternalContainer() || (eContainerFeatureID() != DescriptionPackage.CREATE_CELL_TOOL__MAPPING && newMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMapping != null)
                msgs = ((InternalEObject) newMapping).eInverseAdd(this, DescriptionPackage.INTERSECTION_MAPPING__CREATE, IntersectionMapping.class, msgs);
            msgs = basicSetMapping(newMapping, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DescriptionPackage.CREATE_CELL_TOOL__MAPPING, newMapping, newMapping));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetMapping((IntersectionMapping) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
            return ((InternalEList<?>) getFilters()).basicRemove(otherEnd, msgs);
        case DescriptionPackage.CREATE_CELL_TOOL__MASK:
            return basicSetMask(null, msgs);
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            return basicSetMapping(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            return eInternalContainer().eInverseRemove(this, DescriptionPackage.INTERSECTION_MAPPING__CREATE, IntersectionMapping.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION:
            return getDocumentation();
        case DescriptionPackage.CREATE_CELL_TOOL__NAME:
            return getName();
        case DescriptionPackage.CREATE_CELL_TOOL__LABEL:
            return getLabel();
        case DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION:
            return getPrecondition();
        case DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH:
            return isForceRefresh();
        case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
            return getFilters();
        case DescriptionPackage.CREATE_CELL_TOOL__MASK:
            return getMask();
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            return getMapping();
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
        case DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION:
            setDocumentation((String) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__NAME:
            setName((String) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__LABEL:
            setLabel((String) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION:
            setPrecondition((String) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH:
            setForceRefresh((Boolean) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
            getFilters().clear();
            getFilters().addAll((Collection<? extends ToolFilterDescription>) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__MASK:
            setMask((EditMaskVariables) newValue);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            setMapping((IntersectionMapping) newValue);
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
        case DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION:
            setDocumentation(DOCUMENTATION_EDEFAULT);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__NAME:
            setName(NAME_EDEFAULT);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__LABEL:
            setLabel(LABEL_EDEFAULT);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION:
            setPrecondition(PRECONDITION_EDEFAULT);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH:
            setForceRefresh(FORCE_REFRESH_EDEFAULT);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
            getFilters().clear();
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__MASK:
            setMask((EditMaskVariables) null);
            return;
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            setMapping((IntersectionMapping) null);
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
        case DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION:
            return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
        case DescriptionPackage.CREATE_CELL_TOOL__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case DescriptionPackage.CREATE_CELL_TOOL__LABEL:
            return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        case DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION:
            return PRECONDITION_EDEFAULT == null ? precondition != null : !PRECONDITION_EDEFAULT.equals(precondition);
        case DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH:
            return forceRefresh != FORCE_REFRESH_EDEFAULT;
        case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
            return filters != null && !filters.isEmpty();
        case DescriptionPackage.CREATE_CELL_TOOL__MASK:
            return mask != null;
        case DescriptionPackage.CREATE_CELL_TOOL__MAPPING:
            return getMapping() != null;
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
        if (baseClass == DocumentedElement.class) {
            switch (derivedFeatureID) {
            case DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION:
                return org.eclipse.sirius.description.DescriptionPackage.DOCUMENTED_ELEMENT__DOCUMENTATION;
            default:
                return -1;
            }
        }
        if (baseClass == IdentifiedElement.class) {
            switch (derivedFeatureID) {
            case DescriptionPackage.CREATE_CELL_TOOL__NAME:
                return org.eclipse.sirius.description.DescriptionPackage.IDENTIFIED_ELEMENT__NAME;
            case DescriptionPackage.CREATE_CELL_TOOL__LABEL:
                return org.eclipse.sirius.description.DescriptionPackage.IDENTIFIED_ELEMENT__LABEL;
            default:
                return -1;
            }
        }
        if (baseClass == ToolEntry.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == AbstractToolDescription.class) {
            switch (derivedFeatureID) {
            case DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION:
                return ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION;
            case DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH:
                return ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH;
            case DescriptionPackage.CREATE_CELL_TOOL__FILTERS:
                return ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS;
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
        if (baseClass == DocumentedElement.class) {
            switch (baseFeatureID) {
            case org.eclipse.sirius.description.DescriptionPackage.DOCUMENTED_ELEMENT__DOCUMENTATION:
                return DescriptionPackage.CREATE_CELL_TOOL__DOCUMENTATION;
            default:
                return -1;
            }
        }
        if (baseClass == IdentifiedElement.class) {
            switch (baseFeatureID) {
            case org.eclipse.sirius.description.DescriptionPackage.IDENTIFIED_ELEMENT__NAME:
                return DescriptionPackage.CREATE_CELL_TOOL__NAME;
            case org.eclipse.sirius.description.DescriptionPackage.IDENTIFIED_ELEMENT__LABEL:
                return DescriptionPackage.CREATE_CELL_TOOL__LABEL;
            default:
                return -1;
            }
        }
        if (baseClass == ToolEntry.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == AbstractToolDescription.class) {
            switch (baseFeatureID) {
            case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION:
                return DescriptionPackage.CREATE_CELL_TOOL__PRECONDITION;
            case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH:
                return DescriptionPackage.CREATE_CELL_TOOL__FORCE_REFRESH;
            case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
                return DescriptionPackage.CREATE_CELL_TOOL__FILTERS;
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
        result.append(" (documentation: ");
        result.append(documentation);
        result.append(", name: ");
        result.append(name);
        result.append(", label: ");
        result.append(label);
        result.append(", precondition: ");
        result.append(precondition);
        result.append(", forceRefresh: ");
        result.append(forceRefresh);
        result.append(')');
        return result.toString();
    }

} // CreateCellToolImpl
