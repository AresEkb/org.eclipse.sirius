/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.internal.view.factories;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

import com.google.common.collect.Lists;

import org.eclipse.sirius.diagram.internal.edit.parts.CustomStyleEditPart;
import org.eclipse.sirius.diagram.internal.view.factories.AbstractDesignerNodeFactory;
import org.eclipse.sirius.diagram.part.SiriusVisualIDRegistry;

/**
 * @was-generated
 */
public class CustomStyleViewFactory extends AbstractDesignerNodeFactory {

    /**
     * @was-generated
     */
    protected List<?> createStyles(View view) {
        List<Style> styles = Lists.newArrayList();
        styles.add(NotationFactory.eINSTANCE.createShapeStyle());
        return styles;
    }

    /**
     * @was-generated
     */
    protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
        if (semanticHint == null) {
            semanticHint = SiriusVisualIDRegistry.getType(CustomStyleEditPart.VISUAL_ID);
            view.setType(semanticHint);
        }
        super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
    }
}
