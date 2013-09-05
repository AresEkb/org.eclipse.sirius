/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tree.business.internal.metamodel.spec;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreEList;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import org.eclipse.sirius.DRepresentationElement;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.internal.query.DModelElementInternalQuery;
import org.eclipse.sirius.description.DAnnotation;
import org.eclipse.sirius.tree.DTreeElementSynchronizer;
import org.eclipse.sirius.tree.DTreeElementUpdater;
import org.eclipse.sirius.tree.DTreeItem;
import org.eclipse.sirius.tree.impl.DTreeImpl;

/**
 * Implementation od DTree.
 * 
 * @author nlepine
 * 
 */
public class DTreeSpec extends DTreeImpl {

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.impl.DRepresentationImpl#refresh()
     */
    @Override
    public void refresh() {
        DialectManager.INSTANCE.refresh(this, new NullProgressMonitor());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.impl.DRepresentationImpl#getOwnedRepresentationElements()
     */
    @Override
    public EList<DRepresentationElement> getOwnedRepresentationElements() {
        EList<DTreeItem> result = getOwnedTreeItems();
        final EReference feature = SiriusPackage.eINSTANCE.getDRepresentation_OwnedRepresentationElements();
        return new EcoreEList.UnmodifiableEList<DRepresentationElement>(eInternalContainer(), feature, result.size(), result.toArray());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.impl.DRepresentationImpl#getRepresentationElements()
     */
    @Override
    public EList<DRepresentationElement> getRepresentationElements() {
        List<DRepresentationElement> result = Lists.newArrayList(Iterators.filter(eAllContents(), DRepresentationElement.class));
        final EReference feature = SiriusPackage.eINSTANCE.getDRepresentation_RepresentationElements();
        return new EcoreEList.UnmodifiableEList<DRepresentationElement>(eInternalContainer(), feature, result.size(), result.toArray());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.tree.impl.DTreeImpl#activate(org.eclipse.sirius.tree.DTreeElementSynchronizer)
     */
    @Override
    public void activate(final DTreeElementSynchronizer sync) {
        final Iterator<EObject> it = eAllContents();
        while (it.hasNext()) {
            final EObject eObj = it.next();
            if (eObj instanceof DTreeElementUpdater) {
                ((DTreeElementUpdater) eObj).activate(sync);
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.impl.DRepresentationImpl#getDAnnotation(String)
     */
    @Override
    public DAnnotation getDAnnotation(String source) {
        return new DModelElementInternalQuery(this).getDAnnotation(source);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.tree.impl.DTreeImpl#deactivate()
     */
    @Override
    public void deactivate() {
        final Iterator<EObject> it = eAllContents();
        while (it.hasNext()) {
            final EObject eObj = it.next();
            if (eObj instanceof DTreeElementUpdater) {
                ((DTreeElementUpdater) eObj).deactivate();
            }
        }
    }
}
