/*******************************************************************************
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.editor.properties.filters.description.diagramdescription;

// Start of user code specific imports

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.sirius.diagram.description.DescriptionPackage;
import org.eclipse.sirius.editor.properties.filters.common.ViewpointPropertyFilter;

// End of user code specific imports


/**
 * A filter for the init property section.
 */
public class DiagramDescriptionInitFilter extends ViewpointPropertyFilter {

	/**
	 * {@inheritDoc}
	 */
	protected EStructuralFeature getFeature() {
		return DescriptionPackage.eINSTANCE.getDiagramDescription_Init();
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof org.eclipse.sirius.diagram.description.DiagramDescription;
    }
	
	// Start of user code user methods

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.editor.properties.filters.common.ViewpointPropertyFilter#isVisible(org.eclipse.emf.ecore.EStructuralFeature)
     */
    @Override
    protected boolean isVisible(EStructuralFeature feature) {
        return false;
    }

    // End of user code user methods
	
	

}