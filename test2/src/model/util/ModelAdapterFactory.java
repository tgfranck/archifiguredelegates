/**
 */
package model.util;

import com.archimatetool.model.IAdapter;
import com.archimatetool.model.ICloneable;
import com.archimatetool.model.IConnectable;
import com.archimatetool.model.IDiagramModelComponent;
import com.archimatetool.model.IDiagramModelNote;
import com.archimatetool.model.IDiagramModelObject;
import com.archimatetool.model.IFontAttribute;
import com.archimatetool.model.IIdentifier;
import com.archimatetool.model.ILineObject;
import com.archimatetool.model.INameable;
import com.archimatetool.model.ITextAlignment;
import com.archimatetool.model.ITextContent;
import com.archimatetool.model.ITextPosition;

import model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseColorViewLegend(ColorViewLegend object) {
				return createColorViewLegendAdapter();
			}
			@Override
			public Adapter caseIdentifier(IIdentifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseCloneable(ICloneable object) {
				return createCloneableAdapter();
			}
			@Override
			public Adapter caseAdapter(IAdapter object) {
				return createAdapterAdapter();
			}
			@Override
			public Adapter caseNameable(INameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseDiagramModelComponent(IDiagramModelComponent object) {
				return createDiagramModelComponentAdapter();
			}
			@Override
			public Adapter caseConnectable(IConnectable object) {
				return createConnectableAdapter();
			}
			@Override
			public Adapter caseFontAttribute(IFontAttribute object) {
				return createFontAttributeAdapter();
			}
			@Override
			public Adapter caseLineObject(ILineObject object) {
				return createLineObjectAdapter();
			}
			@Override
			public Adapter caseTextAlignment(ITextAlignment object) {
				return createTextAlignmentAdapter();
			}
			@Override
			public Adapter caseDiagramModelObject(IDiagramModelObject object) {
				return createDiagramModelObjectAdapter();
			}
			@Override
			public Adapter caseTextContent(ITextContent object) {
				return createTextContentAdapter();
			}
			@Override
			public Adapter caseTextPosition(ITextPosition object) {
				return createTextPositionAdapter();
			}
			@Override
			public Adapter caseDiagramModelNote(IDiagramModelNote object) {
				return createDiagramModelNoteAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link model.ColorViewLegend <em>Color View Legend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ColorViewLegend
	 * @generated
	 */
	public Adapter createColorViewLegendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IIdentifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.ICloneable <em>Cloneable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.ICloneable
	 * @generated
	 */
	public Adapter createCloneableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IAdapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IAdapter
	 * @generated
	 */
	public Adapter createAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.INameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.INameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IDiagramModelComponent <em>Diagram Model Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IDiagramModelComponent
	 * @generated
	 */
	public Adapter createDiagramModelComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IConnectable <em>Connectable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IConnectable
	 * @generated
	 */
	public Adapter createConnectableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IFontAttribute <em>Font Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IFontAttribute
	 * @generated
	 */
	public Adapter createFontAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.ILineObject <em>Line Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.ILineObject
	 * @generated
	 */
	public Adapter createLineObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.ITextAlignment <em>Text Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.ITextAlignment
	 * @generated
	 */
	public Adapter createTextAlignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IDiagramModelObject <em>Diagram Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IDiagramModelObject
	 * @generated
	 */
	public Adapter createDiagramModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.ITextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.ITextContent
	 * @generated
	 */
	public Adapter createTextContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.ITextPosition <em>Text Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.ITextPosition
	 * @generated
	 */
	public Adapter createTextPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.archimatetool.model.IDiagramModelNote <em>Diagram Model Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.archimatetool.model.IDiagramModelNote
	 * @generated
	 */
	public Adapter createDiagramModelNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
