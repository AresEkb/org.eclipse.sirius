/*******************************************************************************
 * Copyright (c) 2010, 2014 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.service;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

/**
 * Services for Base1ExtA.
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class Base1ExtA {

    /**
     * Override the service of the base1.
     * 
     * @param aClass
     *            The class to check.
     * @return true if the element has an annotation with key equals base1ExtA, false otherwiser
     */
    public boolean isDocumented(final EClass aClass) {
        final EList<EAnnotation> annotations = aClass.getEAnnotations();
        int nbDoc = 0;
        for (EAnnotation annotation : annotations) {
            final EMap<String, String> details = annotation.getDetails();
            for (Map.Entry<String, String> entry : details) {
                if (entry instanceof EStringToStringMapEntryImpl) {
                    if ("Base1ExtA".equals(((EStringToStringMapEntryImpl) entry).getKey())) {
                        nbDoc++;
                    }
                }
            }
        }
        return nbDoc > 0;
    }
}
