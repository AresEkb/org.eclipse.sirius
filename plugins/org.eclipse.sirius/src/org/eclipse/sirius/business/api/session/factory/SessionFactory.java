/*******************************************************************************
 * Copyright (c) 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.api.session.factory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import org.eclipse.sirius.DAnalysis;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.internal.session.SessionFactoryImpl;

/**
 * The factory to create sessions.
 * 
 * @author mchauvin
 */
public interface SessionFactory {

    /**
     * Default session factory instance.
     */
    SessionFactory INSTANCE = SessionFactoryImpl.init();

    /**
     * Create a new session from a analysis.
     * 
     * @param analysis
     *            the analysis
     * @return the created session.
     * 
     * @deprecated since 4.0.0 use {@link SessionFactory#createSession(URI)}
     *             instead.
     */
    @Deprecated
    Session createSession(DAnalysis analysis);

    /**
     * Create a new empty {@link Session} instance from the sessionModelURI. If
     * a underlying Resource exist, use it otherwise create a new Session
     * Resource.
     * 
     * @param sessionResourceURI
     *            the location URI of the new {@link Session} to create
     * 
     * @return the newly created {@link Session}
     * 
     * @throws CoreException
     *             exception when session resource creation failed
     * 
     * @since 4.0
     * @deprecated use
     *             {@link SessionFactory#createSession(URI, IProgressMonitor)}
     */
    Session createSession(URI sessionResourceURI) throws CoreException;

    /**
     * Create a new empty {@link Session} instance from the sessionModelURI. If
     * a underlying Resource exist, use it otherwise create a new Session
     * Resource.
     * 
     * @param sessionResourceURI
     *            the location URI of the new {@link Session} to create
     * @param monitor
     *            a {@link IProgressMonitor} to show progression of
     *            {@link Session} creation
     * @return the newly created {@link Session}
     * 
     * @throws CoreException
     *             exception when session resource creation failed
     * 
     * @since 4.0
     */
    Session createSession(URI sessionResourceURI, IProgressMonitor monitor) throws CoreException;

    /**
     * Create a new empty default {@link Session} instance from the
     * sessionModelURI. If a underlying Resource exist, use it otherwise create
     * a new Session Resource.
     * 
     * @param sessionResourceURI
     *            the location URI of the new {@link Session} to create
     * 
     * @return the newly created {@link Session}
     * 
     * @throws CoreException
     *             exception when session resource creation failed
     * 
     * @since 4.0
     */
    Session createDefaultSession(URI sessionResourceURI) throws CoreException;
}
