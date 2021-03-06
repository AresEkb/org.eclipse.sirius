/*******************************************************************************
 * Copyright (c) 2018 Obeo.
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
package org.eclipse.sirius.server.backend.internal.services.project;

import java.util.List;

/**
 * The DTO used to represent a section of the workflow page.
 *
 * @author sbegaudeau
 */
@SuppressWarnings({ "checkstyle::javadocmethod", "checkstyle::javadocfield" })
public class SiriusServerSectionDto {
    private String identifier;

    private String name;

    private List<SiriusServerActivityDto> activities;

    /**
     * The constructor.
     * 
     * @param identifier
     *            The identifier
     * @param name
     *            The name
     * @param activities
     *            The activities
     */
    public SiriusServerSectionDto(String identifier, String name, List<SiriusServerActivityDto> activities) {
        this.identifier = identifier;
        this.name = name;
        this.activities = activities;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public List<SiriusServerActivityDto> getActivities() {
        return this.activities;
    }
}
