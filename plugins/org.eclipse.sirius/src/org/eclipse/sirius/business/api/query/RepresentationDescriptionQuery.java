/*******************************************************************************
 * Copyright (c) 2007, 2009 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.business.api.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * A class aggregating all the queries (read-only!) having a
 * RepresentationDescription as a starting point.
 * 
 * @author cbrun
 * 
 */
public class RepresentationDescriptionQuery {

    private RepresentationDescription vp;

    /**
     * Create a new query.
     * 
     * @param vp
     *            the starting description.
     */
    public RepresentationDescriptionQuery(RepresentationDescription vp) {
        this.vp = vp;
    }

    /**
     * return the Viewpoint defining the representation description.
     * 
     * @return the Viewpoint defining the representation description.
     */
    public Viewpoint getParentViewpoint() {
        EObject current = vp;
        while (current != null) {
            current = current.eContainer();
            if (current instanceof Viewpoint) {
                return (Viewpoint) current;
            }
        }
        return null;
    }
}
