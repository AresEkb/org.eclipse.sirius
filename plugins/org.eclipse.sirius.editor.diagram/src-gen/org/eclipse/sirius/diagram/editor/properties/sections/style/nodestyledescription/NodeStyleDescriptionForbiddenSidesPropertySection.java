/*******************************************************************************
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.editor.properties.sections.style.nodestyledescription;

import java.util.Iterator;
import java.util.List;

import org.eclipse.sirius.diagram.description.style.Side;
import org.eclipse.sirius.diagram.description.style.StylePackage;
import org.eclipse.sirius.editor.properties.sections.common.AbstractCheckBoxGroupPropertySection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;


/**
 * A section for the forbiddenSides property of a NodeStyleDescription object.
 */
public class NodeStyleDescriptionForbiddenSidesPropertySection extends AbstractCheckBoxGroupPropertySection {
	/**
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#getDefaultLabelText()
	 */
	protected String getDefaultLabelText() {
	    return "ForbiddenSides"; //$NON-NLS-1$
	}
	
	/**
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		String labelText;
		labelText = super.getLabelText() + ":"; //$NON-NLS-1$
		// Start of user code get label text
	    
	    // End of user code get label text
	    return labelText;
	}
	
	/**
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#getFeature()
	 */
	protected EAttribute getFeature() {
		return StylePackage.eINSTANCE.getNodeStyleDescription_ForbiddenSides();
	}

	/**
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#getFeatureAsText()
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
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#isEqual(List)
	 */
	protected boolean isEqual(List<?> newList) {
		return newList.equals(eObject.eGet(getFeature()));
	}
	
	/**
	 * @see org.eclipse.sirius.diagram.editor.properties.sections.AbstractCheckBoxGroupPropertySection#getEnumerationFeatureValues()
	 */
	protected List<?> getChoiceOfValues() {
		return Side.VALUES;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	    super.createControls(parent, tabbedPropertySheetPage);	  	    
	    combo.setToolTipText("Authorized sides on the parent node or container.");	    
	    
	    CLabel help = getWidgetFactory().createCLabel(composite,"");
	    FormData data = new FormData();
        data.top = new FormAttachment(text, 0, SWT.TOP);
        data.left = new FormAttachment(nameLabel);     
        help.setLayoutData(data);
        help.setImage(getHelpIcon());
        help.setToolTipText("Authorized sides on the parent node or container.");	  
	}
}