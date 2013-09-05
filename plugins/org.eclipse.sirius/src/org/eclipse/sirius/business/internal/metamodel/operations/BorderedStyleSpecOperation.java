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
package org.eclipse.sirius.business.internal.metamodel.operations;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.BorderedStyle;
import org.eclipse.sirius.DMappingBased;
import org.eclipse.sirius.DSemanticDecorator;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.SiriusPlugin;
import org.eclipse.sirius.business.api.logger.RuntimeLoggerManager;

/**
 * Implementation of {@link BorderedStyle}.
 * 
 * @author ymortier
 */
public final class BorderedStyleSpecOperation {

    /**
     * Avoid instantiation.
     */
    private BorderedStyleSpecOperation() {

    }

    /**
     * Refresh the style.
     * 
     * @param instance
     *            the style to refresh.
     */
    public static void refresh(final BorderedStyle instance) {
        // The context.
        EObject context = null;
        if (instance.eContainer() instanceof DSemanticDecorator) {
            context = ((DSemanticDecorator) instance.eContainer()).getTarget();
        }
        // The acceleo interpreter.
        IInterpreter interpreter = null;
        if (context != null && context.eResource() != null) {
            interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(context);
        } else if (context instanceof DMappingBased) {
            interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(((DMappingBased) context).getMapping());
        }

        // update the border size.
        if (!StringUtil.isEmpty(instance.getBorderSizeComputationExpression())) {
            if (interpreter != null) {
                final Integer computedSize = RuntimeLoggerManager.INSTANCE.decorate(interpreter).evaluateInteger(context, instance,
                        SiriusPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression());
                if (computedSize != null && instance.getBorderSize().intValue() != computedSize) {
                    instance.setBorderSize(computedSize);
                }
            }
        }
    }

}
