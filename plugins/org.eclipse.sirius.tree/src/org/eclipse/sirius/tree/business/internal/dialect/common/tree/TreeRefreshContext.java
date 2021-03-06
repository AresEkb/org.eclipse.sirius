/*******************************************************************************
 * Copyright (c) 2016, 2017 Obeo.
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
package org.eclipse.sirius.tree.business.internal.dialect.common.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionChangeDescription;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.tree.business.internal.dialect.common.viewpoint.GlobalContext;

/**
 * Custom refresh context for tree refresh, which caches costly information
 * about the global result of the refresh that will be needed in all individual
 * {@link CreatedTreeItem}.
 * 
 * @author pcdavid
 */
public class TreeRefreshContext extends GlobalContext {
    private final InternalTransactionalEditingDomain domain;

    private Collection<EObject> createdObjects;

    /**
     * Constructor.
     * 
     * @param accessor
     *            the model accessor.
     * @param interpreter
     *            the interpreter.
     * @param semanticResources
     *            the semantic resources.
     * @param ted
     *            the editing domain.
     */
    public TreeRefreshContext(ModelAccessor accessor, IInterpreter interpreter, Collection<Resource> semanticResources, TransactionalEditingDomain ted) {
        super(accessor, interpreter, semanticResources);
        this.domain = (InternalTransactionalEditingDomain) ted;
    }

    /**
     * Returns the root elements newly created and attached to the model during
     * the transaction in which the refresh was performed.
     * 
     * @return the newly created root objects.
     */
    public Collection<EObject> getCreatedObjects() {
        if (createdObjects == null) {
            InternalTransaction transaction = domain.getActiveTransaction().getRoot();
            TransactionChangeDescription changeDescription = transaction.getChangeDescription();
            if (changeDescription != null) {
                createdObjects = changeDescription.getObjectsToDetach();
            }
        }
        return Optional.ofNullable(createdObjects).orElse(Collections.<EObject> emptySet());
    }
}
