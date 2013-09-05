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
package org.eclipse.sirius.diagram.layoutdata.tools.internal.util.configuration;

import org.eclipse.sirius.diagram.layoutdata.tools.api.util.configuration.NodeConfiguration;

/**
 * Implementation of {@link NodeConfiguration}.
 * 
 * @author dlecan
 */
public class NodeConfigurationImpl implements NodeConfiguration {

    private static final double DEFAULT_DISTANCE_AROUND_POINT = 0;

    private double distanceAroundPoint = DEFAULT_DISTANCE_AROUND_POINT;

    /**
     * {@inheritDoc}
     */
    public final double getDistanceAroundPoint() {
        return distanceAroundPoint;
    }

    /**
     * {@inheritDoc}
     */
    public final void setDistanceAroundPoint(double distanceAroundPoint) {
        this.distanceAroundPoint = distanceAroundPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "distanceAroundPoint: " + getDistanceAroundPoint();
    }

}
