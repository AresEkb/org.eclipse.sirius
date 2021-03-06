/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.business.internal.helper.task;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface to implement for task which delete semantic elements.
 * 
 * @author mchauvin
 */
public interface IDeletionTask {

    /**
     * Get the deleted elements.
     * 
     * @return the deleted elements
     */
    Collection<EObject> getDeletedElements();

}
