/*******************************************************************************
 * Copyright (c) 2018 Obeo.
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
package org.eclipse.sirius.services.diagram.api.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.services.diagram.api.AbstractSiriusDiagramAction;
import org.eclipse.sirius.services.diagram.api.entities.SiriusDiagramTool;

/**
 * This action is used to send the tools computed back to the client.
 *
 * @author sbegaudeau
 */
public class SiriusDiagramSetToolsAction extends AbstractSiriusDiagramAction {

    /**
     * The kind of the action.
     */
    private static final String KIND = "setTools"; //$NON-NLS-1$

    /**
     * The tools.
     */
    private List<SiriusDiagramTool> tools = new ArrayList<>();

    /**
     * The constructor.
     *
     * @param tools
     *            The tools
     */
    public SiriusDiagramSetToolsAction(List<SiriusDiagramTool> tools) {
        super(KIND);
        this.tools = tools;
    }

    /**
     * Return the tools.
     *
     * @return the tools
     */
    public List<SiriusDiagramTool> getTools() {
        return this.tools;
    }

}
