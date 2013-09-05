/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.api.session;

/**
 * The synchronization status of a Session.
 * 
 * @author cbrun
 * @since 2.0
 * 
 */
public enum SessionStatus {
    /**
     * The session is dirty and has data to synchronize.
     */
    DIRTY,
    /**
     * The session is in sync, all the data is saved.
     */
    SYNC
}
