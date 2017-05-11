/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.tools.internal.graphicalcomponents;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.common.ui.tools.api.util.SWTUtil;
import org.eclipse.sirius.ui.business.internal.viewpoint.ViewpointSelectionCallbackWithConfimationAndDependenciesHandling;
import org.eclipse.sirius.ui.tools.api.views.common.item.RepresentationDescriptionItem;
import org.eclipse.sirius.ui.tools.api.views.common.item.ViewpointItem;
import org.eclipse.sirius.ui.tools.internal.viewpoint.ViewpointHelper;
import org.eclipse.sirius.ui.tools.internal.viewpoint.ViewpointsSelectionGraphicalHandler;
import org.eclipse.sirius.ui.tools.internal.views.common.action.DeleteRepresentationAction;
import org.eclipse.sirius.ui.tools.internal.views.common.item.RepresentationDescriptionItemImpl;
import org.eclipse.sirius.ui.tools.internal.views.common.item.RepresentationItemImpl;
import org.eclipse.sirius.ui.tools.internal.views.common.item.ViewpointItemImpl;
import org.eclipse.sirius.ui.tools.internal.views.common.navigator.ManageSessionActionProvider;
import org.eclipse.sirius.ui.tools.internal.views.common.navigator.SiriusCommonContentProvider;
import org.eclipse.sirius.ui.tools.internal.views.common.navigator.sorter.CommonItemSorter;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.DeleteActionHandler;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.RenameActionHandler;
import org.eclipse.sirius.ui.tools.internal.wizards.CreateRepresentationWizard;
import org.eclipse.sirius.ui.tools.internal.wizards.pages.SiriusRepresentationWithInactiveStatusLabelProvider;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.provider.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Maps;

/**
 * This graphical component provides a {@link TreeViewer} showing all representations belonging to the given session
 * under corresponding representation descriptors under corresponding registered viewpoints objects.
 * 
 * This component have different optional functionalities that can be activated or not by construction:
 * 
 * - Add addition and removal representations buttons and key shortcut and viewpoint activation/deactivation mechanism.
 * 
 * - Add a browser showing informations about selected viewpoints and representation descriptions.
 * 
 * - Add custom label and content provider to customize what is shown in the viewer. The content provider must provide
 * only a composition of {@link ViewpointItemImpl}, {@link RepresentationDescriptionItemImpl} and
 * {@link RepresentationDescriptionItem}. Some items type can be not present.
 * 
 * - Filter {@link ViewpointItemImpl} that have no children computed by tree viewer content provider used that is either
 * the default one or a given optional provider.
 * 
 * - Use a {@link FormToolkit} to create graphic components.
 * 
 * - Add a checkbox allowing to group by viewpoint or not the representation description and representation instance.
 * When not grouped by viewpoint, viewpoint items are not shown.
 * 
 * @author <a href="mailto:pierre.guilet@obeo.fr">Pierre Guilet</a>
 *
 */
public class GraphicalRepresentationHandler implements SessionManagerListener {

    /**
     * Session from which representations are handled.
     */
    private Session session;

    /**
     * The Form Toolkit to use to create & configure the controls.
     */
    private FormToolkit toolkit;

    /**
     * Sirius content provider providing expandable viewpoints showing associated representations loaded and available
     * from the session.
     */
    private SiriusCommonContentProvider siriusCommonContentProvider;

    /**
     * The button used to remove representation instances from the session.
     */
    private Button removeRepresentationInstanceButton;

    /**
     * The viewer showing all viewpoints containing representations loaded from the given session.
     */
    private TreeViewer treeViewer;

    /**
     * The {@link MenuManager} for this component.
     */
    private MenuManager menuManager;

    /**
     * The component providing actions available for representations element in the viewer.
     */
    private ManageSessionActionProvider manageSessionActionProvider;

    /**
     * The filtered tree showing representations.
     */
    private FilteredTree representationTree;

    /**
     * Handler allowing to delete a representation.
     */
    private Action deleteActionHandler;

    /**
     * Handler allowing to rename a representation.
     */
    private Action renameActionHandler;

    /**
     * The graphic component contains the browser used to show information about viewpoints.
     */
    private ViewpointsSelectionGraphicalHandler viewpointsSelectionGraphicalHandler;

    /**
     * If true buttons allowing to add/delete representation are shown. If false they are not shown and cannot be use to
     * add/remove representation or activate/deactivate viewpoints.
     */
    private boolean showButtons;

    /**
     * If true any selection on a viewpoint or representation description in the tree viewer must update the browser
     * part with corresponding design description.
     */
    private boolean linkNavigatorAndBrowser;

    /**
     * If true key shortcut and menu action to add/delete representation are activated as well menus and double click
     * listener to activate/deactivate viewpoint. If false, these menu actions, key shortcut and double click listener
     * are not activated.
     */
    private boolean addUpdateControls;

