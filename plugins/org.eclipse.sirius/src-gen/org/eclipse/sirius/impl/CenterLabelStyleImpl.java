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
package org.eclipse.sirius.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.sirius.CenterLabelStyle;
import org.eclipse.sirius.EdgeStyle;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.description.style.BasicLabelStyleDescription;
import org.eclipse.sirius.description.style.CenterLabelStyleDescription;
import org.eclipse.sirius.description.style.EdgeStyleDescription;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Center Label Style</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class CenterLabelStyleImpl extends BasicLabelStyleImpl implements CenterLabelStyle {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007-2013 THALES GLOBAL SERVICES\n All rights reserved.\n\n Contributors:\n     Obeo - Initial API and implementation";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CenterLabelStyleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SiriusPackage.Literals.CENTER_LABEL_STYLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @not-generated
     */
    public BasicLabelStyleDescription getDescription() {
        return ((EdgeStyleDescription) ((EdgeStyle) eContainer()).getDescription()).getCenterLabelStyleDescription();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @not-generated
     */
    public void setDescription(BasicLabelStyleDescription description) {
        ((EdgeStyleDescription) ((EdgeStyle) eContainer()).getDescription()).setCenterLabelStyleDescription((CenterLabelStyleDescription) description);

    }

} // CenterLabelStyleImpl
