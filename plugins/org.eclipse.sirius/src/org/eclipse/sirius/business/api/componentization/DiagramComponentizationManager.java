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
package org.eclipse.sirius.business.api.componentization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.business.api.query.SiriusQuery;
import org.eclipse.sirius.business.internal.metamodel.helper.ComponentizationHelper;
import org.eclipse.sirius.description.ContainerMapping;
import org.eclipse.sirius.description.DescriptionPackage;
import org.eclipse.sirius.description.DiagramDescription;
import org.eclipse.sirius.description.DiagramExtensionDescription;
import org.eclipse.sirius.description.EdgeMapping;
import org.eclipse.sirius.description.Layer;
import org.eclipse.sirius.description.NodeMapping;
import org.eclipse.sirius.description.RepresentationDescription;
import org.eclipse.sirius.description.Sirius;
import org.eclipse.sirius.description.tool.AbstractToolDescription;
import org.eclipse.sirius.description.tool.ToolEntry;
import org.eclipse.sirius.description.tool.ToolGroup;
import org.eclipse.sirius.description.tool.ToolGroupExtension;
import org.eclipse.sirius.description.tool.ToolSection;

/**
 * This class handles componentization for diagram elements. This class will
 * move in diagram plug-in when refresh refactoring will occurs.
 * 
 * @author mchauvin
 */
public class DiagramComponentizationManager  {


    private static boolean isInSelectedSirius(final Collection<Sirius> selectedSiriuss, final DiagramDescription diagramDescription) {
        for (final Sirius viewpoint : selectedSiriuss) {
            for (final RepresentationDescription representationDescription : new SiriusQuery(viewpoint).getAllRepresentationDescriptions()) {
                if (EqualityHelper.areEquals(diagramDescription, representationDescription)) {
                    return true;
                }
            }
        }
        return false;
    }

    private EList<Layer> wrapGetAllLayers(final DiagramDescription diagramDescription, final Collection<Layer> layers) {
        return new EcoreEList.UnmodifiableEList<Layer>((InternalEObject) diagramDescription, DescriptionPackage.eINSTANCE.getDiagramDescription_AllLayers(), layers.size(), layers.toArray());
    }

    /**
     * Get all the layers of a diagram description.
     * 
     * @param enabledSiriuss
     *            the list of Siriuss to consider
     * @param diagramDescription
     *            the diagram description
     * @return all the available layers
     */
    public EList<Layer> getAllLayers(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Collection<Layer> layers = new ArrayList<Layer>(diagramDescription.getAllLayers());

        if (enabledSiriuss != null) {
            if (!DiagramComponentizationManager.isInSelectedSirius(enabledSiriuss, diagramDescription)) {
                return wrapGetAllLayers(diagramDescription, Collections.<Layer> emptySet());
            }
            layers.addAll(ComponentizationHelper.getContributedLayers(diagramDescription, enabledSiriuss));
        }
        return wrapGetAllLayers(diagramDescription, layers);
    }

    /**
     * Get all the edge mappings available for a diagram description.
     * 
     * @param enabledSiriuss
     *            the list of Siriuss to consider
     * @param diagramDescription
     *            the diagram description
     * @return all the available edge mappings
     */
    public EList<EdgeMapping> getAllEdgeMappings(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Collection<EdgeMapping> edgeMappings = new ArrayList<EdgeMapping>(diagramDescription.getAllEdgeMappings());
        if (enabledSiriuss != null) {
            for (final Layer layer : ComponentizationHelper.getContributedLayers(diagramDescription, enabledSiriuss)) {
                edgeMappings.addAll(layer.getAllEdgeMappings());
            }
        }
        return new EcoreEList.UnmodifiableEList<EdgeMapping>((InternalEObject) diagramDescription, DescriptionPackage.eINSTANCE.getDiagramDescription_AllEdgeMappings(), edgeMappings.size(),
                edgeMappings.toArray());
    }

