package ch.hszt.mdp.pim.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Address implements Serializable, PropertyChangeListener {

	private static final long serialVersionUID = -8296829681413092437L;
	private String street;
	private String houseNumber;
	private String postalCode;
	private String place;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		propertyChangeSupport.firePropertyChange("street", this.street,
				this.street = street);
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber
	 *            the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		propertyChangeSupport.firePropertyChange("houseNumber",
				this.houseNumber, this.houseNumber = houseNumber);
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		propertyChangeSupport.firePropertyChange("postalCode", this.postalCode,
				this.postalCode = postalCode);
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		propertyChangeSupport.firePropertyChange("place", this.place,
				this.place = place);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
}