/*******************************************************************************
 * Copyright (c) 2010, 2018 THALES GLOBAL SERVICES.
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
package org.eclipse.sirius.tests.unit.api.vsm.editor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.sirius.diagram.description.tool.DiagramCreationDescription;
import org.eclipse.sirius.diagram.description.tool.DiagramNavigationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.description.tool.ToolGroup;
import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.diagram.description.tool.provider.ToolItemProviderAdapterFactory;
import org.eclipse.sirius.viewpoint.description.DocumentedElement;
import org.eclipse.sirius.viewpoint.description.tool.GroupMenu;
import org.eclipse.sirius.viewpoint.description.tool.OperationAction;
import org.eclipse.sirius.viewpoint.description.tool.PopupMenu;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

import junit.framework.TestCase;

/**
 * Check the custom menu for the vsm editor.
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class PopupMenuTest extends TestCase {

    public void testNavigationMenuOnToolSection() {
        // Create a fake ToolSection
        ToolSection toolSection = ToolFactory.eINSTANCE.createToolSection();

        ToolItemProviderAdapterFactory itemProviderAdapterFactory = new ToolItemProviderAdapterFactory();
        Adapter adapter = itemProviderAdapterFactory.createToolSectionAdapter();

        assertEquals("It must be one child to add a diagram navigation.", 1, getNbChildren(adapter, toolSection, DiagramNavigationDescription.class));
    }

    public void testCreationMenuOnToolSection() {
        // Create a fake ToolSection
        ToolSection toolSection = ToolFactory.eINSTANCE.createToolSection();

        ToolItemProviderAdapterFactory itemProviderAdapterFactory = new ToolItemProviderAdapterFactory();
        Adapter adapter = itemProviderAdapterFactory.createToolSectionAdapter();

        assertEquals("It must be one child to add a diagram creation.", 1, getNbChildren(adapter, toolSection, DiagramCreationDescription.class));
    }

    public void testPopupMenuOnToolSection() {
        // Create a fake ToolSection
        ToolSection toolSection = ToolFactory.eINSTANCE.createToolSection();

        ToolItemProviderAdapterFactory itemProviderAdapterFactory = new ToolItemProviderAdapterFactory();
        Adapter adapter = itemProviderAdapterFactory.createToolSectionAdapter();

        assertEquals("The capability to create Popup in tool section must be activated.", 1, getNbChildren(adapter, toolSection, PopupMenu.class));
    }

    public void testPopupMenuInToolGroupSection() {
        ToolGroup toolGroup = ToolFactory.eINSTANCE.createToolGroup();

        ToolItemProviderAdapterFactory toolItemProviderAdapterFactory = new ToolItemProviderAdapterFactory();
        Adapter adapter = toolItemProviderAdapterFactory.createToolGroupAdapter();

        assertEquals("The capability to create Popup in tool section must be deactivated.", 0, getNbChildren(adapter, toolGroup, PopupMenu.class));
    }

    public void testPopupMenuInGroup() {
        GroupMenu group = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createGroupMenu();

        org.eclipse.sirius.viewpoint.description.tool.provider.ToolItemProviderAdapterFactory toolItemProviderAdapterFactory = new org.eclipse.sirius.viewpoint.description.tool.provider.ToolItemProviderAdapterFactory();
        Adapter adapter = toolItemProviderAdapterFactory.createGroupMenuAdapter();

        assertEquals("The capability to create Popup in a group must be activated.", 1, getNbChildren(adapter, group, PopupMenu.class));
    }

    public void testOperationActionInGroup() {
        GroupMenu group = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE.createGroupMenu();

        org.eclipse.sirius.viewpoint.description.tool.provider.ToolItemProviderAdapterFactory toolItemProviderAdapterFactory = new org.eclipse.sirius.viewpoint.description.tool.provider.ToolItemProviderAdapterFactory();
        Adapter adapter = toolItemProviderAdapterFactory.createGroupMenuAdapter();

        assertEquals("The capability to create Operation Action in a group must be activated.", 1, getNbChildren(adapter, group, OperationAction.class));
    }

    public void testGroupOnToolSection() {
        // Create a fake ToolSection
        ToolSection toolSection = ToolFactory.eINSTANCE.createToolSection();

        ToolItemProviderAdapterFactory itemProviderAdapterFactory = new ToolItemProviderAdapterFactory();
        Adapter adapter = itemProviderAdapterFactory.createToolSectionAdapter();

        assertEquals("The capability to create Group in tool section must be activated.", 1, getNbChildren(adapter, toolSection, GroupMenu.class));
    }

    protected int getNbChildren(final Adapter adapter, final DocumentedElement toolEntry, final Class<? extends Object> classOfValue) {
        assertTrue("Wrong type: " + adapter.getClass(), adapter instanceof ItemProviderAdapter);

        ItemProviderAdapter itemProvider = (ItemProviderAdapter) adapter;
        Collection<?> children = itemProvider.getNewChildDescriptors(toolEntry, null, null);
        return getNbChildren(children, classOfValue);
    }

    /**
     * Get the number of child descriptor which have a value instance of <code>classOfValue</code>.
     * 
     * @param newChildDescriptors
     *            List of child descriptors
     * @param classOfValue
     *            The searched type
     */
    protected int getNbChildren(final Collection<?> newChildDescriptors, final Class<? extends Object> classOfValue) {
        Predicate<Object> and = Predicates.and(Predicates.instanceOf(CommandParameter.class), new Predicate<Object>() {
            @Override
            public boolean apply(Object input) {
                return classOfValue.isInstance(((CommandParameter) input).getValue());
            }
        });
        Iterable<?> filtered = Iterables.filter(newChildDescriptors, and);

        return Iterables.size(filtered);
    }
}
