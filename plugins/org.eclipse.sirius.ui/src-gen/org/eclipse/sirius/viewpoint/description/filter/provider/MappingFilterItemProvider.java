/**
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 */
package org.eclipse.sirius.viewpoint.description.filter.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.viewpoint.description.filter.FilterKind;
import org.eclipse.sirius.viewpoint.description.filter.FilterPackage;
import org.eclipse.sirius.viewpoint.description.filter.MappingFilter;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.sirius.viewpoint.description.filter.MappingFilter} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MappingFilterItemProvider extends FilterItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MappingFilterItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addMappingsPropertyDescriptor(object);
            addSemanticConditionExpressionPropertyDescriptor(object);
            addViewConditionExpressionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Mappings feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMappingsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_MappingFilter_mappings_feature"), getString("_UI_PropertyDescriptor_description", "_UI_MappingFilter_mappings_feature", "_UI_MappingFilter_type"),
                FilterPackage.Literals.MAPPING_FILTER__MAPPINGS, true, false, true, null, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Semantic Condition Expression
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSemanticConditionExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_MappingFilter_semanticConditionExpression_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_MappingFilter_semanticConditionExpression_feature", "_UI_MappingFilter_type"),
                FilterPackage.Literals.MAPPING_FILTER__SEMANTIC_CONDITION_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the View Condition Expression
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addViewConditionExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_MappingFilter_viewConditionExpression_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_MappingFilter_viewConditionExpression_feature", "_UI_MappingFilter_type"),
                FilterPackage.Literals.MAPPING_FILTER__VIEW_CONDITION_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This returns MappingFilter.gif. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/MappingFilter"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        FilterKind labelValue = ((MappingFilter) object).getFilterKind();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ? getString("_UI_MappingFilter_type") : getString("_UI_MappingFilter_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached children and by creating a viewer notification, which
     * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(MappingFilter.class)) {
        case FilterPackage.MAPPING_FILTER__SEMANTIC_CONDITION_EXPRESSION:
        case FilterPackage.MAPPING_FILTER__VIEW_CONDITION_EXPRESSION:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children that can be created under this object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
