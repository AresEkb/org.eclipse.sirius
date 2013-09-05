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
package org.eclipse.sirius.editor.tools.internal.menu.child;

import org.eclipse.sirius.description.tool.ToolPackage;
import org.eclipse.sirius.editor.tools.api.menu.AbstractTypeRestrictingMenuBuilder;

/**
 * The edit menu.
 * 
 * @author cbrun
 * 
 */
public class EditToolsMenuBuilder extends AbstractTypeRestrictingMenuBuilder {
    /**
     * build the menu.
     */
    public EditToolsMenuBuilder() {
        super();
        addValidType(ToolPackage.eINSTANCE.getDirectEditLabel());
        addValidType(ToolPackage.eINSTANCE.getReconnectEdgeDescription());
        addValidType(ToolPackage.eINSTANCE.getContainerDropDescription());
        addValidType(ToolPackage.eINSTANCE.getDeleteElementDescription());
        addValidType(ToolPackage.eINSTANCE.getPasteDescription());
        addValidType(ToolPackage.eINSTANCE.getSelectionWizardDescription());
        addValidType(ToolPackage.eINSTANCE.getPaneBasedSelectionWizardDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getLabel() {
        return "New Element Edition...";
    }

}
