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
package org.eclipse.sirius.table.editor.properties.filters.description.tablenavigationdescription;

// Start of user code specific imports

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.sirius.editor.properties.filters.common.SiriusPropertyFilter;
import org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage;

// End of user code specific imports

/**
 * A filter for the tableDescription property section.
 */
public class TableNavigationDescriptionTableDescriptionFilter extends SiriusPropertyFilter {

    /**
     * {@inheritDoc}
     */
    protected EStructuralFeature getFeature() {
        return DescriptionPackage.eINSTANCE.getTableNavigationDescription_TableDescription();
    }

    /**
     * {@inheritDoc}
     */
    protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof org.eclipse.sirius.table.metamodel.table.description.TableNavigationDescription;
    }

    // Start of user code user methods

    // End of user code user methods

}
