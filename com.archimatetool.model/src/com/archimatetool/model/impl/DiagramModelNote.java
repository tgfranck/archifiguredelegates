/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IDiagramModelNote;
import com.archimatetool.model.ITextContent;
import com.archimatetool.model.ITextPosition;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Model Note</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.archimatetool.model.impl.DiagramModelNote#getContent <em>Content</em>}</li>
 *   <li>{@link com.archimatetool.model.impl.DiagramModelNote#getTextPosition <em>Text Position</em>}</li>
 *   <li>{@link com.archimatetool.model.impl.DiagramModelNote#getBorderType <em>Border Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagramModelNote extends DiagramModelObject implements IDiagramModelNote {
    /**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
    protected static final String CONTENT_EDEFAULT = ""; //$NON-NLS-1$

    /**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
    protected String content = CONTENT_EDEFAULT;

    /**
	 * The default value of the '{@link #getTextPosition() <em>Text Position</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTextPosition()
	 * @generated
	 * @ordered
	 */
    protected static final int TEXT_POSITION_EDEFAULT = 0;

    /**
	 * The cached value of the '{@link #getTextPosition() <em>Text Position</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTextPosition()
	 * @generated
	 * @ordered
	 */
    protected int textPosition = TEXT_POSITION_EDEFAULT;

    /**
	 * The default value of the '{@link #getBorderType() <em>Border Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBorderType()
	 * @generated
	 * @ordered
	 */
    protected static final int BORDER_TYPE_EDEFAULT = 0;

    /**
	 * The cached value of the '{@link #getBorderType() <em>Border Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBorderType()
	 * @generated
	 * @ordered
	 */
    protected int borderType = BORDER_TYPE_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected DiagramModelNote() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return IArchimatePackage.Literals.DIAGRAM_MODEL_NOTE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getContent() {
		return content;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT, oldContent, content));
	}
    
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getTextPosition() {
		return textPosition;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTextPosition(int newTextPosition) {
		int oldTextPosition = textPosition;
		textPosition = newTextPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION, oldTextPosition, textPosition));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getBorderType() {
		return borderType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setBorderType(int newBorderType) {
		int oldBorderType = borderType;
		borderType = newBorderType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE, oldBorderType, borderType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT:
				return getContent();
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION:
				return getTextPosition();
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE:
				return getBorderType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT:
				setContent((String)newValue);
				return;
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION:
				setTextPosition((Integer)newValue);
				return;
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE:
				setBorderType((Integer)newValue);
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
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION:
				setTextPosition(TEXT_POSITION_EDEFAULT);
				return;
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE:
				setBorderType(BORDER_TYPE_EDEFAULT);
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
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION:
				return textPosition != TEXT_POSITION_EDEFAULT;
			case IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE:
				return borderType != BORDER_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ITextContent.class) {
			switch (derivedFeatureID) {
				case IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT: return IArchimatePackage.TEXT_CONTENT__CONTENT;
				default: return -1;
			}
		}
		if (baseClass == ITextPosition.class) {
			switch (derivedFeatureID) {
				case IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION: return IArchimatePackage.TEXT_POSITION__TEXT_POSITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ITextContent.class) {
			switch (baseFeatureID) {
				case IArchimatePackage.TEXT_CONTENT__CONTENT: return IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT;
				default: return -1;
			}
		}
		if (baseClass == ITextPosition.class) {
			switch (baseFeatureID) {
				case IArchimatePackage.TEXT_POSITION__TEXT_POSITION: return IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (content: "); //$NON-NLS-1$
		result.append(content);
		result.append(", textPosition: "); //$NON-NLS-1$
		result.append(textPosition);
		result.append(", borderType: "); //$NON-NLS-1$
		result.append(borderType);
		result.append(')');
		return result.toString();
	}

} //DiagramModelNote
