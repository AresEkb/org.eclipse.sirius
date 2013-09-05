/*******************************************************************************
 * Copyright (c) 2007, 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.repair.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.IdentityCommand;

import org.eclipse.sirius.DView;
import org.eclipse.sirius.business.api.repair.IRepairParticipant;

/**
 * SaveModelElementStateRecordingCommand.
 * 
 * @author esteban
 */
public class SaveModelElementStateCommand extends IdentityCommand {

    private IRepairParticipant participant;

    private DView view;

    private IProgressMonitor monitor;

    /**
     * Default constructor.
     * 
     * @param participant
     *            {@link IRepairParticipant}
     * @param view
     *            {@link DView}
     * @param monitor
     *            {@link IProgressMonitor}
     */
    public SaveModelElementStateCommand(IRepairParticipant participant, DView view, IProgressMonitor monitor) {
        super();
        this.participant = participant;
        this.view = view;
        this.monitor = monitor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        participant.saveModelElementState(view, monitor);
        participant = null;
        view = null;
    }

    /**
     * Overridden to avoid the CommandStack to keep a reference to this command.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean canUndo() {
        return false;
    }
}
