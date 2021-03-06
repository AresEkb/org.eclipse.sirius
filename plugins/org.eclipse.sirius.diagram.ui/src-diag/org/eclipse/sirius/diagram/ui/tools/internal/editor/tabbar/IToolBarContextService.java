/*******************************************************************************
 * Copyright (c) 2012, 2013 THALES GLOBAL SERVICES.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar;

import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchPage;

/**
 * A service to retrieve the toolbar menu manager.
 * 
 * @author fbarbin
 */
public interface IToolBarContextService {

    /**
     * Singleton.
     */
    IToolBarContextService INSTANCE = new ToolBarContextService();

    /**
     * provides the current tool bar menu manager.
     * 
     * @return the current menu manager.
     */
    ToolBarManager getMenuManager();

    /**
     * Retrieves the current tabbar page.
     * 
     * @return the current workbenchPage.
     */
    IWorkbenchPage getPage();

    /**
     * dispose the service.
     */

    void dispose();

    /**
     * provides diagram part.
     * 
     * @return the workbench part.
     */
    IDiagramWorkbenchPart getPart();

}
