/**
 *  Copyright (c) 2019 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.sirius.tests.services.graphql.extlibrary.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.tests.services.graphql.extlibrary.Book;
import org.eclipse.sirius.tests.services.graphql.extlibrary.ExtlibraryPackage;
import org.eclipse.sirius.tests.services.graphql.extlibrary.Writer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Writer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.tests.services.graphql.extlibrary.impl.WriterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.sirius.tests.services.graphql.extlibrary.impl.WriterImpl#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WriterImpl extends PersonImpl implements Writer {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBooks() <em>Books</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBooks()
     * @generated
     * @ordered
     */
    protected EList<Book> books;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WriterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExtlibraryPackage.Literals.WRITER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        // TODO: implement this method to return the 'Name' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        // TODO: implement this method to set the 'Name' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Book> getBooks() {
        if (books == null) {
            books = new EObjectWithInverseResolvingEList<Book>(Book.class, this, ExtlibraryPackage.WRITER__BOOKS, ExtlibraryPackage.BOOK__AUTHOR);
        }
        return books;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__BOOKS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getBooks()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__BOOKS:
                return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__NAME:
                return getName();
            case ExtlibraryPackage.WRITER__BOOKS:
                return getBooks();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__NAME:
                setName((String)newValue);
                return;
            case ExtlibraryPackage.WRITER__BOOKS:
                getBooks().clear();
                getBooks().addAll((Collection<? extends Book>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ExtlibraryPackage.WRITER__BOOKS:
                getBooks().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExtlibraryPackage.WRITER__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
            case ExtlibraryPackage.WRITER__BOOKS:
                return books != null && !books.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //WriterImpl
