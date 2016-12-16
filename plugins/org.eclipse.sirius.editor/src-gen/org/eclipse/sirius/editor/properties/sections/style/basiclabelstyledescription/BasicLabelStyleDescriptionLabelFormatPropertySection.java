/*******************************************************************************
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.editor.properties.sections.style.basiclabelstyledescription;

import java.util.Iterator;
import java.util.List;

import org.eclipse.sirius.viewpoint.description.style.FontFormat;
import org.eclipse.sirius.viewpoint.description.style.StylePackage;
import org.eclipse.sirius.editor.properties.sections.common.AbstractEditorDialogPropertySection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;



/**
 * A section for the labelFormat property of a BasicLabelStyleDescription object.
 */
public class BasicLabelStyleDescriptionLabelFormatPropertySection extends AbstractEditorDialogPropertySection {
	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getDefaultLabelText()
	 */
	protected String getDefaultLabelText() {
	    return "LabelFormat"; //$NON-NLS-1$
	}
	
	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		String labelText;
		labelText = super.getLabelText() + ":"; //$NON-NLS-1$
		// Start of user code get label text

	    // End of user code get label text
	    return labelText;
	}
	
	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getFeature()
	 */
	protected EAttribute getFeature() {
		return StylePackage.eINSTANCE.getBasicLabelStyleDescription_LabelFormat();
	}

	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getFeatureAsText()
	 */
	protected String getFeatureAsText() {
		String string = new String();
		
		if (eObject.eGet(getFeature()) != null) {
			List<?> values = (List<?>)eObject.eGet(getFeature());
			for (Iterator<?> iterator = values.iterator(); iterator.hasNext(); ) {
				string += getAdapterFactoryLabelProvider().getText(iterator.next());
				if (iterator.hasNext())
					string += ", ";
			}
		}
		
		return string;
	}

	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#isEqual(List)
	 */
	protected boolean isEqual(List<?> newList) {
		return newList.equals(eObject.eGet(getFeature()));
	}
	
	/**
	 * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getEnumerationFeatureValues()
	 */
	protected List<?> getChoiceOfValues() {
		return FontFormat.VALUES;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	    super.createControls(parent, tabbedPropertySheetPage);	  	    
	}
}