/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.server.api;

import java.util.Optional;

import org.eclipse.core.runtime.IStatus;

/**
 * Class used to describe the response of the HTTP service.
 *
 * @author sbegaudeau
 */
public class SiriusServerResponse {

    /** The application/json content type. */
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json"; //$NON-NLS-1$

    /** The OK status. */
    public static final int STATUS_OK = 200;

    /** The CREATED status. */
    public static final int STATUS_CREATED = 201;

    /** The BAD REQUEST status. */
    public static final int STATUS_BAD_REQUEST = 400;

    /** The NOT FOUND status. */
    public static final int STATUS_NOT_FOUND = 404;

    /** The INTERNAL SERVER ERROR status. */
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;

    /**
     * The status.
     */
    private int status;

    /**
     * The payload.
     */
    private Object payload;

    /**
     * The content type.
     */
    private String contentType;

    /**
     * The constructor.
     *
     * @param status
     *            The status
     */
    public SiriusServerResponse(int status) {
        this(status, null, CONTENT_TYPE_APPLICATION_JSON);
    }

    /**
     * The constructor.
     *
     * @param status
     *            The status
     * @param payload
     *            The payload
     */
    public SiriusServerResponse(int status, Object payload) {
        this(status, payload, CONTENT_TYPE_APPLICATION_JSON);
    }

    /**
     * The constructor.
     *
     * @param status
     *            The status
     * @param payload
     *            The payload
     * @param contentType
     *            The content type
     */
    public SiriusServerResponse(int status, Object payload, String contentType) {
        this.status = status;
        this.payload = payload;
        this.contentType = contentType;
    }

    /**
     * Factory method to create a response with the proper status from an
     * optional payload.
     *
     * @param payload
     *            the payload.
     * @return the response.
     */
    public static SiriusServerResponse ofOptional(Optional<? extends Object> payload) {
        if (payload.isPresent()) {
            return new SiriusServerResponse(STATUS_OK, payload.get());
        } else {
            return new SiriusServerResponse(STATUS_NOT_FOUND);
        }
    }

    /**
     * Converts an {@link IStatus} into a {@link SiriusServerResponse}.
     *
     * @param status
     *            the status.
     * @return an {@link SiriusServerResponse} which indicates success or
     *         failure depending on the status.
     */
    public static SiriusServerResponse ofStatus(IStatus status) {
        if (status.getSeverity() < IStatus.ERROR) {
            return new SiriusServerResponse(STATUS_OK);
        } else {
            return new SiriusServerResponse(STATUS_INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Return the status.
     *
     * @return the status
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Return the payload.
     *
     * @return the payload
     */
    public Object getPayload() {
        return this.payload;
    }

    /**
     * Return the contentType.
     *
     * @return the contentType
     */
    public String getContentType() {
        return this.contentType;
    }
}
