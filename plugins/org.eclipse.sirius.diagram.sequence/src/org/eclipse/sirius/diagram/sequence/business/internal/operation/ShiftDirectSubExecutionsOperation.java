/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.sequence.business.internal.operation;

import org.eclipse.gmf.runtime.notation.View;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.diagram.business.internal.operation.AbstractModelChangeOperation;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.AbstractNodeEvent;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.ISequenceElementAccessor;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.ISequenceEvent;
import org.eclipse.sirius.diagram.sequence.util.Range;

/**
 * This command moves all the direct sub-executions of a given ExecutionEdipart
 * vertically. It is used when an execution is resized from the top to ensure
 * the sub-executions stay at the same absolute position instead of moving along
 * (as they are relative to the top of the parent).
 * 
 * @author pcdavid, smonnier
 */
public class ShiftDirectSubExecutionsOperation extends AbstractModelChangeOperation<Void> {
    private final int deltaY;

    private final ISequenceEvent parent;

    /**
     * Constructor.
     * 
     * @param parent
     *            the execution or lifeline whose direct sub-executions must be
     *            shifted.
     * @param deltaY
     *            the vertical amount to shift the sub-executions (in logical
     *            space).
     */
    public ShiftDirectSubExecutionsOperation(ISequenceEvent parent, int deltaY) {
        super("Shift sub-executions' positions by " + deltaY);
        this.parent = Preconditions.checkNotNull(parent);
        this.deltaY = deltaY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute() {

        for (View view : Iterables.filter(Iterables.filter(parent.getNotationView().getChildren(), View.class), AbstractNodeEvent.notationPredicate())) {
            Option<AbstractNodeEvent> execution = ISequenceElementAccessor.getAbstractNodeEvent(view);
            if (execution.some()) {
                AbstractNodeEvent ise = execution.get();
                Range rg = ise.getVerticalRange();
                Range nrg = new Range(rg.getLowerBound() + deltaY, rg.getUpperBound() + deltaY);
                ise.setVerticalRange(nrg);
            }
        }
        return null;
    }

}
