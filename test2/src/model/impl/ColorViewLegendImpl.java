/**
 */
package model.impl;

import com.archimatetool.model.impl.DiagramModelNote;

import java.util.LinkedHashMap;
import java.util.Map;
import model.ColorViewLegend;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color View Legend</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.impl.ColorViewLegendImpl#getLegendItems <em>Legend Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColorViewLegendImpl extends DiagramModelNote implements ColorViewLegend {
	/**
	 * The cached value of the '{@link #getLegendItems() <em>Legend Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegendItems()
	 * @generated
	 * @ordered
	 */
	protected Map<String, String> legendItems = new LinkedHashMap<String, String>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorViewLegendImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.COLOR_VIEW_LEGEND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, String> getLegendItems() {
		return legendItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegendItems(Map<String, String> newLegendItems) {
		Map<String, String> oldLegendItems = legendItems;
		legendItems = newLegendItems;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLOR_VIEW_LEGEND__LEGEND_ITEMS, oldLegendItems, legendItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addLine(String colorHexValue, String description) {
		legendItems.put(colorHexValue, description);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.COLOR_VIEW_LEGEND__LEGEND_ITEMS:
				return getLegendItems();
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
			case ModelPackage.COLOR_VIEW_LEGEND__LEGEND_ITEMS:
				setLegendItems((Map<String, String>)newValue);
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
			case ModelPackage.COLOR_VIEW_LEGEND__LEGEND_ITEMS:
				setLegendItems((Map<String, String>)null);
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
			case ModelPackage.COLOR_VIEW_LEGEND__LEGEND_ITEMS:
				return legendItems != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (legendItems: ");
		result.append(legendItems);
		result.append(')');
		return result.toString();
	}

} //ColorViewLegendImpl
