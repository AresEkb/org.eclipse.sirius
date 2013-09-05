/*******************************************************************************
 * Copyright (c) 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.tools.api.properties;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.sirius.common.tools.api.util.TreeItemWrapper;
import org.eclipse.sirius.description.AbstractMappingImport;
import org.eclipse.sirius.description.AbstractNodeMapping;
import org.eclipse.sirius.description.ContainerMapping;
import org.eclipse.sirius.description.ContainerMappingImport;
import org.eclipse.sirius.description.DiagramDescription;
import org.eclipse.sirius.description.Sirius;

/**
 * A class which is able to build the items tree to select container mappings to
 * import.
 * 
 * @author mchauvin
 * @see AbstractMappingImportSelectionWizardBuilder
 */
public class ContainerMappingImportSelectionWizardItemsBuilder extends AbstractMappingImportSelectionWizardBuilder {

    /**
     * Builder for container.
     * 
     * @param containerMapping
     *            a container mapping
     * @param availableSiriuss
     *            the available viewpoints
     */
    public ContainerMappingImportSelectionWizardItemsBuilder(final ContainerMapping containerMapping, final Collection<Sirius> availableSiriuss) {
        super(containerMapping, availableSiriuss);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.ui.tools.api.properties.AbstractMappingImportSelectionWizardBuilder#addMappings(org.eclipse.sirius.common.tools.api.util.TreeItemWrapper,
     *      org.eclipse.sirius.description.DiagramDescription)
     */
    @Override
    protected void addMappings(final TreeItemWrapper parentItem, final DiagramDescription diagramDescription) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.ui.tools.api.properties.AbstractMappingImportSelectionWizardBuilder#checkImportType(org.eclipse.sirius.description.AbstractNodeMapping)
     */
    @Override
    protected boolean checkImportType(final AbstractNodeMapping mapping) {
        if (mapping instanceof ContainerMappingImport) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.ui.tools.api.properties.AbstractMappingImportSelectionWizardBuilder#getAllMappings(org.eclipse.sirius.description.DiagramDescription)
     */
    @Override
    protected <T extends AbstractNodeMapping> Collection<T> getAllMappings(final DiagramDescription diagramDescription) {
        return (Collection<T>) diagramDescription.getAllContainerMappings();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.ui.tools.api.properties.AbstractMappingImportSelectionWizardBuilder#getImportedMapping(org.eclipse.sirius.description.AbstractMappingImport)
     */
    @Override
    protected AbstractNodeMapping getImportedMapping(final AbstractMappingImport mappingImport) {
        if (mappingImport instanceof ContainerMappingImport) {
            return ((ContainerMappingImport) mappingImport).getImportedMapping();
        }
        throw new IllegalArgumentException();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.ui.tools.api.properties.AbstractMappingImportSelectionWizardBuilder#addMappingItems(org.eclipse.sirius.description.DiagramDescription,
     *      org.eclipse.sirius.common.tools.api.util.TreeItemWrapper)
     */
    @Override
    protected void addMappingItems(final DiagramDescription diagramDescription, final TreeItemWrapper diagramDescriptionItem) {
        final List<ContainerMapping> candidates = diagramDescription.getAllContainerMappings();
        addMappingItems(diagramDescriptionItem, candidates);
    }

    private void addMappingItems(final TreeItemWrapper parentItem, final List<ContainerMapping> candidates) {
        for (ContainerMapping mapping : candidates) {
            if (!EcoreUtil.equals(currentMapping, mapping) && safeMappingCandidate(mapping)) {
                final TreeItemWrapper treeItem = new TreeItemWrapper(mapping, parentItem);
                parentItem.getChildren().add(treeItem);
                addMappingItems(treeItem, mapping.getSubContainerMappings());
            } else {
                addMappingItems(parentItem, mapping.getSubContainerMappings());
            }

        }
    }

}
