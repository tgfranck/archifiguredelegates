/**
 */
package model;

import com.archimatetool.model.IArchimatePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.wipro.com/colorview";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "colorview";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.ColorViewLegendImpl <em>Color View Legend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ColorViewLegendImpl
	 * @see model.impl.ModelPackageImpl#getColorViewLegend()
	 * @generated
	 */
	int COLOR_VIEW_LEGEND = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__ID = IArchimatePackage.DIAGRAM_MODEL_NOTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__NAME = IArchimatePackage.DIAGRAM_MODEL_NOTE__NAME;

	/**
	 * The feature id for the '<em><b>Source Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__SOURCE_CONNECTIONS = IArchimatePackage.DIAGRAM_MODEL_NOTE__SOURCE_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Target Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__TARGET_CONNECTIONS = IArchimatePackage.DIAGRAM_MODEL_NOTE__TARGET_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Font</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__FONT = IArchimatePackage.DIAGRAM_MODEL_NOTE__FONT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__FONT_COLOR = IArchimatePackage.DIAGRAM_MODEL_NOTE__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__LINE_WIDTH = IArchimatePackage.DIAGRAM_MODEL_NOTE__LINE_WIDTH;

	/**
	 * The feature id for the '<em><b>Line Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__LINE_COLOR = IArchimatePackage.DIAGRAM_MODEL_NOTE__LINE_COLOR;

	/**
	 * The feature id for the '<em><b>Text Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__TEXT_ALIGNMENT = IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__BOUNDS = IArchimatePackage.DIAGRAM_MODEL_NOTE__BOUNDS;

	/**
	 * The feature id for the '<em><b>Fill Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__FILL_COLOR = IArchimatePackage.DIAGRAM_MODEL_NOTE__FILL_COLOR;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__CONTENT = IArchimatePackage.DIAGRAM_MODEL_NOTE__CONTENT;

	/**
	 * The feature id for the '<em><b>Text Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__TEXT_POSITION = IArchimatePackage.DIAGRAM_MODEL_NOTE__TEXT_POSITION;

	/**
	 * The feature id for the '<em><b>Border Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__BORDER_TYPE = IArchimatePackage.DIAGRAM_MODEL_NOTE__BORDER_TYPE;

	/**
	 * The feature id for the '<em><b>Legend Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND__LEGEND_ITEMS = IArchimatePackage.DIAGRAM_MODEL_NOTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color View Legend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_VIEW_LEGEND_FEATURE_COUNT = IArchimatePackage.DIAGRAM_MODEL_NOTE_FEATURE_COUNT + 1;
	
	/**
	 * Returns the meta object for class '{@link model.ColorViewLegend <em>Color View Legend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color View Legend</em>'.
	 * @see model.ColorViewLegend
	 * @generated
	 */
	EClass getColorViewLegend();

	/**
	 * Returns the meta object for the attribute '{@link model.ColorViewLegend#getLegendItems <em>Legend Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Legend Items</em>'.
	 * @see model.ColorViewLegend#getLegendItems()
	 * @see #getColorViewLegend()
	 * @generated
	 */
	EAttribute getColorViewLegend_LegendItems();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.impl.ColorViewLegendImpl <em>Color View Legend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ColorViewLegendImpl
		 * @see model.impl.ModelPackageImpl#getColorViewLegend()
		 * @generated
		 */
		EClass COLOR_VIEW_LEGEND = eINSTANCE.getColorViewLegend();
		/**
		 * The meta object literal for the '<em><b>Legend Items</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_VIEW_LEGEND__LEGEND_ITEMS = eINSTANCE.getColorViewLegend_LegendItems();

	}

} //ModelPackage
