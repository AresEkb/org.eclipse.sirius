/*******************************************************************************
 * Copyright (c) 2007, 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.properties;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.views.properties.IPropertySource;

import org.eclipse.sirius.DSemanticDecorator;
import org.eclipse.sirius.DStylizable;
import org.eclipse.sirius.EdgeRouting;
import org.eclipse.sirius.EdgeStyle;
import org.eclipse.sirius.FontFormat;
import org.eclipse.sirius.LabelStyle;
import org.eclipse.sirius.RGBValues;
import org.eclipse.sirius.Style;
import org.eclipse.sirius.SiriusPackage;
import org.eclipse.sirius.SiriusPlugin;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;

/**
 * Properties section that shows the properties of a style of a DiagramElement.
 * 
 * @author ymortier
 */
public class StylePropertySection extends SemanticPropertySection {

    private Map<DStylizable, View> map = new HashMap<DStylizable, View>();

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.ui.tools.internal.properties.SemanticPropertySection#getPropertySource(java.lang.Object)
     */
    @Override
    public IPropertySource getPropertySource(final Object object) {

        IPropertySource propSrc = null;

        if (object instanceof IPropertySource) {
            propSrc = (IPropertySource) object;
        }
        //
        // We should display the ColorMapping if the style is an EdgeStyle and
        // if the stroke color is not null.
        else if (object instanceof EObject && !getPermissionAuthority((EObject) object).canEditInstance((EObject) object)) {
            // do nothing -> return null
        } else if (object instanceof DStylizable && ((DStylizable) object).getStyle() instanceof EdgeStyle && ((EdgeStyle) ((DStylizable) object).getStyle()).getStrokeColor() != null) {
            final DStylizable stylizable = (DStylizable) object;
            final View view = map.get(stylizable);

            final EdgeStyle edgeStyle = (EdgeStyle) stylizable.getStyle();
            final RGBValues rgb = edgeStyle.getStrokeColor();
            final CompositeEObjectPropertySource propertySource = new CompositeEObjectPropertySource();
            AdapterFactory af = getAdapterFactory(edgeStyle);
            if (af != null) {
                final IItemPropertySource ips = (IItemPropertySource) af.adapt(edgeStyle, IItemPropertySource.class);
                if (ips != null) {
                    final IPropertySource targetPropertySource = new StylePropertySource(edgeStyle, view, ips);
                    propertySource.addPropertySource(edgeStyle, targetPropertySource);
                }
            }
            af = getAdapterFactory(rgb);
            if (af != null) {
                final IItemPropertySource ips = (IItemPropertySource) af.adapt(rgb, IItemPropertySource.class);
                if (ips != null) {
                    final IPropertySource targetPropertySource = new StylePropertySource(rgb, view, ips);
                    propertySource.addPropertySource(rgb, targetPropertySource);
                }
            }
            propSrc = propertySource;
        } else {
            //
            // Other styles.
            propSrc = getPropertySourceForOtherStyles(object);
        }
        return propSrc;

    }

    private IPropertySource getPropertySourceForOtherStyles(final Object object) {

        IPropertySource propSrc = null;

        if (object instanceof DStylizable) {
            final DStylizable stylizable = (DStylizable) object;
            final View view = map.get(stylizable);
            final Style style = stylizable.getStyle();
            if (style != null) {
                final AdapterFactory af = getAdapterFactory(style);
                if (af != null) {
                    final IItemPropertySource ips = (IItemPropertySource) af.adapt(style, IItemPropertySource.class);
                    if (ips != null) {
                        final IPropertySource targetPropertySource = new StylePropertySource(style, view, ips);
                        propSrc = targetPropertySource;
                    }
                }
            }
        }
        if (propSrc == null) {
            final AdapterFactory af = getAdapterFactory(object);
            if (af != null) {
                final IItemPropertySource ips = (IItemPropertySource) af.adapt(object, IItemPropertySource.class);
                if (ips != null) {
                    propSrc = new StylePropertySource(object, ips);
                }
            }
            if (propSrc == null && object instanceof IAdaptable) {
                propSrc = (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);
            }
        }

        return propSrc;
    }

    private IPermissionAuthority getPermissionAuthority(final EObject instance) {
        final ModelAccessor accessor = SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(instance);
        return accessor.getPermissionAuthority();
    }

