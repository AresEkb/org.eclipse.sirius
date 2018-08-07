/*******************************************************************************
 * Copyright (c) 2006, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ecore.extender.tool.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;
import org.eclipse.sirius.ecore.extender.business.api.permission.PermissionAuthorityRegistry;
import org.eclipse.sirius.ecore.extender.business.internal.ExtenderPlugin;
import org.eclipse.sirius.ecore.extender.tool.internal.ReferencesResolver;
import org.eclipse.sirius.ext.emf.EReferencePredicate;

/**
 * Utility class for model loading/saving and serialization.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public final class ModelUtils {
    /** Constant for the file encoding system property. */
    private static final String ENCODING_PROPERTY = "file.encoding"; //$NON-NLS-1$

    /**
     * Utility classes don't need to (and shouldn't) be instantiated.
     */
    private ModelUtils() {
        // prevents instantiation
    }

    /**
     * This will create a {@link Resource} given the model extension it is intended for and a ResourceSet.
     * 
     * @param modelURI
     *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
     * @param resourceSet
     *            The {@link ResourceSet} to load the model in.
     * @return The {@link Resource} given the model extension it is intended for.
     */
    public static Resource createResource(final URI modelURI, final ResourceSet resourceSet) {
        String fileExtension = modelURI.fileExtension();
        if (fileExtension == null || fileExtension.length() == 0) {
            fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
        }

        final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
        final Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
        if (resourceFactory != null) {
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, resourceFactory);
        } else {
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, new XMIResourceFactoryImpl());
        }

        return resourceSet.createResource(modelURI);
    }

    /**
     * Loads a model from an {@link org.eclipse.emf.common.util.URI URI} in a given {@link ResourceSet}.
     * <p>
     * This will return the first root of the loaded model, other roots can be accessed via the resource's content.
     * </p>
     * 
     * @param modelURI
     *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
     * @param resourceSet
     *            The {@link ResourceSet} to load the model in.
     * @return The model loaded from the URI.
     * @throws IOException
     *             If the given file does not exist.
     */
    public static EObject load(final URI modelURI, final ResourceSet resourceSet) throws IOException {
        Resource modelResource = resourceSet.getResource(modelURI, false);
        if (modelResource == null) {
            modelResource = ModelUtils.createResource(modelURI, resourceSet);
        }
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_ENCODING, System.getProperty(ModelUtils.ENCODING_PROPERTY));
        return ModelUtils.load(modelResource, options);
    }

    /**
     * Loads a resource from an {@link org.eclipse.emf.common.util.URI URI} in a given {@link ResourceSet}.
     * <p>
     * If the load fails, the resource is unloaded and removed from the resourceSet.
     * </p>
     * 
     * @param resourceURI
     *            {@link org.eclipse.emf.common.util.URI URI} where the model is stored.
     * @param resourceSet
     *            The {@link ResourceSet} to load the model in.
     * @return The resource.
     */
    public static Resource getResource(final ResourceSet resourceSet, final URI resourceURI) {
        Resource resource = null;
        try {
            resource = resourceSet.getResource(resourceURI, true);
        } catch (WrappedException e) {
            if (ExtenderPlugin.getPlugin().isDebugging()) {
                ExtenderPlugin.getPlugin().getLog().log(new Status(IStatus.WARNING, ExtenderPlugin.ID, e.getMessage(), e));
            }
            // Warning: as getResource has been called with loadOnDemand to
            // true, the resource is created with errors but is set on
            // resourceSet
        }

        return resource;
    }

    /**
     * Loads a model from a resource with the given options.
     * <p>
     * This will return the first root of the loaded model, other roots can be accessed via the resource's content.
     * </p>
     * 
     * @param modelResource
     *            the model resource
     * @param options
     *            The EMF options to load the mode.
     * @return The model loaded from the resource.
     * @throws IOException
     *             If the given file does not exist.
     */
    private static EObject load(final Resource modelResource, final Map<Object, Object> options) throws IOException {
        EObject result = null;

        modelResource.load(options);
        if (modelResource.getContents().size() > 0) {
            result = modelResource.getContents().get(0);
        }
        return result;
    }

    /**
     * Browse the whole model resolving references.
     * 
     * @param set
     *            any model.
     */
    public static void resolveAll(final ResourceSet set) {
        final IPermissionAuthority authority = PermissionAuthorityRegistry.getDefault().getPermissionAuthority(set);
        final List<Resource> cachedIdsResources = ReferencesResolver.prepareResolveAll(set, authority);
        EcoreUtil.resolveAll(set);
        ReferencesResolver.unprepareResolveAll(authority, cachedIdsResources);
    }

    /**
     * Force the resolution of every proxy in the given resource set selecting the references to resolve with a filter.
     * 
     * @param set
     *            the resource set to resolve.
     * @param filter
     *            predicate responsible to say wether the reference should be resolved or not.
     */
    public static void resolveAll(final ResourceSet set, EReferencePredicate filter) {
        final IPermissionAuthority authority = PermissionAuthorityRegistry.getDefault().getPermissionAuthority(set);
        final List<Resource> cachedIdsResources = ReferencesResolver.prepareResolveAll(set, authority);
        new ReferencesResolver(set, filter).resolve(new NullProgressMonitor());
        ReferencesResolver.unprepareResolveAll(authority, cachedIdsResources);
    }

    /**
     * Browse the whole model resolving references.
     * 
     * @param res
     *            any model.
     */
    public static void resolveAll(final Resource res) {
        resolveAll(res, false);
    }

    /**
     * Browse the whole model resolving references (and do it recursively in new resources if recursive parameter is
     * true).
     * 
     * @param res
     *            any model.
     * @param recursive
     *            true to resolveAll resources loading during the resolveAll of the <code>res<code>, false otherwise.
     */
    public static void resolveAll(final Resource res, boolean recursive) {
        final IPermissionAuthority authority = PermissionAuthorityRegistry.getDefault().getPermissionAuthority(res);
        if (authority != null) {
            authority.setListening(false);
        }
        List<Resource> cachedIDsResources = Collections.emptyList();
        if (res != null && res.getResourceSet() != null) {
            cachedIDsResources = ModelUtils.cachedEObjectIDs(res.getResourceSet());
        }
        List<Resource> resourcesBeforeResolveAll = new ArrayList<Resource>(res.getResourceSet().getResources());
        EcoreUtil.resolveAll(res);
        if (recursive) {
            List<Resource> resourcesAfterResolveAll = new ArrayList<Resource>(res.getResourceSet().getResources());
            // Remove the known resources
            resourcesAfterResolveAll.removeAll(resourcesBeforeResolveAll);
            for (Resource resource : resourcesAfterResolveAll) {
                resolveAll(resource, recursive);
            }
        }
        ModelUtils.uncachedEObejctIDs(cachedIDsResources);
        if (authority != null) {
            authority.setListening(true);
        }
    }

    /**
     * Sets a cache for EObject ids for the specified resource set. return all modified resources.
     * 
     * @param resourceSet
     *            the resource set.
     * @return all modified resources.
     */
    private static List<Resource> cachedEObjectIDs(final ResourceSet resourceSet) {
        final List<Resource> result = new LinkedList<Resource>();
        final Iterator<Resource> iterResources = resourceSet.getResources().iterator();
        while (iterResources.hasNext()) {
            final Resource currentResource = iterResources.next();
            if (currentResource instanceof ResourceImpl && ((ResourceImpl) currentResource).getIntrinsicIDToEObjectMap() == null) {
                ((ResourceImpl) currentResource).setIntrinsicIDToEObjectMap(new HashMap<String, EObject>());
                result.add(currentResource);
            }
        }
        return result;
    }

    /**
     * Uncached EObjects IDs of the given resources.
     * 
     * @param resources
     *            the resources.
     */
    private static void uncachedEObejctIDs(final List<Resource> resources) {
        final Iterator<Resource> iterResources = resources.iterator();
        while (iterResources.hasNext()) {
            final Resource currentResource = iterResources.next();
            if (currentResource instanceof ResourceImpl) {
                ((ResourceImpl) currentResource).setIntrinsicIDToEObjectMap(null);
            }
        }
    }
}
