/*******************************************************************************
 * Copyright (c) 2016, 2020 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.business.api.query;

import java.text.MessageFormat;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.query.IllegalStateExceptionQuery;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.Messages;
import org.eclipse.sirius.viewpoint.SiriusPlugin;

/**
 * A class aggregating all the queries (read-only!) having a {@link DRepresentationDescriptor} as a starting point.
 * 
 * @author lfasani
 * 
 */
public class DRepresentationDescriptorQuery {

    private DRepresentationDescriptor repDescriptor;

    /**
     * Create a new query.
     * 
     * @param repDescriptor
     *            the element to query.
     */
    public DRepresentationDescriptorQuery(DRepresentationDescriptor repDescriptor) {
        this.repDescriptor = repDescriptor;
    }

    /**
     * Check if the current representationDescriptor is a dangling one, ie if its target element is null or if it does
     * not belong to any session.
     * 
     * @return true if the current representation is orphan.
     */
    public boolean isDangling() {
        return repDescriptor.getTarget() == null || SessionManager.INSTANCE.getSession(repDescriptor.getTarget()) == null;
    }

    /**
     * Check if the current representationDescriptor can be found, that is, if its repPath is not null and allows to
     * retrieve the corresponding DRepresentation.
     * 
     * @return true if the representation is reachable
     */
    public boolean isRepresentationReachable() {
        boolean isRepresentationReachable = repDescriptor.isLoadedRepresentation();
        if (!isRepresentationReachable && repDescriptor.getRepPath() != null) {
            // if the diagram URI prefix indicates that the representation is stored in an aird, it implies that if
            // the representation exists then it would be yet loaded then we can rely on isLoadedRepresentation.
            String extention = repDescriptor.getRepPath().getResourceURI().fileExtension();
            if (SiriusUtil.SESSION_RESOURCE_EXTENSION.equals(extention)) {
                return isRepresentationReachable;
            }
            Resource eResource = repDescriptor.eResource();
            if (eResource != null) {
                ResourceSet resourceSet = eResource.getResourceSet();
                try {
                    isRepresentationReachable = resourceSet.getURIConverter().exists(repDescriptor.getRepPath().getResourceURI(), null);
                    // At this step, exists method may return true even if the repPath URI fragment corresponds to no
                    // representation in the case the representation is not be loaded yet
                    // CHECKSTYLE:OFF
                } catch (RuntimeException e) {
                    // CHECKSTYLE:ON
                    // we may encounter a CDOException if it fails retrieving a CDORevision for example
                    // in this case the representation must be considered as non reachable
                    SiriusPlugin.getDefault()
                            .warning(MessageFormat.format(Messages.DRepresentationDescriptorQuery_representationError, repDescriptor.getName(), repDescriptor.getRepPath(), repDescriptor.getUid()), e);
                }
            }
        }
        return isRepresentationReachable;
    }

    /**
     * Check if the representation is valid that is, both not {@link isDangling} and {@link isRepresentationReachable}.
     * 
     * @return true if the representation is valid
     */
    public boolean isRepresentationValid() {
        try {
            return !isDangling() && isRepresentationReachable();
        } catch (IllegalStateException e) {
            if (new IllegalStateExceptionQuery(e).isAConnectionLostException()) {
                return false;
            } else {
                throw e;
            }
        }
    }

}
