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
package org.eclipse.sirius.business.internal.movida.dependencies;

import java.util.Set;

import com.google.common.base.Function;

/**
 * Defines a binary relation between elements of type <code>T</code>.
 * 
 * @author pierre-charles.david@obeo.fr
 */
public interface Relation<T> extends Function<T, Set<T>> {
    /**
     * Returns all the elements which are related to the specified element
     * through this relation.
     * 
     * @param from
     *            an element.
     * @return the set of all the elements <code>to</code> such as
     *         <code>(from, to)</code> are in this relation.
     */
    Set<T> apply(T from);
}
