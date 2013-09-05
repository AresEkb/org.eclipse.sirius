/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tools.internal.validation.description.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.IValidationContext;

import org.eclipse.sirius.description.EAttributeCustomization;

/**
 * A
 * {@link AbstractEStructuralFeatureCustomizationFeatureNameCommonToAppliedOnConstraint}
 * to check the constraint that
 * {@link EAttributeCustomization#getAttributeName()} is the name of a common
 * {@link EAttribute} to all referenced style description or a description
 * element owned by a style description through
 * {@link EAttributeCustomization#getAppliedOn()}.
 * 
 * @author <a href="mailto:esteban.dugueperoux@obeo.fr">Esteban Dugueperoux</a>
 */
public class EAttributeCustomizationAttributeNameCommonToAppliedOnConstraint extends AbstractEStructuralFeatureCustomizationFeatureNameCommonToAppliedOnConstraint {

    private static final String EATTRIBUTE_NAME_ON = " EAttribute name on ";

    @Override
    public IStatus validate(IValidationContext ctx) {
        IStatus status = null;
        EObject target = ctx.getTarget();
        if (target instanceof EAttributeCustomization) {
            EAttributeCustomization eAttributeCustomization = (EAttributeCustomization) target;
            status = validateEAttributeCustomization(eAttributeCustomization, ctx);
        }
        if (status == null) {
            status = ctx.createSuccessStatus();
        }
        return status;
    }

    private IStatus validateEAttributeCustomization(EAttributeCustomization eAttributeCustomization, IValidationContext ctx) {
        IStatus status = null;
        String attributeName = eAttributeCustomization.getAttributeName();
        Iterator<EObject> appliedOnIterator = eAttributeCustomization.getAppliedOn().iterator();
        if (appliedOnIterator.hasNext()) {
            EObject firstStyleDescriptionElt = appliedOnIterator.next();
            if (!isStyleDescriptionElt(firstStyleDescriptionElt)) {
                status = ctx.createFailureStatus(getPath(firstStyleDescriptionElt) + " doesn't concerns a style description or a style description element");
            } else {
                EStructuralFeature eStructuralFeature = firstStyleDescriptionElt.eClass().getEStructuralFeature(attributeName);
                if (eStructuralFeature instanceof EAttribute) {
                    EClassifier firstEType = eStructuralFeature.getEType();
                    status = validateFollowingStyleDescriptionElts(appliedOnIterator, firstStyleDescriptionElt, firstEType, attributeName, ctx);
                } else if (eStructuralFeature == null) {
                    status = ctx.createFailureStatus(attributeName + EATTRIBUTE_NAME_ON + getPath(firstStyleDescriptionElt) + " doesn't exists");
                } else {
                    status = ctx.createFailureStatus(attributeName + EATTRIBUTE_NAME_ON + getPath(firstStyleDescriptionElt) + " concerns " + eStructuralFeature + " which is not a EAttribute");
                }
            }
        }
        return status;
    }

    private IStatus validateFollowingStyleDescriptionElts(Iterator<EObject> appliedOnIterator, EObject firstStyleDescriptionElt, EClassifier firstEType, String attributeName, IValidationContext ctx) {
        IStatus status = null;
        while (appliedOnIterator.hasNext()) {
            EObject next = appliedOnIterator.next();
            if (!isStyleDescriptionElt(next)) {
                status = ctx.createFailureStatus(getPath(next) + " doesn't concerns a style description or a style description element");
                break;
            } else {
                EStructuralFeature eStructuralFeature = next.eClass().getEStructuralFeature(attributeName);
                if (eStructuralFeature instanceof EAttribute) {
                    if (firstEType != eStructuralFeature.getEType()) {
                        status = ctx.createFailureStatus(getPath(firstStyleDescriptionElt) + " and " + getPath(next) + "have each a EAttribute named " + attributeName + " but with differents types");
                        break;
                    }
                } else if (eStructuralFeature == null) {
                    status = ctx.createFailureStatus(attributeName + EATTRIBUTE_NAME_ON + getPath(next) + " doesn't exists");
                } else {
                    status = ctx.createFailureStatus(attributeName + EATTRIBUTE_NAME_ON + getPath(next) + " concerns " + eStructuralFeature + " which is not a EAttribute");
                    break;
                }
            }
        }
        return status;
    }

}
