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
package org.eclipse.sirius.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.DDiagram;
import org.eclipse.sirius.DDiagramElement;
import org.eclipse.sirius.DNavigable;
import org.eclipse.sirius.DNavigationLink;
import org.eclipse.sirius.DValidable;
import org.eclipse.sirius.Decoration;
import org.eclipse.sirius.GraphicalFilter;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.description.DiagramElementMapping;
import org.eclipse.sirius.description.Layer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>View Point Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.impl.DDiagramElementImpl#getOwnedNavigationLinks
 * <em>Owned Navigation Links</em>}</li>
 * <li>{@link org.eclipse.sirius.impl.DDiagramElementImpl#isVisible <em>
 * Visible</em>}</li>
 * <li>{@link org.eclipse.sirius.impl.DDiagramElementImpl#getTooltipText <em>
 * Tooltip Text</em>}</li>
 * <li>{@link org.eclipse.sirius.impl.DDiagramElementImpl#getParentLayers
 * <em>Parent Layers</em>}</li>
 * <li>{@link org.eclipse.sirius.impl.DDiagramElementImpl#getDecorations <em>
 * Decorations</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.impl.DDiagramElementImpl#getDiagramElementMapping
 * <em>Diagram Element Mapping</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.impl.DDiagramElementImpl#getGraphicalFilters
 * <em>Graphical Filters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class DDiagramElementImpl extends DRepresentationElementImpl implements DDiagramElement {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * The cached value of the '{@link #getOwnedNavigationLinks()
     * <em>Owned Navigation Links</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOwnedNavigationLinks()
     * @generated
     * @ordered
     */
    protected EList<DNavigationLink> ownedNavigationLinks;

    /**
     * The default value of the '{@link #isVisible() <em>Visible</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected static final boolean VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isVisible() <em>Visible</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected boolean visible = VISIBLE_EDEFAULT;

    /**
     * The default value of the '{@link #getTooltipText() <em>Tooltip Text</em>}
     * ' attribute. <!-- begin-user-doc -->
     * 
     * @since 2.0 <!-- end-user-doc -->
     * @see #getTooltipText()
     * @generated
     * @ordered
     */
    protected static final String TOOLTIP_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTooltipText() <em>Tooltip Text</em>}'
     * attribute. <!-- begin-user-doc -->
     * 
     * @since 2.0 <!-- end-user-doc -->
     * @see #getTooltipText()
     * @generated
     * @ordered
     */
    protected String tooltipText = TOOLTIP_TEXT_EDEFAULT;

    /**
     * The cached value of the '{@link #getParentLayers()
     * <em>Parent Layers</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getParentLayers()
     * @generated
     * @ordered
     */
    protected EList<Layer> parentLayers;

    /**
     * The cached value of the '{@link #getDecorations() <em>Decorations</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDecorations()
     * @generated
     * @ordered
     */
    protected EList<Decoration> decorations;

    /**
     * The cached value of the '{@link #getGraphicalFilters()
     * <em>Graphical Filters</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGraphicalFilters()
     * @generated
     * @ordered
     */
    protected EList<GraphicalFilter> graphicalFilters;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DDiagramElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    @Override
    protected EClass eStaticClass() {
        return SiriusPackage.Literals.DDIAGRAM_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<DNavigationLink> getOwnedNavigationLinks() {
        if (ownedNavigationLinks == null) {
            ownedNavigationLinks = new EObjectContainmentEList.Resolving<DNavigationLink>(DNavigationLink.class, this, SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS);
        }
        return ownedNavigationLinks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVisible(boolean newVisible) {
        boolean oldVisible = visible;
        visible = newVisible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE, oldVisible, visible));
    }

    /**
     * <!-- begin-user-doc -->
     * 
     * @since 2.0 <!-- end-user-doc -->
     * @generated
     */
    public String getTooltipText() {
        return tooltipText;
    }

    /**
     * <!-- begin-user-doc -->
     * 
     * @since 2.0 <!-- end-user-doc -->
     * @generated
     */
    public void setTooltipText(String newTooltipText) {
        String oldTooltipText = tooltipText;
        tooltipText = newTooltipText;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SiriusPackage.DDIAGRAM_ELEMENT__TOOLTIP_TEXT, oldTooltipText, tooltipText));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Layer> getParentLayers() {
        if (parentLayers == null) {
            parentLayers = new EObjectResolvingEList<Layer>(Layer.class, this, SiriusPackage.DDIAGRAM_ELEMENT__PARENT_LAYERS);
        }
        return parentLayers;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Decoration> getDecorations() {
        if (decorations == null) {
            decorations = new EObjectContainmentEList.Resolving<Decoration>(Decoration.class, this, SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS);
        }
        return decorations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated-not
     */
    public DiagramElementMapping getDiagramElementMapping() {
        DiagramElementMapping diagramElementMapping = basicGetDiagramElementMapping();
        return diagramElementMapping != null && diagramElementMapping.eIsProxy() ? (DiagramElementMapping) eResolveProxy((InternalEObject) diagramElementMapping) : diagramElementMapping;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated-not
     */
    public DiagramElementMapping basicGetDiagramElementMapping() {
        return (DiagramElementMapping) getMapping();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<GraphicalFilter> getGraphicalFilters() {
        if (graphicalFilters == null) {
            graphicalFilters = new EObjectContainmentEList.Resolving<GraphicalFilter>(GraphicalFilter.class, this, SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS);
        }
        return graphicalFilters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DDiagram getParentDiagram() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isFold(Map<?, ?> alreadyManagedElements) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validate() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
            return ((InternalEList<?>) getOwnedNavigationLinks()).basicRemove(otherEnd, msgs);
        case SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS:
            return ((InternalEList<?>) getDecorations()).basicRemove(otherEnd, msgs);
        case SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS:
            return ((InternalEList<?>) getGraphicalFilters()).basicRemove(otherEnd, msgs);
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
        case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
            return getOwnedNavigationLinks();
        case SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE:
            return isVisible();
        case SiriusPackage.DDIAGRAM_ELEMENT__TOOLTIP_TEXT:
            return getTooltipText();
        case SiriusPackage.DDIAGRAM_ELEMENT__PARENT_LAYERS:
            return getParentLayers();
        case SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS:
            return getDecorations();
        case SiriusPackage.DDIAGRAM_ELEMENT__DIAGRAM_ELEMENT_MAPPING:
            if (resolve)
                return getDiagramElementMapping();
            return basicGetDiagramElementMapping();
        case SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS:
            return getGraphicalFilters();
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
        case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
            getOwnedNavigationLinks().clear();
            getOwnedNavigationLinks().addAll((Collection<? extends DNavigationLink>) newValue);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE:
            setVisible((Boolean) newValue);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__TOOLTIP_TEXT:
            setTooltipText((String) newValue);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__PARENT_LAYERS:
            getParentLayers().clear();
            getParentLayers().addAll((Collection<? extends Layer>) newValue);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS:
            getDecorations().clear();
            getDecorations().addAll((Collection<? extends Decoration>) newValue);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS:
            getGraphicalFilters().clear();
            getGraphicalFilters().addAll((Collection<? extends GraphicalFilter>) newValue);
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
        case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
            getOwnedNavigationLinks().clear();
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE:
            setVisible(VISIBLE_EDEFAULT);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__TOOLTIP_TEXT:
            setTooltipText(TOOLTIP_TEXT_EDEFAULT);
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__PARENT_LAYERS:
            getParentLayers().clear();
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS:
            getDecorations().clear();
            return;
        case SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS:
            getGraphicalFilters().clear();
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
        case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
            return ownedNavigationLinks != null && !ownedNavigationLinks.isEmpty();
        case SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE:
            return visible != VISIBLE_EDEFAULT;
        case SiriusPackage.DDIAGRAM_ELEMENT__TOOLTIP_TEXT:
            return TOOLTIP_TEXT_EDEFAULT == null ? tooltipText != null : !TOOLTIP_TEXT_EDEFAULT.equals(tooltipText);
        case SiriusPackage.DDIAGRAM_ELEMENT__PARENT_LAYERS:
            return parentLayers != null && !parentLayers.isEmpty();
        case SiriusPackage.DDIAGRAM_ELEMENT__DECORATIONS:
            return decorations != null && !decorations.isEmpty();
        case SiriusPackage.DDIAGRAM_ELEMENT__DIAGRAM_ELEMENT_MAPPING:
            return basicGetDiagramElementMapping() != null;
        case SiriusPackage.DDIAGRAM_ELEMENT__GRAPHICAL_FILTERS:
            return graphicalFilters != null && !graphicalFilters.isEmpty();
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
        if (baseClass == DValidable.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == DNavigable.class) {
            switch (derivedFeatureID) {
            case SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS:
                return SiriusPackage.DNAVIGABLE__OWNED_NAVIGATION_LINKS;
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
        if (baseClass == DValidable.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == DNavigable.class) {
            switch (baseFeatureID) {
            case SiriusPackage.DNAVIGABLE__OWNED_NAVIGATION_LINKS:
                return SiriusPackage.DDIAGRAM_ELEMENT__OWNED_NAVIGATION_LINKS;
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
        result.append(" (visible: ");
        result.append(visible);
        result.append(", tooltipText: ");
        result.append(tooltipText);
        result.append(')');
        return result.toString();
    }

} // DDiagramElementImpl
