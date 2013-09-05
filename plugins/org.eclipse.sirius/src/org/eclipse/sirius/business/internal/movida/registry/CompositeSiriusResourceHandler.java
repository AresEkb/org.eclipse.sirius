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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.eclipse.sirius.business.api.componentization.SiriusResourceHandler;
import org.eclipse.sirius.description.Sirius;

/**
 * A {@link SiriusResourceHandler} which handles all the resources handled by
 * any of a configurable set of primitive handlers. If multiple handlers can
 * handle a given resource, only the first one (in the order of their
 * registration) is used.
 * 
 * @author pierre-charles.david@obeo.fr
 */
public class CompositeSiriusResourceHandler implements SiriusResourceHandler {
    private final List<SiriusResourceHandler> handlers = Lists.newArrayList();

    /**
     * Registers a new {@link SiriusResourceHandler}. Does nothing if it is
     * already registered.
     * 
     * @param handler
     *            the handler for some new type of Sirius resource to
     *            support.
     */
    public synchronized void addResourceType(SiriusResourceHandler handler) {
        if (!this.handlers.contains(handler)) {
            this.handlers.add(handler);
        }
    }

    /**
     * Unregisters a {@link SiriusResourceHandler}. Does nothing if it was
     * not already registered.
     * 
     * @param handler
     *            the handler for some new type of Sirius resource to
     *            support.
     */
    public synchronized void removeResourceType(SiriusResourceHandler handler) {
        this.handlers.remove(handler);
    }

    /**
     * {@inheritDoc}
     */
    public synchronized boolean handles(final URI uri) {
        return Iterables.any(handlers, new Predicate<SiriusResourceHandler>() {
            public boolean apply(SiriusResourceHandler handler) {
                return handler.handles(uri);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    public synchronized Set<Sirius> collectSiriusDefinitions(Resource res) {
        final URI uri = res.getURI();
        for (SiriusResourceHandler handler : handlers) {
            if (handler.handles(uri)) {
                return handler.collectSiriusDefinitions(res);
            }
        }
        return Collections.emptySet();
    }
}
