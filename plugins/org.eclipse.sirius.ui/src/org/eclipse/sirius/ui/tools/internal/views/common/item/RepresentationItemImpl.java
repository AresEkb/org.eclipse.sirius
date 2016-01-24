/*******************************************************************************
 * Copyright (c) 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.tools.internal.views.common.item;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.sirius.ui.tools.api.views.common.item.ItemWrapper;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import com.google.common.base.Function;

/**
 * {@link DRepresentation} item wrapper class.
 * 
 * @author mporhel
 */
public class RepresentationItemImpl implements ItemWrapper, IAdaptable {

    /**
     * Function to get the representation from a representation item.
     */
    public static final Function<RepresentationItemImpl, DRepresentation> REPRESENTATION_ITEM_TO_REPRESENTATION = new Function<RepresentationItemImpl, DRepresentation>() {
        public DRepresentation apply(RepresentationItemImpl from) {
            return from.getRepresentation();
        }
    };

    private final WeakReference<DRepresentation> rep;

    private final Object parent;

    /**
     * Construct a new resource item wrapper.
     * 
     * @param rep
     *            the represented {@link DRepresentation}.
     * @param parent
     *            Parent tree item
     */
    public RepresentationItemImpl(final DRepresentation rep, final Object parent) {
        this.rep = new WeakReference<DRepresentation>(rep);
        this.parent = parent;
    }

    @Override
    public Object getWrappedObject() {
        return rep.get();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        result = prime * result + ((rep.get() == null) ? 0 : rep.get().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this == obj) {
            result = true;
        } else if (obj == null) {
            result = false;
        } else if (getClass() != obj.getClass()) {
            result = false;
        } else {
            RepresentationItemImpl other = (RepresentationItemImpl) obj;
            if (parent == null) {
                if (other.parent != null) {
                    result = false;
                }
            } else if (!parent.equals(other.parent)) {
                result = false;
            }
            if (rep.get() == null) {
                if (other.rep.get() != null) {
                    result = false;
                }
            } else if (!rep.get().equals(other.rep.get())) {
                result = false;
            }
        }
        return result;
    }
    
    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Collection<?> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public Option<Session> getSession() {
        Session session = null;

        if (rep.get() instanceof DSemanticDecorator) {
            session = SessionManager.INSTANCE.getSession(((DSemanticDecorator) rep.get()).getTarget());
        }

        return Options.newSome(session);
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (rep.get() != null && adapter == EObject.class) {
            return rep.get();
        }

        return null;
    }

    @Override
    public Object getParent() {
        return parent;
    }

    /**
     * Get the wrapped {@link DRepresentation}.
     * 
     * @return the wrapped {@link DRepresentation}.
     */
    public DRepresentation getRepresentation() {
        return rep.get();
    }

}
