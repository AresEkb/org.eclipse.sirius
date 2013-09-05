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
package org.eclipse.sirius.business.api.componentization;

import java.util.Collection;

import org.eclipse.sirius.description.Sirius;

/**
 * A listener to know {@link DiagramDescriptionMappingsManager} recompute
 * mappings.
 * 
 * @author mchauvin
 * @since 2.2
 */
public interface DiagramDescriptionMappingsManagerListener {

    /**
     * This method is called when mappings have been computed.
     * @param enabledSiriuss 
     */
    void mappingsComputed(Collection<Sirius> enabledSiriuss);

    /**
     * This method is called when the description mappings manager will be
     * disposed.
     */
    void dispose();

}
