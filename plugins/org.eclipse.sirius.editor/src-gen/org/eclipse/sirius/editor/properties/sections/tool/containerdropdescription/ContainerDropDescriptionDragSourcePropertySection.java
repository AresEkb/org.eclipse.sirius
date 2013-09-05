/*******************************************************************************
 * Copyright (c) 2007-2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.editor.properties.sections.tool.containerdropdescription;

// Start of user code imports

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import org.eclipse.sirius.description.tool.DragSource;
import org.eclipse.sirius.description.tool.ToolPackage;
import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;
import org.eclipse.sirius.editor.properties.sections.common.AbstractRadioButtonPropertySection;

// End of user code imports

/**
 * A section for the dragSource property of a ContainerDropDescription object.
 */
public class ContainerDropDescriptionDragSourcePropertySection extends AbstractRadioButtonPropertySection {
    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#getDefaultLabelText()
     */
    protected String getDefaultLabelText() {
        return "DragSource"; //$NON-NLS-1$
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#getLabelText()
     */
    protected String getLabelText() {
        String labelText;
        labelText = super.getLabelText() + "*:"; //$NON-NLS-1$
        // Start of user code get label text

        // End of user code get label text
        return labelText;
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#getFeature()
     */
    protected EAttribute getFeature() {
        return ToolPackage.eINSTANCE.getContainerDropDescription_DragSource();
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#getFeatureValue(int)
     */
    protected Object getFeatureValue(int index) {
        return getChoiceOfValues().get(index);
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#isEqual(int)
     */
    protected boolean isEqual(int index) {
        return getChoiceOfValues().get(index).equals(eObject.eGet(getFeature()));
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractRadioButtonPropertySection#getEnumerationFeatureValues()
     */
    protected List<?> getChoiceOfValues() {
        return DragSource.VALUES;
    }

    /**
     * {@inheritDoc}
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        nameLabel.setToolTipText("Tell whether the source of this Drag and Drop is an item of a Diagram, of the Model Explorer View or both.");

        CLabel help = getWidgetFactory().createCLabel(composite, "");
        FormData data = new FormData();
        data.top = new FormAttachment(nameLabel, 0, SWT.TOP);
        data.left = new FormAttachment(nameLabel);
        help.setLayoutData(data);
        help.setFont(SiriusEditor.getFontRegistry().get("description"));
        help.setImage(getHelpIcon());
        help.setToolTipText("Tell whether the source of this Drag and Drop is an item of a Diagram, of the Model Explorer View or both.");
        nameLabel.setFont(SiriusEditor.getFontRegistry().get("required"));

    }
}