    /**
     * Transform selection to have {@link DSemanticDecorator} instead of
     * {@link EditPart} or null if the semantic element (target) not exists.
     * 
     * @param selection
     *            the currently selected object
     * @return the unwrapped object
     */
    @Override
    protected Object transformSelection(final Object selection) {

        Object object = selection;
        View view = null;

        if (object instanceof EditPart) {
            object = ((EditPart) object).getModel();
        } else if (object instanceof IAdaptable) {
            object = ((IAdaptable) object).getAdapter(View.class);
        }

        if (object instanceof View) {
            view = (View) object;
            object = view.getElement();
        }

        if (view != null && object instanceof DStylizable) {
            map.put((DStylizable) object, view);
        }

        if (object instanceof DSemanticDecorator) {
            EObject target = ((DSemanticDecorator) object).getTarget();
            if (target == null || target.eResource() == null) {
                object = null;
            }
        }
        return object;
    }

    /**
     * {@inheritDoc}
     * 
     * This is used to automatically set the "custom" attribute of a Style if
     * there is any manual change in the PropertySection.
     * 
     * @author mPorhel
     * 
     */
    private static class StylePropertySource extends PropertySource {

        private View view;

        /**
         * An instance is constructed from an object and its item property
         * source.
         */
        public StylePropertySource(final Object object, final IItemPropertySource itemPropertySource) {
            super(object, itemPropertySource);
            this.view = null;
        }

        /**
         * An instance is constructed from an object, its edit part and its item
         * property source.
         */
        public StylePropertySource(final Object object, final View view, final IItemPropertySource itemPropertySource) {
            super(object, itemPropertySource);
            this.view = view;
        }

        /**
         * 
         * {@inheritDoc}
         * 
         * @see org.eclipse.emf.edit.ui.provider.PropertySource#setPropertyValue(java.lang.Object,
         *      java.lang.Object)
         */
        @Override
        public void setPropertyValue(final Object propertyId, final Object value) {
            if (this.object instanceof Style && propertyId instanceof String) {
                Style style = (Style) object;
                String featureName = (String) propertyId;
                EStructuralFeature feature = style.eClass().getEStructuralFeature(featureName);
                if (feature != null && !style.getCustomFeatures().contains(feature.getName())) {
                    style.getCustomFeatures().add(feature.getName());
                }
            } else if (object instanceof EObject && ((EObject) object).eContainer() instanceof Style && propertyId instanceof String) {
                EObject containedValue = (EObject) object;
                Style style = (Style) containedValue.eContainer();
                EStructuralFeature feature = containedValue.eContainingFeature();
                if (feature != null && !style.getCustomFeatures().contains(feature.getName())) {
                    style.getCustomFeatures().add(feature.getName());
                }
            }
            super.setPropertyValue(propertyId, value);

            if (this.object instanceof LabelStyle) {
                updateNotationView(propertyId, value);
            } else if (this.object instanceof EdgeStyle) {
                updateNotationView(propertyId, value);
            } else if (this.object instanceof RGBValues) {
                updateNotationView(propertyId, value);
            }
        }

        private void updateNotationView(final Object propertyId, final Object value) {
            if (view != null && view.getStyles() != null) {
                for (Object notationStyle : view.getStyles()) {
                    if (notationStyle instanceof FontStyle) {
                        final FontStyle fontStyle = (FontStyle) notationStyle;
                        if (value instanceof FontFormat && propertyId.equals(SiriusPackage.Literals.BASIC_LABEL_STYLE__LABEL_FORMAT.getName())) {
                            if (FontFormat.BOLD_LITERAL == value) {
                                fontStyle.setBold(true);
                                fontStyle.setItalic(false);
                            } else if (FontFormat.ITALIC_LITERAL == value) {
                                fontStyle.setBold(false);
                                fontStyle.setItalic(true);
                            } else if (FontFormat.BOLD_ITALIC_LITERAL == value) {
                                fontStyle.setBold(true);
                                fontStyle.setItalic(true);
                            } else if (FontFormat.NORMAL_LITERAL == value) {
                                fontStyle.setBold(false);
                                fontStyle.setItalic(false);
                            }
                        } else if (value instanceof Integer && propertyId.equals(SiriusPackage.Literals.BASIC_LABEL_STYLE__LABEL_SIZE.getName())) {
                            fontStyle.setFontHeight((Integer) value);
                        }
                    } else if (notationStyle instanceof ConnectorStyle) {
                        ConnectorStyle connectorStyle = (ConnectorStyle) notationStyle;
                        if (value instanceof EdgeRouting && propertyId.equals(SiriusPackage.Literals.EDGE_STYLE__ROUTING_STYLE.getName())) {
                            if (EdgeRouting.MANHATTAN_LITERAL == value) {
                                connectorStyle.setRouting(Routing.RECTILINEAR_LITERAL);
                            } else if (EdgeRouting.STRAIGHT_LITERAL == value) {
                                connectorStyle.setRouting(Routing.MANUAL_LITERAL);
                            } else if (EdgeRouting.TREE_LITERAL == value) {
                                connectorStyle.setRouting(Routing.TREE_LITERAL);
                            }
                        }
                    }
                }
            }
        }
    }

}