    /**
     * Label provider to use to display style of viewpoints, representations descriptions and instances in the tree
     * viewer.
     */
    private ILabelProvider labelProvider;

    /**
     * Content provider showing viewpoints and/or representation description and or representation instances in the tree
     * viewer. It must provide only a composition of {@link ViewpointItemImpl},
     * {@link RepresentationDescriptionItemImpl} and {@link RepresentationDescriptionItem}. Some items type can be not
     * present.
     */
    private ITreeContentProvider contentProvider;

    /**
     * True if {@link ViewpointItemImpl} that have no children computed by tree viewer content provider used that is
     * either the default one or a given optional provider.
     */
    private boolean filterEmptyViewpoint;

    /**
     * The button enabling selected viewpoints.
     */
    private Button enableViewpointButton;

    /**
     * The button disabling selected viewpoints.
     */
    private Button disableViewpointButton;

    /**
     * True if representation descriptions and representations instance should be grouped by viewpoint. False
     * otherwise(viewpoint items will not be shown).
     */
    private boolean groupByViewpoint;

    /**
     * The checkbox allowing to group by viewpoint the representation descriptions and representations.
     */
    private Button groupByViewpointCheckbox;

    /**
     * True if the checkbox allowing to group by viewpoint or not should be shown to user.
     */
    private boolean showGroupinByCheckbox;

    /**
     * This builder allow to build the graphical componant handling viewpoint and representation with wanted optional
     * functionalities available.
     * 
     * @author <a href="mailto:pierre.guilet@obeo.fr">Pierre Guilet</a>
     *
     */
    public static class GraphicalRepresentationHandlerBuilder {
        /**
         * The graphic component contains the browser used to show information about viewpoints.
         */
        private ViewpointsSelectionGraphicalHandler viewpointsSelectionGraphicalHandler;

        /**
         * Session from which representations are handled.
         */
        private Session session; // mandatory

        /**
         * The Form Toolkit to use to create & configure the controls.
         */
        private FormToolkit toolkit; // mandatory

        /**
         * If true buttons allowing to add/delete representation are shown. If false they are not shown and cannot be
         * use to add/remove representation or activate/deactivate viewpoints.
         */
        private boolean showButtons; // optional

        /**
         * If true any selection on a viewpoint or representation description in the tree viewer must update the browser
         * part with corresponding design description.
         */
        private boolean linkNavigatorAndBrowser; // optional

        /**
         * If true key shortcut and menu action to add/delete representation are activated as well menus and double
         * click listener to activate/deactivate viewpoint. If false, these menu actions, key shortcut and double click
         * listener are not activated.
         */
        private boolean addUpdateControls; // optional

        /**
         * Label provider to use to display style of viewpoints, representations descriptions and instances in the tree
         * viewer.
         */
        private ILabelProvider labelProvider; // optional

        /**
         * Content provider showing viewpoints and/or representation description and or representation instances in the
         * tree viewer. It must provide only a composition of {@link ViewpointItemImpl},
         * {@link RepresentationDescriptionItemImpl} and {@link RepresentationDescriptionItem}. Some items type can be
         * not present.
         */
        private ITreeContentProvider contentProvider; // optional

        /**
         * True if {@link ViewpointItemImpl} that have no children computed by tree viewer content provider used that is
         * either the default one or a given optional provider.
         */
        private boolean filterEmptyViewpoint; // optional

        /**
         * True if the checkbox allowing to group by viewpoint or not should be shown to user.
         */
        private boolean showGroupinByCheckbox;

        /**
         * Construct a GraphicalRepresentationHandler allowing to visualize and select in a tree viewer all registered
         * viewpoints and their representation descriptions and instance.
         * 
         * @param theSession
         *            the session used by the component to handle semantic models lifecycle.
         */
        public GraphicalRepresentationHandlerBuilder(Session theSession) {
            this.session = theSession;
            viewpointsSelectionGraphicalHandler = null;
            /**
             * If true buttons allowing to add/delete representation, to activate/deactivate viewpoint and associated
             * key shortcut and menu actions are shown. If representations cannot be modified and viewpoints status
             * cannot be changed.
             */
            showButtons = false;
            linkNavigatorAndBrowser = false;
            addUpdateControls = false;
            filterEmptyViewpoint = false;
            showGroupinByCheckbox = false;
            labelProvider = null;
            contentProvider = null;
        }

        /**
         * Returns the builder with the functionality "Use a {@link FormToolkit} to create graphic components."
         * activated.
         * 
         * @param theToolkit
         *            the toolkit to use to create & configure the controls.
         * @return the builder with the functionality "Use a {@link FormToolkit} to create graphic components."
         *         activated.
         */
        public GraphicalRepresentationHandlerBuilder useToolkitToCreateGraphicComponents(FormToolkit theToolkit) {
            this.toolkit = theToolkit;
            return this;
        }

