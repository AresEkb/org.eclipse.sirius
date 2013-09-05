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
package org.eclipse.sirius.editor.properties.filters.description.diagramelementmapping;

// Start of user code specific imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.sirius.description.DescriptionPackage;
import org.eclipse.sirius.editor.properties.filters.common.SiriusPropertyFilter;

// End of user code specific imports

/**
 * A filter for the semanticCandidatesExpression property section.
 */
public class DiagramElementMappingSemanticCandidatesExpressionFilter extends SiriusPropertyFilter {

    /**
     * {@inheritDoc}
     */
    protected EStructuralFeature getFeature() {
        return DescriptionPackage.eINSTANCE.getDiagramElementMapping_SemanticCandidatesExpression();
    }

    /**
     * {@inheritDoc}
     */
    protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof org.eclipse.sirius.description.DiagramElementMapping;
    }

    // Start of user code user methods
    public boolean select(Object arg0) {
        if (isEdgeMapping(arg0) && isNormalEdgeMapping(arg0) && !((org.eclipse.sirius.description.EdgeMapping) arg0).isUseDomainElement()) {
            return false;
        }
        return super.select(arg0);
    }

    private boolean isEdgeMapping(Object obj) {
        return DescriptionPackage.eINSTANCE.getEdgeMapping().isInstance(obj);
    }

    private boolean isNormalEdgeMapping(Object obj) {
        return ((EObject) obj).eClass().equals(DescriptionPackage.eINSTANCE.getEdgeMapping());
    }
    // End of user code user methods

}
