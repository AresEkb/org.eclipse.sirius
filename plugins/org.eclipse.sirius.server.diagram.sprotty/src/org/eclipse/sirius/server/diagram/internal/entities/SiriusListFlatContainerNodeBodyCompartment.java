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
package org.eclipse.sirius.server.diagram.internal.entities;

import java.util.ArrayList;

import org.eclipse.sprotty.SCompartment;

/**
 * The body compartment of the {@link SiriusListFlatContainerNode}.
 *
 * @author sbegaudeau
 */
public class SiriusListFlatContainerNodeBodyCompartment extends SCompartment {

	/**
	 * The type of the {@link SiriusListFlatContainerNodeLabelCompartment}.
	 */
	private static final String TYPE = "comp:listflatcontainer_body"; //$NON-NLS-1$

	/**
	 * The constructor.
	 *
	 * @param identifier
	 *            The identifier
	 */
	public SiriusListFlatContainerNodeBodyCompartment(String identifier) {
		this.setId(identifier);
		this.setType(TYPE);
		this.setLayout("vbox"); //$NON-NLS-1$
		this.setChildren(new ArrayList<>());
	}
}
