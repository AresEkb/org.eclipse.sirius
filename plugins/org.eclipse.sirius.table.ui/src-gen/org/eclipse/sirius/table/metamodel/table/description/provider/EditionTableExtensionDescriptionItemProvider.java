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
package org.eclipse.sirius.table.metamodel.table.description.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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

import org.eclipse.sirius.description.DescriptionPackage;
import org.eclipse.sirius.description.contribution.ContributionFactory;
import org.eclipse.sirius.description.contribution.ContributionPackage;
import org.eclipse.sirius.table.metamodel.table.description.DescriptionFactory;
import org.eclipse.sirius.table.metamodel.table.description.EditionTableExtensionDescription;
import org.eclipse.sirius.table.metamodel.table.provider.TableUIPlugin;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.sirius.table.metamodel.table.description.EditionTableExtensionDescription}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditionTableExtensionDescriptionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation\n";

    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditionTableExtensionDescriptionItemProvider(AdapterFactory adapterFactory) {
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

            addNamePropertyDescriptor(object);
            addSiriusURIPropertyDescriptor(object);
            addRepresentationNamePropertyDescriptor(object);
            addMetamodelPropertyDescriptor(object);
            addOwnedToolsPropertyDescriptor(object);
            addPreconditionExpressionPropertyDescriptor(object);
            addDomainClassPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                        getString("_UI_RepresentationExtensionDescription_name_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RepresentationExtensionDescription_name_feature", "_UI_RepresentationExtensionDescription_type"),
                        DescriptionPackage.Literals.REPRESENTATION_EXTENSION_DESCRIPTION__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Sirius URI feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSiriusURIPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_RepresentationExtensionDescription_viewpointURI_feature"), getString("_UI_RepresentationExtensionDescription_viewpointURI_description"),
                DescriptionPackage.Literals.REPRESENTATION_EXTENSION_DESCRIPTION__VIEWPOINT_URI, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Representation Name feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addRepresentationNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_RepresentationExtensionDescription_representationName_feature"), getString("_UI_RepresentationExtensionDescription_representationName_description"),
                DescriptionPackage.Literals.REPRESENTATION_EXTENSION_DESCRIPTION__REPRESENTATION_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Metamodel feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMetamodelPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_RepresentationExtensionDescription_metamodel_feature"), getString("_UI_RepresentationExtensionDescription_metamodel_description"),
                DescriptionPackage.Literals.REPRESENTATION_EXTENSION_DESCRIPTION__METAMODEL, true, false, true, null, getString("_UI_AdvancedPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Owned Tools feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOwnedToolsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditionTableExtensionDescription_ownedTools_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EditionTableExtensionDescription_ownedTools_feature", "_UI_EditionTableExtensionDescription_type"),
                org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_TOOLS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Precondition Expression feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPreconditionExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditionTableExtensionDescription_preconditionExpression_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EditionTableExtensionDescription_preconditionExpression_feature", "_UI_EditionTableExtensionDescription_type"),
                org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__PRECONDITION_EXPRESSION, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Domain Class feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDomainClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditionTableExtensionDescription_domainClass_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EditionTableExtensionDescription_domainClass_feature", "_UI_EditionTableExtensionDescription_type"),
                org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__DOMAIN_CLASS, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(ContributionPackage.Literals.CONTRIBUTION_PROVIDER__CONTRIBUTIONS);
            childrenFeatures.add(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_LINE_MAPPINGS);
            childrenFeatures.add(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_COLUMN_MAPPINGS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper
        // feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns EditionTableExtensionDescription.gif. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EditionTableExtensionDescription"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((EditionTableExtensionDescription) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_EditionTableExtensionDescription_type") : getString("_UI_EditionTableExtensionDescription_type") + " " + label;
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

        switch (notification.getFeatureID(EditionTableExtensionDescription.class)) {
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__NAME:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__VIEWPOINT_URI:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__REPRESENTATION_NAME:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__PRECONDITION_EXPRESSION:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__DOMAIN_CLASS:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__CONTRIBUTIONS:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_LINE_MAPPINGS:
        case org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_COLUMN_MAPPINGS:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(createChildParameter(ContributionPackage.Literals.CONTRIBUTION_PROVIDER__CONTRIBUTIONS, ContributionFactory.eINSTANCE.createContribution()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_LINE_MAPPINGS,
                DescriptionFactory.eINSTANCE.createLineMapping()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.Literals.EDITION_TABLE_EXTENSION_DESCRIPTION__OWNED_COLUMN_MAPPINGS,
                DescriptionFactory.eINSTANCE.createFeatureColumnMapping()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return TableUIPlugin.INSTANCE;
    }

}
