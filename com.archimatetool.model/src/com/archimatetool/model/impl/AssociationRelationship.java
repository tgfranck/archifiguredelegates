/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model.impl;

import org.eclipse.emf.ecore.EClass;

import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IAssociationRelationship;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AssociationRelationship extends ArchimateRelationship implements IAssociationRelationship {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AssociationRelationship() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return IArchimatePackage.Literals.ASSOCIATION_RELATIONSHIP;
	}

} //AssociationRelationship
