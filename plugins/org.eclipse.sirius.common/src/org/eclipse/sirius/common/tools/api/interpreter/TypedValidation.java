/*******************************************************************************
 * Copyright (c) 2015 Obeo.
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
package org.eclipse.sirius.common.tools.api.interpreter;

/**
 * An interface for {@link IInterpreter} implementations which are able to
 * provide rich information when analyzing an expression.
 * 
 * This interface is introduced as an extension of the {@link IInterpreter}
 * interface in order to keep compatibility with legacy implementations.
 * 
 * @author cedric
 * @since 3.0
 */
public interface TypedValidation {

    /**
     * Performs a static analysis of an expression and return the result.
     * 
     * @param context
     *            the {@link IInterpreterContext} to use for validating this
     *            expression
     * @param expression
     *            the expression to analyze
     * @return a ValidationResult capturing errors, warning, and static analysis
     *         results.
     *         
     * @since 3.0.0
     */
    ValidationResult analyzeExpression(IInterpreterContext context, String expression);

}