        /**
         * Returns the builder with the functionality "Add addition and removal representations buttons and key shortcut
         * and viewpoint activation/deactivation mechanism." activated.
         * 
         * @return the builder with the functionality "Add addition and removal representations buttons and key shortcut
         *         and viewpoint activation/deactivation mechanism." activated.
         */
        public GraphicalRepresentationHandlerBuilder activateRepresentationAndViewpointControls() {
            addUpdateControls = true;
            showButtons = true;
            return this;
        }

        /**
         * Returns the builder with the functionality "Add addition and removal representations buttons and key shortcut
         * and viewpoint activation/deactivation mechanism." activated.
         * 
         * @return the builder with the functionality "Add addition and removal representations buttons and key shortcut
         *         and viewpoint activation/deactivation mechanism." activated.
         */
        public GraphicalRepresentationHandlerBuilder activateGroupingByCheckbox() {
            showGroupinByCheckbox = true;
            return this;
        }

        /**
         * Returns the builder with the functionality "Add a browser showing informations about selected viewpoints and
         * representation descriptions." activated.
         * 
         * @return the builder with the functionality "Add a browser showing informations about selected viewpoints and
         *         representation descriptions." activated.
         */
        public GraphicalRepresentationHandlerBuilder activateBrowserWithViewpointAndRepresentationDescriptionInformation() {
            linkNavigatorAndBrowser = true;
            viewpointsSelectionGraphicalHandler = new ViewpointsSelectionGraphicalHandler();
            return this;
        }

        /**
         * Returns the builder with the functionality "Add custom label and content provider to customize what is shown
         * in the viewer. The content provider must provide only a composition of {@link ViewpointItemImpl},
         * {@link RepresentationDescriptionItemImpl} and {@link RepresentationDescriptionItem}. Some items type can be
         * not present." activated
         * 
         * @param theContentProvider
         *            Content provider showing viewpoints and/or representation description and or representation
         *            instances in the tree viewer. It must provide only a composition of {@link ViewpointItemImpl},
         *            {@link RepresentationDescriptionItemImpl} and {@link RepresentationDescriptionItem}. Some items
         *            type can be not present.
         * @param theLabelProvider
         *            Used to display style of viewpoints, representations descriptions and instances in the tree
         *            viewer.
         * @return the builder with the functionality "Add custom label and content provider to customize what is shown
         *         in the viewer. The content provider must provide only a composition of {@link ViewpointItemImpl},
         *         {@link RepresentationDescriptionItemImpl} and {@link RepresentationDescriptionItem}. Some items type
         *         can be not present." activated
         */
        public GraphicalRepresentationHandlerBuilder customizeContentAndLabel(ITreeContentProvider theContentProvider, ILabelProvider theLabelProvider) {
            labelProvider = theLabelProvider;
            contentProvider = theContentProvider;
            return this;
        }

        /**
         * Returns the builder with the functionality "Filter {@link ViewpointItemImpl} that have no children computed
         * by tree viewer content provider used that is either the default one or a given optional provider." activated.
         * 
         * @return the builder with the functionality "Filter {@link ViewpointItemImpl} that have no children computed
         *         by tree viewer content provider used that is either the default one or a given optional provider."
         *         activated.
         */
        public GraphicalRepresentationHandlerBuilder filterEmptyViewpoints() {
            filterEmptyViewpoint = true;
            return this;
        }

        /**
         * Builds a new instance of {@link GraphicalRepresentationHandler}.
         * 
         * @return a new instance of {@link GraphicalRepresentationHandler}.
         */
        public GraphicalRepresentationHandler build() {
            return new GraphicalRepresentationHandler(this);
        }

    }

    /**
     * Creates the GraphicalRepresentationHandler from the given builder.
     * 
     * @param builder
     *            the builder from which the new GraphicalRepresentationHandler is created.
     */
    public GraphicalRepresentationHandler(GraphicalRepresentationHandlerBuilder builder) {
        this.session = builder.session;
        this.toolkit = builder.toolkit;
        this.viewpointsSelectionGraphicalHandler = builder.viewpointsSelectionGraphicalHandler;
        this.showButtons = builder.showButtons;
        this.linkNavigatorAndBrowser = builder.linkNavigatorAndBrowser;
        this.addUpdateControls = builder.addUpdateControls;
        this.filterEmptyViewpoint = builder.filterEmptyViewpoint;
        this.contentProvider = builder.contentProvider;
        this.labelProvider = builder.labelProvider;
        this.showGroupinByCheckbox = builder.showGroupinByCheckbox;
    }

    /**
     * Return the {@link TreeViewer} showing all representations usable under their viewpoint.
     * 
     * @return the {@link TreeViewer} showing all representations usable under their viewpoint.
     */
    public TreeViewer getTreeViewer() {
        return treeViewer;
    }

