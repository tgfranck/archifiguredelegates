/**
 */
package model;

import com.archimatetool.model.IDiagramModelNote;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color View Legend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.ColorViewLegend#getLegendItems <em>Legend Items</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getColorViewLegend()
 * @model
 * @generated
 */
public interface ColorViewLegend extends IDiagramModelNote {

	/**
	 * Returns the value of the '<em><b>Legend Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Legend Items</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Legend Items</em>' attribute.
	 * @see #setLegendItems(Map)
	 * @see model.ModelPackage#getColorViewLegend_LegendItems()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, String> getLegendItems();

	/**
	 * Sets the value of the '{@link model.ColorViewLegend#getLegendItems <em>Legend Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Legend Items</em>' attribute.
	 * @see #getLegendItems()
	 * @generated
	 */
	void setLegendItems(Map<String, String> value);
	
	void addLine(String colorHexValue, String description);
} // ColorViewLegend
