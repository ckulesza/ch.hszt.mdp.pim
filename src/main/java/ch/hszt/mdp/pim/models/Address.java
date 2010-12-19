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
	private String country;
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

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String toString() {
		return this.street + " " + this.houseNumber + " \n" + this.postalCode
				+ " " + this.place;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address address = (Address) obj;
		if (!this.street.equals(address.getStreet())) {
			return false;
		}
		if (!this.houseNumber.equals(address.getHouseNumber())) {
			return false;
		}
		if (!this.postalCode.equals(address.getPostalCode())) {
			return false;
		}
		if (!this.place.equals(address.getPlace())) {
			return false;
		}
		if (!this.country.equals(address.getCountry())) {
			return false;
		}
		return true;
	}

}