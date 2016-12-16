/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.properties.editor.properties.sections.properties.pagedescription;

// Start of user code imports

import java.util.Arrays;

import org.eclipse.sirius.properties.PropertiesPackage;
import org.eclipse.sirius.editor.properties.sections.common.AbstractTextWithButtonPropertySection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.PlatformUI;

import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.sirius.editor.tools.internal.presentation.TextWithContentProposalDialog;
import org.eclipse.sirius.editor.tools.api.assist.TypeContentProposalProvider;

// End of user code imports

/**
 * A section for the preconditionExpression property of a PageDescription object.
 */
public class PageDescriptionPreconditionExpressionPropertySection extends AbstractTextWithButtonPropertySection implements ContentProposalClient {
	
	
	/**
	 * @see org.eclipse.sirius.properties.editor.properties.sections.AbstractTextWithButtonPropertySection#getDefaultLabelText()
	 */
	protected String getDefaultLabelText() {
	    return "PreconditionExpression"; //$NON-NLS-1$
	}
	
	/**
	 * @see org.eclipse.sirius.properties.editor.properties.sections.AbstractTextWithButtonPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		String labelText;
		labelText = super.getLabelText() + ":"; //$NON-NLS-1$
		// Start of user code get label text

	    // End of user code get label text
	    return labelText;
	}
	
	/**
	 * @see org.eclipse.sirius.properties.editor.properties.sections.AbstractTextWithButtonPropertySection#getFeature()
	 */
	public EAttribute getFeature() {
		return PropertiesPackage.eINSTANCE.getPageDescription_PreconditionExpression();
	}
	
	/**
	 * @see org.eclipse.sirius.properties.editor.properties.sections.AbstractTextWithButtonPropertySection#getFeatureValue(String)
	 */
	protected Object getFeatureValue(String newText) {
		return newText;
	}
	
	/**
	 * @see org.eclipse.sirius.properties.editor.properties.sections.AbstractTextWithButtonPropertySection#isEqual(String)
	 */
	protected boolean isEqual(String newText) {
		return getFeatureAsText().equals(newText);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	    super.createControls(parent, tabbedPropertySheetPage);
	    /*
	     * We set the color as it's a InterpretedExpression
	     */
	    text.setBackground(SiriusEditor.getColorRegistry().get("yellow"));
	    
	    
         TypeContentProposalProvider.bindPluginsCompletionProcessors(this, text);
	    
	    // Start of user code create controls

	    // End of user code create controls
	    
	}

	@Override
    protected SelectionListener createButtonListener() {
        return new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                TextWithContentProposalDialog dialog = new TextWithContentProposalDialog(composite.getShell(), PageDescriptionPreconditionExpressionPropertySection.this, text.getText());
                dialog.open();
                text.setText(dialog.getResult());
                handleTextModified();
            }
        };
    }
	
	/**
	 * {@inheritDoc}
	 */
	protected String getPropertyDescription() {
		return "";
	}
	
	// Start of user code user operations

	// End of user code user operations
}