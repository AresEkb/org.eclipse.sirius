/*******************************************************************************
 * Copyright (c) 2009, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tools.internal.command.builders;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.DDiagram;
import org.eclipse.sirius.DDiagramElementContainer;
import org.eclipse.sirius.DSemanticDecorator;
import org.eclipse.sirius.DSemanticDiagram;
import org.eclipse.sirius.business.api.helper.task.InitInterpreterVariablesTask;
import org.eclipse.sirius.business.api.helper.task.UnexecutableTask;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.query.IdentifiedElementQuery;
import org.eclipse.sirius.business.internal.helper.task.CreateContainerTask;
import org.eclipse.sirius.description.tool.AbstractVariable;
import org.eclipse.sirius.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.tools.api.command.DCommand;
import org.eclipse.sirius.tools.api.interpreter.InterpreterUtil;

/**
 * .
 * 
 * @author mchauvin
 */
public class ContainerCreationCommandBuilder extends AbstractCommandBuilder {

    /**
     * Current tool description from which this CommandBuilder build a Command.
     */
    protected ContainerCreationDescription tool;

    /**
     * {@link DDiagramElementContainer} on which the current
     * ContainerCreationCommandBuilder's operations are executed.
     */
    protected DDiagramElementContainer nodeContainer;

    /**
     * {@link DDiagramElementContainer} on which (or the parent diagram of the
     * diagram element container on which) the current
     * ContainerCreationCommandBuilder's operations are executed.
     */
    protected DDiagram diagram;

    private final boolean createInDiagram;

    /**
     * Create a new container creation command builder instance.
     * 
     * @param tool
     *            a container creation tool
     * @param nodeContainer
     *            the node container in which the created container should be
     *            displayed
     */
    public ContainerCreationCommandBuilder(final ContainerCreationDescription tool, final DDiagramElementContainer nodeContainer) {
        this.tool = tool;
        this.nodeContainer = nodeContainer;
        this.diagram = nodeContainer.getParentDiagram();
        this.createInDiagram = false;
    }

    /**
     * Create a new container creation command builder instance.
     * 
     * @param tool
     *            a container creation tool
     * @param diagram
     *            the diagram in which the created element should be displayed
     */
    public ContainerCreationCommandBuilder(final ContainerCreationDescription tool, final DDiagram diagram) {
        this.tool = tool;
        this.diagram = diagram;
        this.createInDiagram = true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.tools.internal.command.builders.CommandBuilder#buildCommand()
     */
    public Command buildCommand() {
        Command command = UnexecutableCommand.INSTANCE;
        if (createInDiagram && diagram != null) {
            command = buildInDiagramCommand();
        } else if (nodeContainer != null) {
            command = buildInDNodeContainerCommand();
        }
        return command;
    }

    private Command buildInDiagramCommand() {
        EObject model = null;
        if (permissionAuthority.canEditInstance(diagram)) {
            if (diagram instanceof DSemanticDiagram) {
                model = ((DSemanticDiagram) diagram).getTarget();
            }
            if (model != null && checkPrecondition(diagram, tool)) {
                final DCommand result = buildCreateNodeCommandFromTool(model, diagram);
                result.getTasks().add(new CreateContainerTask(tool, result, modelAccessor, diagram));
                addRefreshTask(diagram, result, tool);
                if (diagram instanceof DSemanticDecorator) {
                    addRemoveDanglingReferencesTask(result, tool, (DSemanticDecorator) diagram);
                }
                return result;
            }
        }
        return UnexecutableCommand.INSTANCE;
    }

    private Command buildInDNodeContainerCommand() {
        if (permissionAuthority.canEditInstance(nodeContainer)) {
            final EObject model = nodeContainer.getTarget();
            if (model != null && checkPrecondition(nodeContainer, tool)) {
                final DCommand result = buildCreateNodeCommandFromTool(model, nodeContainer);
                result.getTasks().add(new CreateContainerTask(tool, result, modelAccessor, nodeContainer));
                addRefreshTask(nodeContainer, result, tool);
                addRemoveDanglingReferencesTask(result, tool, nodeContainer);
                return result;
            }
        }
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Build a command to create a {@link org.eclipse.sirius.DNode}
     * considering the semantic container and a
     * {@link ContainerCreationDescription}.
     * 
     * @param semanticContainer
     *            the semantic container.
     * @param container
     *            the container
     * @return a command able to create the {@link org.eclipse.sirius.DNode}.
     */
    protected DCommand buildCreateNodeCommandFromTool(final EObject semanticContainer, final EObject container) {
        final DCommand result = createEnclosingCommand();
        if (permissionAuthority.canEditInstance(container)) {
            final IInterpreter interpreter = InterpreterUtil.getInterpreter(semanticContainer);
            final Map<AbstractVariable, Object> variables = new HashMap<AbstractVariable, Object>();
            result.getTasks().add(new InitInterpreterVariablesTask(variables, interpreter, uiCallback));
            variables.put(tool.getVariable(), semanticContainer);
            variables.put(tool.getViewVariable(), container);
            addDiagramVariable(result, container, interpreter);

            Option<DDiagram> parentDiagram = new EObjectQuery(container).getParentDiagram();
            result.getTasks().add(taskHelper.buildTaskFromModelOperation(parentDiagram.get(), semanticContainer, tool.getInitialOperation().getFirstModelOperations()));
        } else {
            result.getTasks().add(UnexecutableTask.INSTANCE);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    protected String getEnclosingCommandLabel() {
        return new IdentifiedElementQuery(tool).getLabel();
    }
}
