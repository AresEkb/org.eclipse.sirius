/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.business.api.migration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.sirius.viewpoint.description.Group;
import org.osgi.framework.Version;

/**
 * <p>
 * Clients wishing to participate in the migration process of VSM must subclass
 * this class, and implement
 * {@link #getAttribute(org.eclipse.emf.ecore.EClass, String, String)},
 * {@link #getLocalElement(org.eclipse.emf.ecore.EClass, String, String)},
 * {@link #getType(org.eclipse.emf.ecore.EPackage, String, String)}, etc.
 * </p>
 * <p>
 * This class is intended to be subclassed by clients.
 * </p>
 * 
 * @author lredor
 */
public abstract class AbstractVSMMigrationParticipant extends AbstractMigrationParticipant {
    /**
     * {@inheritDoc}
     */
    public void postLoad(XMLResource resource, String loadedVersion) {
        super.postLoad(resource, loadedVersion);
        // The migration often uses Group and loaded version at osgi form
        for (EObject root : resource.getContents()) {
            if (root instanceof Group) {
                postLoad((Group) root, Version.parseVersion(loadedVersion));
                break;
            }
        }
    }

    /**
     * The post load step often uses {@link Group} and loaded version at osgi
     * form so this method is called by the
     * {@link #postLoad(XMLResource, String)} method, to avoid boring job of
     * getting group and parsing version.
     * 
     * @param group
     *            The group of the resource to migrate
     * @param loadedVersion
     *            the osgi form of the loaded version
     */
    protected void postLoad(Group group, Version loadedVersion) {
        // Nothing to migrate by default.
    }
}