    /**
     * Launch a representation deletion or renaming if the right key is used and the selected element is a
     * representation.
     * 
     * @param event
     */
    private void handleKeyReleased(KeyEvent event) {
        if (event.stateMask != 0)
            return;

        int key = event.keyCode;
        if (key == SWT.DEL) {
            if (deleteActionHandler.isEnabled()) {
                deleteActionHandler.run();
            }
        } else if (key == SWT.F2) {
            if (renameActionHandler.isEnabled()) {
                renameActionHandler.run();
            }
        }

    }

    /**
     * Create the graphic composites and the {@link TreeViewer} and initialize it with representation from the session.
     * 
     * @param parentComposite
     *            the composite to be attached to.
     */
    public void createControl(Composite parentComposite) {
        viewpointsSelectionGraphicalHandler = new ViewpointsSelectionGraphicalHandler();
        Composite rootComposite = new Composite(parentComposite, SWT.NONE);
        rootComposite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());
        GridData rootLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
        rootComposite.setLayoutData(rootLayoutData);

        Composite subComposite1 = new Composite(rootComposite, SWT.NONE);
        GridLayout subComposite1Layout = null;
        if (showButtons) {
            subComposite1Layout = GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).create();
        } else {
            subComposite1Layout = GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true).create();
        }

        subComposite1.setLayout(subComposite1Layout);
        GridData subComposite1LayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
        subComposite1.setLayoutData(subComposite1LayoutData);
        treeViewer = createRepresentationExplorerNavigator(subComposite1);

        GridData layoutData = (GridData) treeViewer.getTree().getLayoutData();
        // setting height hint avoids the composite to grow outside visible
        // port when too much item are present.
        layoutData.heightHint = 50;

        viewpointsSelectionGraphicalHandler.createBrowser(subComposite1);
        viewpointsSelectionGraphicalHandler.setBrowserMinWidth(200);
        SessionManager.INSTANCE.addSessionsListener(this);

        Composite groupByComposite = new Composite(rootComposite, SWT.NONE);
        groupByComposite.setLayout(GridLayoutFactory.swtDefaults().create());
        if (showGroupinByCheckbox) {
            createGroupByCheckbox(groupByComposite);
        } else {
            groupByViewpoint = true;
        }

    }

    private void createGroupByCheckbox(Composite rootComposite) {
        groupByViewpointCheckbox = new Button(rootComposite, SWT.CHECK);
        groupByViewpointCheckbox.setText(Messages.GraphicalRepresentationHandler_checkBoxGroupByViewpoint_label); // $NON-NLS-1$
        groupByViewpointCheckbox.setSelection(true);
        groupByViewpoint = true;
        groupByViewpointCheckbox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                Button button = (Button) event.widget;
                if (button.getSelection()) {
                    groupByViewpoint = true;
                } else {
                    groupByViewpoint = false;
                }
                initInput();
            };
        });
    }

    /**
     * Returns all viewpoint items corresponding to all available viewpoints from the runtime.
     * 
     * @return all viewpoint items corresponding to all available viewpoints from the runtime.
     */
    private List<Object> getViewpointItems() {
        List<Object> viewpointItemList = new ArrayList<>();
        Collection<Viewpoint> availableViewpoints = ViewpointHelper.getAvailableViewpoints(session);
        for (Viewpoint viewpoint : availableViewpoints) {
            viewpointItemList.add(new ViewpointItemImpl(session, viewpoint, this));
        }
        return viewpointItemList;
    }

    /**
     * Returns all viewpoint items corresponding to all available viewpoints from the runtime.
     * 
     * @return all viewpoint items corresponding to all available viewpoints from the runtime.
     */
    private List<Object> getRepresentationDescriptionsItems() {
        List<Object> representationItemList = new ArrayList<>();
        Collection<Viewpoint> availableViewpoints = ViewpointHelper.getAvailableViewpoints(session);
        for (Viewpoint viewpoint : availableViewpoints) {
            EList<RepresentationDescription> ownedRepresentations = viewpoint.getOwnedRepresentations();
            for (RepresentationDescription representationDescription : ownedRepresentations) {
                representationItemList.add(new RepresentationDescriptionItemImpl(session, representationDescription, this, viewpoint));
            }
        }
        return representationItemList;
    }

    /**
     * Update the representations viewer with the representation currently available in the session and expand items to
     * level 2 and set selection to the first item.
     */
    public void initInput() {
        if (groupByViewpoint) {
            treeViewer.setInput(getViewpointItems());
        } else {
            treeViewer.setInput(getRepresentationDescriptionsItems());
        }

        treeViewer.expandToLevel(2);
        if (treeViewer.getTree().getItemCount() > 0) {
            treeViewer.setSelection(new StructuredSelection(treeViewer.getTree().getItem(0).getData()));
        }
        treeViewer.refresh(true);
    }

    /**
     * Create Representation explorer navigator.
     * 
     * @param parent
     *            the parent composite.
     * @return the {@link TreeViewer} allowing the navigation.
     */
    private TreeViewer createRepresentationExplorerNavigator(Composite parent) {
        Composite subComposite = null;
        if (toolkit != null) {
            subComposite = toolkit.createComposite(parent, SWT.NONE);
        } else {
            subComposite = new Composite(parent, SWT.NONE);
        }
        subComposite.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());
        GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
        layoutData.widthHint = 350;
        subComposite.setLayoutData(layoutData);
        org.eclipse.ui.dialogs.PatternFilter filter = new org.eclipse.ui.dialogs.PatternFilter();
        filter.setIncludeLeadingWildcard(true);
        representationTree = SWTUtil.createFilteredTree(subComposite, SWT.BORDER | SWT.MULTI, filter);
        treeViewer = representationTree.getViewer();
        final GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.minimumHeight = 200;
        treeViewer.getControl().setLayoutData(gridData);

        treeViewer.getTree().setHeaderVisible(false);
        treeViewer.getTree().setLinesVisible(false);

        // treeViewer.setComparer(new IElementComparerImplementation());

        ColumnViewerToolTipSupport.enableFor(treeViewer);

        final ITreeContentProvider contentProviderToUse;
        if (contentProvider != null) {
            contentProviderToUse = contentProvider;
        } else {
            siriusCommonContentProvider = new SiriusCommonContentProvider();
            contentProviderToUse = siriusCommonContentProvider;
        }
        treeViewer.setContentProvider(contentProviderToUse);
        if (labelProvider != null) {
            treeViewer.setLabelProvider(labelProvider);
        } else {
            treeViewer.setLabelProvider(new SiriusRepresentationWithInactiveStatusLabelProvider());
        }
        treeViewer.setSorter(new CommonItemSorter());

        if (addUpdateControls) {
            bindKeyToActions();
            initializeMenusAndActions();

            treeViewer.addDoubleClickListener(new ViewpointActivationAndRepresentationCreationDoubleClickListener());
        }

        if (showButtons) {
            createRepresentationExplorerButton(subComposite, treeViewer);
            treeViewer.addSelectionChangedListener(new UpdateRepresentationButtonsAtSelectionChangeListener());

        }

        if (linkNavigatorAndBrowser) {
            treeViewer.addSelectionChangedListener(new UpdateBrowserAtSelectionChangeListener());
        }

        if (filterEmptyViewpoint) {
            treeViewer.addFilter(new ViewerFilter() {

                @Override
                public boolean select(Viewer viewer, Object parentElement, Object element) {
                    // we don't show the viewpoint without representation description.
                    if (element instanceof ViewpointItem && contentProviderToUse.getChildren(element).length == 0) {
                        return false;
                    }
                    return true;
                }
            });
        }
        return treeViewer;
    }

    /**
     * Bind DEL and F2 keys to delete and rename actions.
     */
    private void bindKeyToActions() {
        deleteActionHandler = new DeleteActionHandler(treeViewer);
        renameActionHandler = new RenameActionHandler(treeViewer);
        treeViewer.getControl().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent event) {
                handleKeyReleased(event);
            }
        });
    }

    /**
     * Initializes all menus and actions for representation blocks.
     */
    private void initializeMenusAndActions() {
        menuManager = new MenuManager();
        menuManager.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manageSessionActionProvider.setContext(new ActionContext(treeViewer.getSelection()));
                manageSessionActionProvider.fillContextMenu(menuManager);
            }

        });
        Menu menu = menuManager.createContextMenu(treeViewer.getControl());
        menuManager.setRemoveAllWhenShown(true);
        manageSessionActionProvider = new ManageSessionActionProvider();
        manageSessionActionProvider.initFromViewer(treeViewer);
        treeViewer.getControl().setMenu(menu);
    }

    /**
     * Activate or deactivate the viewpoint of the given {@link ViewpointItemImpl} regarding the activation parameter.
     * 
     * @param viewpointsToHandle
     *            the {@link ViewpointItemImpl} from which the viewpoint should be activated or deactivated.
     * @param selectedViewpoints
     *            the viewpoint that are currently selected in the session.
     * @param activateViewpoint
     *            true if the viewpoint should be activated. False otherwise.
     */
    private void handleViewpointActivation(Set<ViewpointItemImpl> viewpointsToHandle, Collection<Viewpoint> selectedViewpoints, boolean activateViewpoint) {

        treeViewer.getTree().setRedraw(false);
        final SortedMap<Viewpoint, Boolean> originalViewpointsMap = Maps.newTreeMap(new ViewpointRegistry.ViewpointComparator());
        Collection<Viewpoint> availableViewpoints = ViewpointHelper.getAvailableViewpoints(session);
        for (final Viewpoint viewpoint : availableViewpoints) {
            boolean selected = false;

            for (Viewpoint selectedViewpoint : selectedViewpoints) {
                if (EqualityHelper.areEquals(selectedViewpoint, viewpoint)) {
                    selected = true;
                    break;
                }
            }
            originalViewpointsMap.put(viewpoint, Boolean.valueOf(selected));
        }
        SortedMap<Viewpoint, Boolean> newViewpointToSelectionStateMap = Maps.newTreeMap(new ViewpointRegistry.ViewpointComparator());
        newViewpointToSelectionStateMap.putAll(originalViewpointsMap);

        for (ViewpointItemImpl viewpointItem : viewpointsToHandle) {
            newViewpointToSelectionStateMap.put(viewpointItem.getViewpoint(), activateViewpoint);
        }

        Display.getCurrent().syncExec(() -> {
            ViewpointHelper.applyNewViewpointSelection(originalViewpointsMap, newViewpointToSelectionStateMap, session, true, new ViewpointSelectionCallbackWithConfimationAndDependenciesHandling());
        });

        treeViewer.getTree().setRedraw(true);
        treeViewer.refresh();
        treeViewer.setSelection(new StructuredSelection(viewpointsToHandle.stream().collect(Collectors.toList())));
    }

    /**
     * Create control buttons allowing to add/remove representations.
     * 
     * @param parent
     *            the parent composite.
     */
    private void createRepresentationExplorerButton(Composite parent, final TreeViewer theTreeViewer) {
        Composite buttonsComposite = createButtonsComposite(parent);
        addButton(buttonsComposite, Messages.GraphicalRepresentationHandler_button_newRepresentation, () -> {
            CreateRepresentationWizard wizard = new CreateRepresentationWizard(session);
            wizard.init();
            final WizardDialog dialog = new WizardDialog(parent.getShell(), wizard);
            dialog.setMinimumPageSize(CreateRepresentationWizard.MIN_PAGE_WIDTH, CreateRepresentationWizard.MIN_PAGE_HEIGHT);
            dialog.create();
            dialog.getShell().setText(Messages.GraphicalRepresentationHandler_CreateRepresentationWizard_title);
            dialog.open();
        });
        removeRepresentationInstanceButton = addButton(buttonsComposite, Messages.GraphicalRepresentationHandler_button_removeRepresentation, () -> {
            if (theTreeViewer != null) {
                final IStructuredSelection selection = (IStructuredSelection) theTreeViewer.getSelection();
                Collection<?> selectedObjects = selection.toList();
                if (!selectedObjects.isEmpty()) {
                    Set<DRepresentationDescriptor> representationDescriptors = selectedObjects.stream().filter(object -> object instanceof RepresentationItemImpl)
                            .map(object -> ((RepresentationItemImpl) object).getDRepresentationDescriptor()).collect(Collectors.toSet());
                    DeleteRepresentationAction deleteRepresentationAction = new DeleteRepresentationAction(representationDescriptors);
                    deleteRepresentationAction.run();
                }
                theTreeViewer.refresh();
            }
        });
        enableViewpointButton = addButton(buttonsComposite, Messages.GraphicalRepresentationHandler_button_activateViewpoint, () -> {
            if (theTreeViewer != null) {
                final IStructuredSelection selection = (IStructuredSelection) theTreeViewer.getSelection();
                Collection<?> selectedObjects = selection.toList();
                if (!selectedObjects.isEmpty()) {
                    boolean canEnableOrDisableViewpoints = selectedObjects.stream().allMatch(object -> object instanceof ViewpointItemImpl);
                    if (canEnableOrDisableViewpoints) {
                        Set<ViewpointItemImpl> viewpointsToActivate = new HashSet<>();
                        for (Object obj : selectedObjects) {
                            if (obj instanceof ViewpointItemImpl) {
                                viewpointsToActivate.add((ViewpointItemImpl) obj);
                            }
                        }
                        Collection<Viewpoint> selectedViewpoints = session.getSelectedViewpoints(false);
                        handleViewpointActivation(viewpointsToActivate, selectedViewpoints, true);
                    } else {
                        MessageDialog.openError(Display.getCurrent().getActiveShell(),
                                MessageFormat.format(Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_title,
                                        Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_activationLabel),
                                Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_message);
                    }
                }
            }
        });
        disableViewpointButton = addButton(buttonsComposite, Messages.GraphicalRepresentationHandler_button_deactivateViewpoint, () -> {
            if (theTreeViewer != null) {
                final IStructuredSelection selection = (IStructuredSelection) theTreeViewer.getSelection();
                Collection<?> selectedObjects = selection.toList();
                if (!selectedObjects.isEmpty()) {
                    boolean canEnableOrDisableViewpoints = selectedObjects.stream().allMatch(object -> object instanceof ViewpointItemImpl);
                    if (canEnableOrDisableViewpoints) {

                        Set<ViewpointItemImpl> viewpointsToActivate = new HashSet<>();
                        for (Object obj : selectedObjects) {
                            if (obj instanceof ViewpointItemImpl) {
                                viewpointsToActivate.add((ViewpointItemImpl) obj);
                            }
                        }
                        Collection<Viewpoint> selectedViewpoints = session.getSelectedViewpoints(false);
                        handleViewpointActivation(viewpointsToActivate, selectedViewpoints, false);
                    } else {
                        MessageDialog.openError(Display.getCurrent().getActiveShell(),
                                MessageFormat.format(Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_title,
                                        Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_deactivationLabel),
                                Messages.GraphicalRepresentationHandler_button_activateDeactivateViewpoint_incorrectSelection_message);
                    }
                }
            }
        });
        removeRepresentationInstanceButton.setEnabled(false);
        deleteActionHandler.setEnabled(false);
        renameActionHandler.setEnabled(false);
    }

    /**
     * Initializes the composite that will contains the buttons to handle viewpoints and representations.
     * 
     * @param parent
     *            parent composite.
     * @return the composite that will contains the buttons to handle viewpoints and representations.
     */
    private Composite createButtonsComposite(Composite parent) {
        Composite subComposite = null;
        if (toolkit != null) {
            subComposite = toolkit.createComposite(parent, SWT.NONE);
        } else {
            subComposite = new Composite(parent, SWT.NONE);
        }
        subComposite.setLayout(GridLayoutFactory.fillDefaults().margins(0, 0).create());
        GridData layoutData = new GridData(SWT.LEFT, SWT.TOP, false, false);
        layoutData.widthHint = 70;
        subComposite.setLayoutData(layoutData);
        Composite buttonsComposite = null;
        if (toolkit != null) {
            buttonsComposite = toolkit.createComposite(subComposite, SWT.NONE);
        } else {
            buttonsComposite = new Composite(subComposite, SWT.NONE);
        }
        FillLayout buttonsLayout = new FillLayout(SWT.BEGINNING);
        buttonsLayout.spacing = 5;
        buttonsComposite.setLayout(buttonsLayout);
        return buttonsComposite;
    }

    /**
     * Helper method to add an action button to the view.
     * 
     * @param parent
     *            parent Composite where button is displayed
     * @param name
     *            name of the button
     * @param body
     *            action to launch when button is pushed
     * @return the newly created button.
     */
    protected Button addButton(Composite parent, final String name, final Runnable body) {
        Button button = null;
        if (toolkit != null) {
            button = toolkit.createButton(parent, name, SWT.PUSH);
        } else {
            button = new Button(parent, SWT.PUSH);
            button.setText(name);
        }
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (body != null) {
                    body.run();
                }
            }
        });
        return button;
    }

    /**
     * Dispose all listeners.
     */
    public void dispose() {
        SessionManager.INSTANCE.removeSessionsListener(this);
        session = null;
        treeViewer = null;
        manageSessionActionProvider = null;
        siriusCommonContentProvider = null;
        menuManager = null;
        toolkit = null;
    }

    @Override
    public void notifyAddSession(Session newSession) {
    }

    @Override
    public void notifyRemoveSession(Session removedSession) {
        if (siriusCommonContentProvider != null) {
            siriusCommonContentProvider.removeRefreshViewerTriggers(removedSession);
        }
    }

    @Override
    public void viewpointSelected(Viewpoint selectedSirius) {
    }

    @Override
    public void viewpointDeselected(Viewpoint deselectedSirius) {
    }

    @Override
    public void notify(Session updated, int notification) {
        if (session.equals(updated)) {
            switch (notification) {
            case SessionListener.DIRTY:
                PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
                    if (!representationTree.isDisposed()) {
                        treeViewer.refresh();
                    }
                });
                break;

            case SessionListener.OPENED:
                PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
                    if (!representationTree.isDisposed()) {
                        treeViewer.refresh();
                        if (siriusCommonContentProvider != null) {
                            siriusCommonContentProvider.addRefreshViewerTrigger(updated);
                        }
                    }
                });

                break;

            default:
                // do nothing as we will be notified in other way
                break;
            }
        }
    }

    /**
     * Double click listener activating/deactivating viewpoints from viewpoints item and launching representation
     * creation wizard from representation descriptor.
     * 
     * @author <a href="mailto:pierre.guilet@obeo.fr">Pierre Guilet</a>
     *
     */
    private final class ViewpointActivationAndRepresentationCreationDoubleClickListener implements IDoubleClickListener {
        @Override
        public void doubleClick(DoubleClickEvent event) {
            if (event.getSelection() instanceof StructuredSelection) {
                StructuredSelection selection = (StructuredSelection) event.getSelection();

                if (selection.getFirstElement() instanceof ViewpointItemImpl) {
                    ViewpointItemImpl viewpointItem = (ViewpointItemImpl) selection.getFirstElement();
                    boolean activateViewpoint = !ViewpointHelper.isViewpointEnabledInSession(session, viewpointItem.getViewpoint());
                    Collection<Viewpoint> selectedViewpoints = session.getSelectedViewpoints(false);
                    if (activateViewpoint) {

                        Set<ViewpointItemImpl> viewpointsToActivate = new HashSet<>();
                        viewpointsToActivate.add(viewpointItem);
                        handleViewpointActivation(viewpointsToActivate, selectedViewpoints, activateViewpoint);
                    } else {
                        Set<ViewpointItemImpl> viewpointsToActivate = new HashSet<>();
                        viewpointsToActivate.add(viewpointItem);
                        handleViewpointActivation(viewpointsToActivate, selectedViewpoints, activateViewpoint);
                    }

                } else if (selection.getFirstElement() instanceof RepresentationDescriptionItemImpl) {
                    RepresentationDescriptionItemImpl representationDescriptionItem = (RepresentationDescriptionItemImpl) selection.getFirstElement();

                    treeViewer.getTree().setRedraw(false);
                    CreateRepresentationWizard wizard = new CreateRepresentationWizard(session, representationDescriptionItem);
                    wizard.init();
                    final WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
                    dialog.setMinimumPageSize(CreateRepresentationWizard.MIN_PAGE_WIDTH, CreateRepresentationWizard.MIN_PAGE_HEIGHT);
                    dialog.create();
                    dialog.getShell().setText(Messages.GraphicalRepresentationHandler_CreateRepresentationWizard_title);
                    dialog.open();

                    treeViewer.getTree().setRedraw(true);
                    treeViewer.refresh();
                    treeViewer.setSelection(new StructuredSelection(representationDescriptionItem));
                }
            }

        }
    }

    /**
     * This listener takes care of enabling/disabling buttons handling representations. It also update the browser
     * description regarding the viewpoint of the selected item.
     * 
     * @author <a href="mailto:pierre.guilet@obeo.fr">Pierre Guilet</a>
     *
     */
    private final class UpdateRepresentationButtonsAtSelectionChangeListener implements ISelectionChangedListener {
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            if (event.getSelection().isEmpty()) {
                removeRepresentationInstanceButton.setEnabled(false);
                deleteActionHandler.setEnabled(false);
                renameActionHandler.setEnabled(false);
            } else if (event.getSelection() instanceof TreeSelection) {
                TreeSelection selection = (TreeSelection) event.getSelection();

                // update buttons
                Iterator<?> selectionIte = selection.iterator();
                boolean allRepresentationItem = true;
                while (selectionIte.hasNext() && allRepresentationItem) {
                    Object object = selectionIte.next();
                    if (!(object instanceof RepresentationItemImpl)) {
                        allRepresentationItem = false;
                    }
                }
                if (allRepresentationItem) {
                    removeRepresentationInstanceButton.setEnabled(true);
                    deleteActionHandler.setEnabled(true);
                    renameActionHandler.setEnabled(true);
                } else {
                    removeRepresentationInstanceButton.setEnabled(false);
                    deleteActionHandler.setEnabled(false);
                    renameActionHandler.setEnabled(false);
                }
                if (!selection.isEmpty()) {
                    enableViewpointButton.setEnabled(true);
                    disableViewpointButton.setEnabled(true);
                } else {
                    disableViewpointButton.setEnabled(false);
                    enableViewpointButton.setEnabled(false);
                }
            }
        }
    }

    /**
     * This listener update browser description each time a new viewpoint or representation description or instance is
     * selected.
     * 
     * @author <a href="mailto:pierre.guilet@obeo.fr">Pierre Guilet</a>
     *
     */
    private final class UpdateBrowserAtSelectionChangeListener implements ISelectionChangedListener {
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            if (event.getSelection() instanceof TreeSelection) {
                TreeSelection selection = (TreeSelection) event.getSelection();

                // update browser
                Object firstElement = ((IStructuredSelection) selection).getFirstElement();
                if (firstElement instanceof ViewpointItemImpl) {
                    viewpointsSelectionGraphicalHandler.setBrowserInput(((ViewpointItemImpl) firstElement).getViewpoint());
                } else if (firstElement instanceof RepresentationDescriptionItemImpl) {
                    RepresentationDescriptionItemImpl representationDescriptionItemImpl = (RepresentationDescriptionItemImpl) firstElement;
                    viewpointsSelectionGraphicalHandler.setBrowserInput(representationDescriptionItemImpl.getViewpoint());
                } else if (firstElement instanceof RepresentationItemImpl) {
                    RepresentationItemImpl representationItem = (RepresentationItemImpl) firstElement;
                    RepresentationDescriptionItemImpl representationDescriptionItemImpl = (RepresentationDescriptionItemImpl) representationItem.getParent();
                    viewpointsSelectionGraphicalHandler.setBrowserInput(representationDescriptionItemImpl.getViewpoint());
                }
            }
        }
    }

}
