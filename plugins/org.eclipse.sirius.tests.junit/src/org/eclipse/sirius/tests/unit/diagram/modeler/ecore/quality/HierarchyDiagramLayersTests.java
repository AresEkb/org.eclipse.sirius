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
package org.eclipse.sirius.tests.unit.diagram.modeler.ecore.quality;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.tests.support.api.SiriusDiagramTestCase;
import org.eclipse.sirius.tests.unit.diagram.modeler.ecore.EcoreModeler;

/**
 * Refresh tests for Hierarchy diagram of ecore modeler.
 * 
 * @author mchauvin
 */
public class HierarchyDiagramLayersTests extends SiriusDiagramTestCase implements EcoreModeler {

    private DDiagram diagram;

    private EClass eClass;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        genericSetUp(TEST_SEMANTIC_MODEL_PATH, MODELER_PATH);
        initViewpoint(QUALITY_VIEWPOINT_NAME);
        final EPackage ePackage = (EPackage) semanticModel;
        eClass = EcoreFactory.eINSTANCE.createEClass();
        executeCommand(new RecordingCommand(session.getTransactionalEditingDomain()) {
            @Override
            protected void doExecute() {
                ePackage.getEClassifiers().add(eClass);
            }
        });
        diagram = (DDiagram) createRepresentation(HIERARCHY_DESC_NAME, eClass);
        assertNotNull(diagram);
    }

    public void testDefaultLayerVisibility() {

        final EPackage ePackage = (EPackage) semanticModel;

        refresh(diagram);
        assertEquals("The diagram do not contain the right number of nodes", 1, diagram.getOwnedDiagramElements().size());

        Command cmd = new RecordingCommand(session.getTransactionalEditingDomain()) {

            @Override
            protected void doExecute() {
                final EClass superClass = EcoreFactory.eINSTANCE.createEClass();
                eClass.getESuperTypes().add(superClass);
                final EClass supersuperClass = EcoreFactory.eINSTANCE.createEClass();
                superClass.getESuperTypes().add(supersuperClass);
                ePackage.getEClassifiers().add(superClass);
                ePackage.getEClassifiers().add(supersuperClass);
            }

        };

        executeCommand(cmd);
        refresh(diagram);
        assertEquals("The diagram do not contain the right number of nodes", 1 + 2 /*
                                                                                    * 2
                                                                                    * classes
                                                                                    */+ 2 /*
                                                                                           * 2
                                                                                           * edges
                                                                                           */, diagram.getOwnedDiagramElements().size());
        assertEquals("The diagram do not contain the right number of edges", 2, diagram.getEdges().size());

        final EClass superClass = (EClass) ePackage.getEClassifiers().get(0);
        final EClass supersuperClass = (EClass) ePackage.getEClassifiers().get(0);

        assertTrue(isVisible(diagram, getFirstDiagramElement(diagram, superClass)));
        assertTrue(isVisible(diagram, getFirstDiagramElement(diagram, supersuperClass)));
    }

    @Override
    protected void tearDown() throws Exception {
        diagram = null;
        eClass = null;
        super.tearDown();
    }
}
