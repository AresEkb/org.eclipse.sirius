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
package org.eclipse.sirius.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.sirius.DAnalysisSessionEObject;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.business.api.session.Session;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.sirius.DAnalysisSessionEObject} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DAnalysisSessionEObjectItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DAnalysisSessionEObjectItemProvider(AdapterFactory adapterFactory) {
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

            addOpenPropertyDescriptor(object);
            addBlockedPropertyDescriptor(object);
            addResourcesPropertyDescriptor(object);
            addControlledResourcesPropertyDescriptor(object);
            addActivatedSiriussPropertyDescriptor(object);
            addAnalysesPropertyDescriptor(object);
            addSynchronizationStatusPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Open feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOpenPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_open_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_open_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__OPEN, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Blocked feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBlockedPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_blocked_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_blocked_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__BLOCKED, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Resources feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addResourcesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_resources_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_resources_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__RESOURCES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Controlled Resources feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addControlledResourcesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_controlledResources_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_controlledResources_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__CONTROLLED_RESOURCES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Activated Siriuss feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addActivatedSiriussPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_activatedSiriuss_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_activatedSiriuss_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__ACTIVATED_VIEWPOINTS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Analyses feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAnalysesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_analyses_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_analyses_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__ANALYSES, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Synchronization Status feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSynchronizationStatusPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DAnalysisSessionEObject_synchronizationStatus_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DAnalysisSessionEObject_synchronizationStatus_feature", "_UI_DAnalysisSessionEObject_type"),
                SiriusPackage.Literals.DANALYSIS_SESSION_EOBJECT__SYNCHRONIZATION_STATUS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns DAnalysisSessionEObject.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DAnalysisSessionEObject"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @not-generated
     */
    @Override
    public String getText(Object object) {
        if (object instanceof Session) {
            return object.toString();
        }

        DAnalysisSessionEObject dAnalysisSessionEObject = (DAnalysisSessionEObject) object;
        return getString("_UI_DAnalysisSessionEObject_type") + " " + dAnalysisSessionEObject.isOpen();
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

        switch (notification.getFeatureID(DAnalysisSessionEObject.class)) {
        case SiriusPackage.DANALYSIS_SESSION_EOBJECT__OPEN:
        case SiriusPackage.DANALYSIS_SESSION_EOBJECT__BLOCKED:
        case SiriusPackage.DANALYSIS_SESSION_EOBJECT__RESOURCES:
        case SiriusPackage.DANALYSIS_SESSION_EOBJECT__CONTROLLED_RESOURCES:
        case SiriusPackage.DANALYSIS_SESSION_EOBJECT__SYNCHRONIZATION_STATUS:
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

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return SiriusEditPlugin.INSTANCE;
    }

}