    /**
     * Get all the node mappings available for a diagram description.
     * 
     * @param enabledSiriuss
     *            the list of Siriuss to consider
     * @param diagramDescription
     *            the diagram description
     * @return all the available node mappings
     */
    public EList<NodeMapping> getAllNodeMappings(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Collection<NodeMapping> nodeMappings = new ArrayList<NodeMapping>(diagramDescription.getAllNodeMappings());
        if (enabledSiriuss != null) {
            for (final Layer layer : ComponentizationHelper.getContributedLayers(diagramDescription, enabledSiriuss)) {
                nodeMappings.addAll(layer.getNodeMappings());
            }
        }

        return new EcoreEList.UnmodifiableEList<NodeMapping>((InternalEObject) diagramDescription, DescriptionPackage.eINSTANCE.getDiagramDescription_AllNodeMappings(), nodeMappings.size(),
                nodeMappings.toArray());
    }

    /**
     * Get all the container mappings available for a diagram description.
     * 
     * @param enabledSiriuss
     *            the list of Siriuss to consider
     * @param diagramDescription
     *            the diagram description
     * @return all the available container mappings
     */
    public EList<ContainerMapping> getAllContainerMappings(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Collection<ContainerMapping> containerMappings = new ArrayList<ContainerMapping>(diagramDescription.getAllContainerMappings());
        if (enabledSiriuss != null) {
            for (final Layer layer : ComponentizationHelper.getContributedLayers(diagramDescription, enabledSiriuss)) {
                containerMappings.addAll(layer.getContainerMappings());
            }
        }
        return new EcoreEList.UnmodifiableEList<ContainerMapping>((InternalEObject) diagramDescription, DescriptionPackage.eINSTANCE.getDiagramDescription_AllContainerMappings(),
                containerMappings.size(), containerMappings.toArray());
    }

    /**
     * Get all the sections available for a diagram description.
     * 
     * @param enabledSiriuss
     *            the list of Siriuss to consider
     * @param diagramDescription
     *            the diagram description
     * @return all the available sections
     */
    public EList<ToolSection> getRootPaletteSections(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Map<String, ToolSection> nameToSection = new LinkedHashMap<String, ToolSection>();
        for (final Layer layer : getAllLayers(enabledSiriuss, diagramDescription)) {
            for (ToolSection currentSection : layer.getToolSections()) {
                if (!nameToSection.containsKey(currentSection.getName())) {
                    nameToSection.put(currentSection.getName(), currentSection);
                }
            }
        }
        return new BasicEList<ToolSection>(nameToSection.values());
    }

    /**
     * Get all the tools available for a diagram description. The function will
     * check direct and indirect children.
     * 
     * @param enabledSiriuss
     *            the viewpoints to consider.
     * @param diagramDescription
     *            the diagram description
     * @return all the available tools
     */
    public EList<AbstractToolDescription> getAllTools(final Collection<Sirius> enabledSiriuss, final DiagramDescription diagramDescription) {
        final Collection<AbstractToolDescription> tools = new ArrayList<AbstractToolDescription>(diagramDescription.getAllTools());
        if (enabledSiriuss != null) {
            for (final Layer layer : ComponentizationHelper.getContributedLayers(diagramDescription, enabledSiriuss)) {
                tools.addAll(layer.getAllTools());
            }
        }
        return new EcoreEList.UnmodifiableEList<AbstractToolDescription>((InternalEObject) diagramDescription, DescriptionPackage.eINSTANCE.getDiagramDescription_AllTools(), tools.size(),
                tools.toArray());
    }

    /**
     * Get the tool entries available for a section.
     * 
     * @param enabledSiriuss
     *            the viewpoints to consider.
     * @param section
     *            the section
     * @return all the available tools
     */
    public EList<ToolEntry> getToolEntries(final Collection<Sirius> enabledSiriuss, final ToolSection section) {
        return getAllToolEntries(enabledSiriuss, section, false);
    }

    /**
     * Get all the tool entries available for a section. The function will check
     * direct and indirect children.
     * 
     * @param enabledSiriuss
     *            the viewpoints to consider.
     * @param section
     *            the section
     * @return all the available tools
     */
    public EList<ToolEntry> getAllToolEntries(final Collection<Sirius> enabledSiriuss, final ToolSection section) {
        return getAllToolEntries(enabledSiriuss, section, true);
    }

