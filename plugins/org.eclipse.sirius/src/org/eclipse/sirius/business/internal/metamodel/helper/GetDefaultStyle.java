/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.metamodel.helper;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.business.api.query.IEdgeMappingQuery;
import org.eclipse.sirius.description.ContainerMapping;
import org.eclipse.sirius.description.ContainerMappingImport;
import org.eclipse.sirius.description.EdgeMapping;
import org.eclipse.sirius.description.EdgeMappingImport;
import org.eclipse.sirius.description.NodeMapping;
import org.eclipse.sirius.description.NodeMappingImport;
import org.eclipse.sirius.description.style.StyleDescription;
import org.eclipse.sirius.description.util.DescriptionSwitch;

/**
 * Swith to get the default style description of a mapping.
 * 
 * @author ymortier
 */
public class GetDefaultStyle extends DescriptionSwitch<StyleDescription> {

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseNodeMappingImport(org.eclipse.sirius.description.NodeMappingImport)
     */
    @Override
    public StyleDescription caseNodeMappingImport(final NodeMappingImport object) {
        if (object.getStyle() == null && object.getImportedMapping() != null) {
            return doSwitch(object.getImportedMapping());
        }
        return object.getStyle();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseNodeMapping(org.eclipse.sirius.description.NodeMapping)
     */
    @Override
    public StyleDescription caseNodeMapping(final NodeMapping object) {
        return object.getStyle();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseEdgeMapping(org.eclipse.sirius.description.EdgeMapping)
     */
    @Override
    public StyleDescription caseEdgeMapping(final EdgeMapping object) {
        return object.getStyle();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseEdgeMappingImport(org.eclipse.sirius.description.EdgeMappingImport)
     */
    @Override
    public StyleDescription caseEdgeMappingImport(final EdgeMappingImport object) {
        if (object.getImportedMapping() instanceof EdgeMappingImport) {
            return caseEdgeMappingImport((EdgeMappingImport) object.getImportedMapping());
        }
        Option<EdgeMapping> edgeMapping = new IEdgeMappingQuery(object.getImportedMapping()).getEdgeMapping();
        return edgeMapping.some() ? edgeMapping.get().getStyle() : null;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseContainerMappingImport(org.eclipse.sirius.description.ContainerMappingImport)
     */
    @Override
    public StyleDescription caseContainerMappingImport(final ContainerMappingImport object) {
        if (object.getStyle() == null && object.getImportedMapping() != null) {
            return doSwitch(object.getImportedMapping());
        } else {
            return object.getStyle();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#caseContainerMapping(org.eclipse.sirius.description.ContainerMapping)
     */
    @Override
    public StyleDescription caseContainerMapping(final ContainerMapping object) {
        return object.getStyle();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.description.util.DescriptionSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
     */
    @Override
    public StyleDescription defaultCase(final EObject object) {
        return null;
    }
}
