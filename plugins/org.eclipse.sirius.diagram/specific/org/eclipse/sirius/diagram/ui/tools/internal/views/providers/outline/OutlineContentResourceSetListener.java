/*******************************************************************************
 * Copyright (c) 2010, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.views.providers.outline;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.Sets;

import org.eclipse.sirius.AbstractDNode;
import org.eclipse.sirius.DDiagram;
import org.eclipse.sirius.DDiagramElement;
import org.eclipse.sirius.DEdge;
import org.eclipse.sirius.DNode;
import org.eclipse.sirius.DNodeContainer;
import org.eclipse.sirius.DNodeList;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.diagram.tools.internal.editor.DiagramOutlinePageListener;
import org.eclipse.sirius.provider.SiriusItemProviderAdapterFactory;
import org.eclipse.sirius.ui.business.api.provider.DEdgeLabelItemProvider;
import org.eclipse.sirius.ui.business.api.provider.DNodeLabelItemProvider;

/**
 * This class is an EMF Transaction resource listener which listen post commit
 * notifications to update a {@link StructuredViewer} of the outline.
 * 
 * @author Mariot Chauvin (mchauvin)
 */
public class OutlineContentResourceSetListener extends DemultiplexingListener implements DiagramOutlinePageListener {

    /** The structured viewer to update. */
    private StructuredViewer viewer;

    private boolean active;

    private Set<DDiagram> toRefresh;

    private Set<Object> toUpdate;

    /** flag signaling a refresh request made while the outline was disabled. */
    private boolean deferredRefresh;

