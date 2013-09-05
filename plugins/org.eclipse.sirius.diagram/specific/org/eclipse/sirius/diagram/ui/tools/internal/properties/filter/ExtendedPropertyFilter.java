/*******************************************************************************
 * Copyright (c) 2007, 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.properties.filter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.SiriusPlugin;
import org.eclipse.sirius.diagram.ui.tools.api.properties.filter.AbstractPropertyFilter;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessorsRegistry;

/**
 * Filters the extension property section.
 * 
 * @author ymortier
 */
public class ExtendedPropertyFilter extends AbstractPropertyFilter {

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.ui.tools.api.properties.filter.AbstractPropertyFilter#select(java.lang.Object)
     */
    @Override
    public boolean select(final Object toTest) {
        final boolean select = super.select(toTest);
        boolean areAnnotation = false;
        ModelAccessorsRegistry modelAccessorRegistry = SiriusPlugin.getDefault().getModelAccessorRegistry();
        final Iterator<EObject> iterSemantics = this.semanticElements.iterator();
        while (iterSemantics.hasNext() && !areAnnotation) {
            final EObject next = iterSemantics.next();
            ModelAccessor modelAccessor = modelAccessorRegistry.getModelAccessor(next);
            if (modelAccessor.hasExtension(next)) {
                areAnnotation = true;
            } else if (modelAccessor.isExtension(next)) {
                areAnnotation = true;
            }

        }
        return select && areAnnotation;
    }
}
