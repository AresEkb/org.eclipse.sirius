/*******************************************************************************
 * Copyright (c) 2018, 2019 Obeo
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
package org.eclipse.sirius.server.diagram.internal.actions.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.server.diagram.internal.SiriusDiagramServer;
import org.eclipse.sirius.server.diagram.internal.actions.ExecuteContainerCreationToolAction;
import org.eclipse.sirius.server.diagram.internal.actions.ISiriusActionHandler;
import org.eclipse.sirius.server.diagram.internal.interpreter.InterpreterVariables;
import org.eclipse.sirius.server.diagram.internal.interpreter.SiriusServerInterpreter;
import org.eclipse.sirius.viewpoint.description.tool.ModelOperation;
import org.eclipse.sprotty.Action;

/**
 * Handler for the {@link ExecuteContainerCreationToolAction} received by the {@link SiriusDiagramServer}.
 *
 * @author sbegaudeau
 */
public class SiriusExecuteContainerCreationToolActionHandler implements ISiriusActionHandler {
	/**
	 * The aql expression used to execute a {@link ModelOperation} programmatically.
	 */
	private static final String AQL_EXECUTE_OPERATION = "aql:self.executeOperation('%1$s')"; //$NON-NLS-1$

	@Override
	public boolean canHandle(SiriusDiagramServer server, Action action) {
		return action instanceof ExecuteContainerCreationToolAction;
	}

	@Override
	public void handle(SiriusDiagramServer siriusDiagramServer, Action action) {
		if (action instanceof ExecuteContainerCreationToolAction) {
			this.executeContainerCreationToolAction(siriusDiagramServer, (ExecuteContainerCreationToolAction) action);
		}
	}

	/**
	 * Execute the tool identified by its name.
	 *
	 * @param siriusDiagramServer
	 *            The {@link SiriusDiagramServer}
	 * @param action
	 *            The action
	 */
	private void executeContainerCreationToolAction(SiriusDiagramServer siriusDiagramServer, ExecuteContainerCreationToolAction action) {
		Session session = siriusDiagramServer.getSession();
		DDiagram dDiagram = siriusDiagramServer.getDDiagram();

		// @formatter:off
		Optional<ContainerCreationDescription> optionalContainerCreationDescription = dDiagram.getDescription()
			.getAllTools()
			.stream()
			.filter(tool -> action.getToolName().equals(tool.getName()))
			.filter(ContainerCreationDescription.class::isInstance)
			.map(ContainerCreationDescription.class::cast)
			.findFirst();
		// @formatter:on

		optionalContainerCreationDescription.ifPresent(tool -> this.executeCreationTool(session, dDiagram, tool));
	}

	/**
	 * Execute a {@link ContainerCreationDescription} tool.
	 *
	 * @param session
	 *            The session
	 * @param representation
	 *            The representation
	 * @param tool
	 *            The {@link ContainerCreationDescription} tool
	 */
	private void executeCreationTool(Session session, DDiagram representation, ContainerCreationDescription tool) {
		ModelOperation modelOperation = tool.getInitialOperation().getFirstModelOperations();

		String expression = EcoreUtil.getURI(modelOperation).toString();
		expression = expression.replace("'", "\\'"); //$NON-NLS-1$//$NON-NLS-2$
		String expr = String.format(AQL_EXECUTE_OPERATION, expression);
		Map<String, Object> variables = new HashMap<>();
		if (representation instanceof DSemanticDiagram) {
			DSemanticDiagram dsd = (DSemanticDiagram) representation;
			variables.put(InterpreterVariables.SELF_VARIABLE, dsd.getTarget());
			variables.put(InterpreterVariables.CONTAINER_VARIABLE, dsd.getTarget());
			variables.put(InterpreterVariables.CONTAINER_VIEW_VARIABLE, dsd);
		}

		SiriusServerInterpreter.executeExpression(session, variables, expr);
	}
}