    private EList<ToolEntry> getAllToolEntries(final Collection<Sirius> enabledSiriuss, final ToolSection section, boolean recursive) {
        final EList<ToolEntry> toolEntries = new BasicEList<ToolEntry>();

        final EObject container = section.eContainer();

        if (container instanceof Layer) {
            if (section.getName() != null && enabledSiriuss != null) {
                final Layer parentLayer = (Layer) container;
                final DiagramDescription diagramDescription = getDiagramDescription(enabledSiriuss, parentLayer);

                for (final Layer layer : getAllLayers(enabledSiriuss, diagramDescription)) {

                    for (final ToolSection toolSection : layer.getToolSections()) {

                        if (section.getName().equals(toolSection.getName())) {
                            toolEntries.addAll(getTools(toolSection, recursive));
                        }
                    }
                }
            }
        } else {
            toolEntries.addAll(getTools(section, recursive));
        }
        return toolEntries;
    }

    private EList<ToolEntry> getTools(final ToolSection toolSection, boolean recursive) {
        final EList<ToolEntry> entries = new BasicEList<ToolEntry>();
        entries.addAll(toolSection.getOwnedTools());
        entries.addAll(toolSection.getReusedTools());
        if (recursive) {
            for (ToolSection subSection : toolSection.getSubSections()) {
                entries.addAll(getTools(subSection, recursive));
            }
        }
        return entries;
    }

    private DiagramDescription getDiagramDescription(final Collection<Sirius> enabledSiriuss, final Layer layer) {
        DiagramDescription diagramDescription = null;
        final EObject layerContainer = layer.eContainer();
        if (layerContainer instanceof DiagramDescription) {
            diagramDescription = (DiagramDescription) layerContainer;
        } else if (layerContainer instanceof DiagramExtensionDescription) {
            diagramDescription = ComponentizationHelper.getDiagramDescription((DiagramExtensionDescription) layerContainer, enabledSiriuss);
        }
        return diagramDescription;
    }

    /**
     * Get the tools available for a tool group.
     * 
     * @param enabledSiriuss
     *            the viewpoints to consider.
     * @param toolGroup
     *            the group of tools
     * @return the available tools
     */
    public EList<AbstractToolDescription> getTools(final Collection<Sirius> enabledSiriuss, final ToolGroup toolGroup) {

        final DiagramDescription diagramDescription = getDiagramDescription(toolGroup);
        final EList<AbstractToolDescription> tools = new BasicEList<AbstractToolDescription>();
        tools.addAll(toolGroup.getTools());
        for (final Layer layer : getAllLayers(enabledSiriuss, diagramDescription)) {
            tools.addAll(getToolsFromToolSection(layer.getToolSections(), toolGroup));
        }
        return tools;
    }

    private EList<AbstractToolDescription> getToolsFromToolSection(final Collection<ToolSection> sections, final ToolGroup toolGroup) {
        final EList<AbstractToolDescription> tools = new BasicEList<AbstractToolDescription>();
        for (final ToolSection section : sections) {
            for (final ToolGroupExtension extension : section.getGroupExtensions()) {
                if (EqualityHelper.areEquals(toolGroup, extension.getGroup())) {
                    tools.addAll(extension.getTools());
                }
            }
            tools.addAll(getToolsFromToolSection(section.getSubSections(), toolGroup));
        }
        return tools;
    }

    private DiagramDescription getDiagramDescription(final ToolGroup toolGroup) {
        EObject eObject = toolGroup.eContainer();
        while (!(eObject instanceof DiagramDescription || eObject instanceof DiagramExtensionDescription)) {
            eObject = eObject.eContainer();
            if (eObject == null) {
                return null;
            }
        }
        DiagramDescription diagramDescription;

        if (eObject instanceof DiagramExtensionDescription) {
            diagramDescription = ComponentizationHelper.getDiagramDescription((DiagramExtensionDescription) eObject, SiriusRegistry.getInstance().getSiriuss());
        } else {
            diagramDescription = (DiagramDescription) eObject;
        }
        return diagramDescription;
    }

}
