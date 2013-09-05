/*******************************************************************************
 * Copyright (c) 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.common.tools.api.interpreter;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Describes the result of an evaluation or a validation made by an
 * {@link IInterpreter}.
 * 
 * @since 3.2
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public interface IInterpreterStatus {

    /**
     * Status severity : warning.
     */
    String WARNING = "warning";

    /**
     * Status severity : error.
     */
    String ERROR = "error";

    /**
     * Returns the names of all possible types for the target of the evaluated
     * expression.
     * 
     * @return the names of all possible types for the target of the evaluated
     *         expression to evaluate
     */
    Collection<String> getTargetTypes();

    /**
     * Returns the feature containing the evaluated expression.
     * 
     * @return the feature containing the evaluated expression
     */
    EStructuralFeature getField();

    /**
     * Returns the message explaining the cause of the error.
     * 
     * @return the message explaining the cause of the error
     */
    String getMessage();

    /**
     * Represents the severity of this error (can be
     * {@link IInterpreterStatus#WARNING} or {@link IInterpreterStatus#ERROR}).
     * 
     * @return the severity of this error (can be
     *         {@link IInterpreterStatus#WARNING} or
     *         {@link IInterpreterStatus#ERROR})
     */
    String getSeverity();

    /**
     * Returns the line containing the error.
     * 
     * @return the line containing the error
     */
    int getLine();

    /**
     * Returns the begin position of the error.
     * 
     * @return the begin position of the error
     */
    int getPosBegin();

    /**
     * Returns the end position of the error.
     * 
     * @return the end position of the error
     */
    int getPosEnd();

}
