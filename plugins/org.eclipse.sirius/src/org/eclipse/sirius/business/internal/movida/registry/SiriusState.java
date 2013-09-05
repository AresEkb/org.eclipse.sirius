/*******************************************************************************
 * Copyright (c) 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.movida.registry;

/**
 * The status of a Sirius definition.
 * 
 * @author pierre-charles.david@obeo.fr
 */
public enum SiriusState {
    /**
     * The Sirius has been identified, but its actual state has not been
     * determined yet.
     */
    UNDEFINED,
    /**
     * The Sirius is present and loaded, but the model is not valid.
     */
    INVALID,
    /**
     * The Sirius is present and valid, but some of its dependencies are not.
     */
    INSTALLED,
    /**
     * The Sirius and all its dependencies are valid. It is ready to be used
     * in a session, but is not actually enabled in any open sessions.
     */
    RESOLVED
}