    /**
     * Set the viewer.
     * 
     * @param viewer
     *            the viewer to update when the model change
     */
    public void setViewer(final Viewer viewer) {
        if (viewer instanceof StructuredViewer) {
            this.viewer = (StructuredViewer) viewer;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.transaction.DemultiplexingListener#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
     */
    @Override
    public void resourceSetChanged(ResourceSetChangeEvent event) {
        if (active) {
            toRefresh = Sets.newHashSet();
            toUpdate = Sets.newHashSet();
            super.resourceSetChanged(event);
            refreshOutline();
            toRefresh = null;
            toUpdate = null;
        } else {
            toRefresh = Sets.newHashSet();
            toUpdate = Sets.newHashSet();
            deferredRefresh = true;
            super.resourceSetChanged(event);
        }
    }

    private void refreshOutline() {
        if (!toRefresh.isEmpty()) {
            refreshViewer();
        } else {
            updateViewer();
        }
    }

    private void refreshViewer() {
        for (final DDiagram diagram : toRefresh) {
            refreshViewer(diagram);
        }
    }

    private void updateViewer() {
        for (final Object object : toUpdate) {
            updateViewer(object);
        }
    }

    private void refreshViewer(final DDiagram diagram) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                if (viewer != null && viewer.getControl() != null && !viewer.getControl().isDisposed()) {
                    viewer.refresh(diagram, true);
                }
            }
        });
    }

    private void updateViewer(final Object object) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                if (viewer != null && viewer.getControl() != null && !viewer.getControl().isDisposed()) {
                    viewer.update(object, null);
                }
            }
        });
    }

    private void addToRefresh(final DDiagram diagram) {
        toRefresh.add(diagram);
    }

    private void addToUpdate(final Object object) {
        toUpdate.add(object);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.transaction.DemultiplexingListener#handleNotification(org.eclipse.emf.transaction.TransactionalEditingDomain,
     *      org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
        final Object notifier = notification.getNotifier();

        if (notifier instanceof DDiagramElement) {

            caseDDiagramElement(notification, (DDiagramElement) notifier);

            if (notifier instanceof AbstractDNode) {
                caseAbstractDNode(notification, (AbstractDNode) notifier);
            }

            if (notifier instanceof DEdge) {
                caseDEdge(notification, (DEdge) notifier);
            }

            if (notifier instanceof DNodeContainer) {
                caseDNodeContainer(notification, (DNodeContainer) notifier);
            } else if (notifier instanceof DNodeList) {
                caseDNodeList(notification, (DNodeList) notifier);
            }

        } else if (notifier instanceof DDiagram) {
            caseDDiagram(notification, (DDiagram) notifier);
        }
    }

    private void caseDDiagramElement(final Notification n, final DDiagramElement diagramElement) {
        final int featureID = n.getFeatureID(DDiagramElement.class);

        switch (featureID) {
        case SiriusPackage.DDIAGRAM_ELEMENT__VISIBLE:
            addToRefresh(SiriusUtil.findDiagram(diagramElement));
            break;
        case SiriusPackage.DDIAGRAM_ELEMENT__NAME:
            addToUpdate(diagramElement);
            break;
        default:
            break;
        }
    }

    private void caseAbstractDNode(final Notification n, final AbstractDNode node) {
        final int featureID = n.getFeatureID(AbstractDNode.class);

        switch (featureID) {
        case SiriusPackage.ABSTRACT_DNODE__OWNED_BORDERED_NODES:
        case SiriusPackage.ABSTRACT_DNODE__GRAPHICAL_FILTERS:
            addToRefresh(SiriusUtil.findDiagram(node));
            break;
        default:
            break;
        }
        if (DNodeLabelItemProvider.hasRelevantLabelItem(node)) {
            addToUpdate(new DNodeLabelItemProvider(getAdapterFactoryForNodeLabelItems(), (DNode) node));
        }
    }

    private void caseDEdge(final Notification n, final DEdge edge) {
        if (DEdgeLabelItemProvider.hasRelevantLabelItem(edge)) {
            addToUpdate(new DEdgeLabelItemProvider(getAdapterFactoryForNodeLabelItems(), edge));
        }
        // if (DEdgeBeginLabelItemProvider.hasRelevantLabelItem(edge)) {
        // addToUpdate(new
        // DEdgeBeginLabelItemProvider(getAdapterFactoryForNodeLabelItems(),
        // (DEdge) edge));
        // }
        // if (DEdgeEndLabelItemProvider.hasRelevantLabelItem(edge)) {
        // addToUpdate(new
        // DEdgeEndLabelItemProvider(getAdapterFactoryForNodeLabelItems(),
        // (DEdge) edge));
        // }
    }

    /**
     * Returns the adapter factory to use to define labelItems.
     * 
     * @return The adapter factory used to define labelItems.
     */
    private AdapterFactory getAdapterFactoryForNodeLabelItems() {
        List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
        factories.add(new SiriusItemProviderAdapterFactory());
        factories.add(new ResourceItemProviderAdapterFactory());
        factories.add(new EcoreItemProviderAdapterFactory());
        factories.add(new ReflectiveItemProviderAdapterFactory());
        return new ComposedAdapterFactory(factories);
    }

    private void caseDNodeContainer(final Notification n, final DNodeContainer nodeContainer) {
        final int featureID = n.getFeatureID(DNodeContainer.class);

        switch (featureID) {
        case SiriusPackage.DNODE_CONTAINER__OWNED_DIAGRAM_ELEMENTS:
            addToRefresh(SiriusUtil.findDiagram(nodeContainer));
            break;
        default:
            break;
        }
    }

    private void caseDNodeList(final Notification n, final DNodeList nodeList) {
        final int featureID = n.getFeatureID(DNodeList.class);

        switch (featureID) {
        case SiriusPackage.DNODE_LIST__OWNED_ELEMENTS:
            addToRefresh(SiriusUtil.findDiagram(nodeList));
            break;
        default:
            break;
        }
    }

    private void caseDDiagram(final Notification n, final DDiagram diagram) {
        final int featureID = n.getFeatureID(DDiagram.class);
        if (featureID == SiriusPackage.DDIAGRAM__OWNED_DIAGRAM_ELEMENTS) {
            switch (n.getEventType()) {
            case Notification.ADD:
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                addToRefresh(diagram);
                break;
            default:
                break;
            }
        } else if (featureID == SiriusPackage.DDIAGRAM__ACTIVATED_FILTERS) {
            switch (n.getEventType()) {
            case Notification.ADD:
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                addToRefresh(diagram);
                break;
            default:
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.ui.tools.api.outline.DiagramOutlinePageListener#activate(int)
     */
    public void activate(int page) {
        switch (page) {
        case DiagramOutlinePageListener.OUTLINE:
            active = true;
            if (deferredRefresh) {
                deferredRefresh = false;
                refreshOutline();
                toRefresh = null;
                toUpdate = null;
            }
            break;
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.ui.tools.api.outline.DiagramOutlinePageListener#deactivate(int)
     */
    public void deactivate(int page) {
        switch (page) {
        case DiagramOutlinePageListener.OUTLINE:
            active = false;
            break;
        default:
            break;
        }
    }
}
