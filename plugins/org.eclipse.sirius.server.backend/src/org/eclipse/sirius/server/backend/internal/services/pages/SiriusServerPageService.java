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
package org.eclipse.sirius.server.backend.internal.services.pages;

import static org.eclipse.sirius.server.api.SiriusServerResponse.STATUS_NOT_FOUND;
import static org.eclipse.sirius.server.api.SiriusServerResponse.STATUS_OK;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.server.api.ISiriusServerService;
import org.eclipse.sirius.server.api.SiriusServerPath;
import org.eclipse.sirius.server.api.SiriusServerResponse;
import org.eclipse.sirius.server.backend.internal.utils.SiriusServerUtils;
import org.eclipse.sirius.server.backend.internal.workflow.Workflow;

/**
 * The service used to manipulate a page of the workflow of a project.
 *
 * @author sbegaudeau
 */
@SiriusServerPath("/projects/{projectName}/pages/{pageIdentifier}")
public class SiriusServerPageService implements ISiriusServerService {

    /**
     * The name of the variable used to capture the name of the project.
     */
    private static final Object PROJECT_NAME = "projectName"; //$NON-NLS-1$

    /**
     * The name of the variable used to capture the identifier of the page.
     */
    private static final Object PAGE_IDENTIFIER = "pageIdentifier"; //$NON-NLS-1$

    @Override
    public SiriusServerResponse doGet(HttpServletRequest request, Map<String, String> variables, String remainingPart) {
        String projectName = variables.get(PROJECT_NAME);
        String pageIdentifier = variables.get(PAGE_IDENTIFIER);

        Optional<SiriusServerPageDto> optionalPage = SiriusServerUtils.getSessionFromProject(projectName).flatMap(session -> getPage(session, pageIdentifier));
        if (optionalPage.isPresent()) {
            SiriusServerPageDto page = optionalPage.get();
            return new SiriusServerResponse(STATUS_OK, page);
        }

        return new SiriusServerResponse(STATUS_NOT_FOUND);
    }

    /**
     * Finds the page with the given pageIdentifier in the given modeling
     * project.
     *
     * @param modelingProject
     *            The modeling project
     * @param pageIdentifier
     *            The page identifier
     * @return An optional containing the page found or an empty optional if it
     *         does not exist
     */
    private Optional<SiriusServerPageDto> getPage(Session session, String pageIdentifier) {
        return Workflow.on(session).findPageById(pageIdentifier).map(page -> {
            List<SiriusServerSectionDto> sections = page.getSections().stream().map(section -> {
                List<SiriusServerActivityDto> activities = section.getActivities().stream().map(desc -> {
                    return new SiriusServerActivityDto(desc.getName(), desc.getLabelExpression());
                }).collect(Collectors.toList());
                return new SiriusServerSectionDto(section.getName(), section.getTitleExpression(), activities);

            }).collect(Collectors.toList());
            return new SiriusServerPageDto(page.getName(), page.getTitleExpression(), page.getDescriptionExpression(), sections);
        });
    }

}
