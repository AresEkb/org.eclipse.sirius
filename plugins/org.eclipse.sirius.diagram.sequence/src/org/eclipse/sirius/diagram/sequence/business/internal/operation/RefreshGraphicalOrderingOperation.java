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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;

import org.eclipse.sirius.diagram.business.internal.operation.AbstractModelChangeOperation;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.VerticalPositionFunction;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.SequenceDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.ordering.RefreshOrderingHelper;
import org.eclipse.sirius.diagram.sequence.ordering.EventEnd;
import org.eclipse.sirius.diagram.sequence.ordering.EventEndsOrdering;
import org.eclipse.sirius.diagram.sequence.ordering.SingleEventEnd;

/**
 * An operation to re-compute the graphical ordering in which events appear on a
 * diagram.
 * 
 * <pre>
 * GMF View Model ------> GraphicalMessageOrdering
 * </pre>
 * 
 * @author pcdavid, smonnier
 */
public class RefreshGraphicalOrderingOperation extends AbstractModelChangeOperation<Void> {
    private final SequenceDDiagram sequenceDiagram;

    /**
     * Creates a command which updates the graphical ordering of events store in
     * the model using the latest available graphical informations.
     * 
     * @param sequenceDiagram
     *            the diagram whose graphical ordering should be refreshed.
     */
    public RefreshGraphicalOrderingOperation(SequenceDiagram sequenceDiagram) {
        super("Refresh graphical ordering");
        this.sequenceDiagram = sequenceDiagram.getSequenceDDiagram();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute() {
        EventEndsOrdering graphicalOrdering = sequenceDiagram.getGraphicalOrdering();
        if (graphicalOrdering != null) {
            refreshGlobalOrdering(graphicalOrdering);
        }
        return null;
    }

    private void refreshGlobalOrdering(EventEndsOrdering graphicalOrdering) {
        if (graphicalOrdering.eContainer() instanceof SequenceDDiagram) {
            refreshGlobalOrdering(graphicalOrdering, new CustomVerticalPositionFunction(sequenceDiagram));
        }
    }

    /**
     * Recomputes the graphical ordering of events.
     * 
     * @param sequenceDiagram
     *            the diagram.
     * 
     * @param verticalPosition
     *            the function to use to obtain the vertical position of the
     *            event ends.
     */
    private void refreshGlobalOrdering(EventEndsOrdering graphicalOrdering, VerticalPositionFunction verticalPosition) {
        final Map<EventEnd, Integer> positions = new MapMaker().makeComputingMap(verticalPosition);
        Predicate<EventEnd> isValidEnd = new Predicate<EventEnd>() {
            public boolean apply(EventEnd input) {
                Integer pos = positions.get(input);
                return pos != VerticalPositionFunction.INVALID_POSITION && pos != -VerticalPositionFunction.INVALID_POSITION;
            }
        };
        List<EventEnd> allEnds = Lists.newArrayList(Iterables.filter(RefreshOrderingHelper.getAllEventEnds(sequenceDiagram), isValidEnd));
        Collections.sort(allEnds, Ordering.natural().onResultOf(Functions.forMap(positions)));
        RefreshOrderingHelper.updateIfNeeded(graphicalOrdering.getEventEnds(), allEnds);
    }

    /**
     * Custom vertical function which do not return the real location of an
     * event end but allow to correctly order event end from logically
     * instantaneous ISequenceEvent.
     * 
     * @author mPorhel
     */
    private static class CustomVerticalPositionFunction extends VerticalPositionFunction {

        /**
         * {@inheritDoc}
         */
        public CustomVerticalPositionFunction(SequenceDDiagram diagram) {
            super(diagram);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Integer apply(EventEnd end) {
            Integer customPos = super.apply(end);
            if (customPos != INVALID_POSITION || customPos != -INVALID_POSITION) {
                /*
                 * Simulates a 10x zoom so that we can adjust the
                 * SingleEventEnds position to get the proper ordering. This
                 * manipulation gives us the right ordering, but the actual
                 * Integer values returned by the function should not be used
                 * for anything else than comparing relative positions.
                 */
                customPos *= 10;

                if (end instanceof SingleEventEnd) {
                    SingleEventEnd see = (SingleEventEnd) end;
                    if (see.isStart()) {
                        customPos -= 1;
                    } else {
                        customPos += 1;
                    }

                }
            }
            return customPos;
        }
    }
}
