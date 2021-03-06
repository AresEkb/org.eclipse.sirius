/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.diagram.sequence.ui.tool.internal.util;

import java.util.List;

import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.LifelineEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceDiagramEditPart;

import com.google.common.base.Preconditions;

/**
 * Queries on a sequence diagram.
 * 
 * @author pcdavid
 */
public class SequenceDiagramEPQuery {
    private final SequenceDiagramEditPart diagram;

    /**
     * Constructor.
     * 
     * @param diagram
     *            the diagram to query.
     */
    public SequenceDiagramEPQuery(SequenceDiagramEditPart diagram) {
        this.diagram = Preconditions.checkNotNull(diagram);
    }

    public List<LifelineEditPart> getAllLifelines() {
        return EditPartsHelper.getAllLifelines(diagram);
    }
}
