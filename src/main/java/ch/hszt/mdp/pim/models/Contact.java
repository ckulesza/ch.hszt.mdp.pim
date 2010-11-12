/**
 * 
 */
package ch.hszt.mdp.pim.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Christof Kulesza
 * 
 */
public class Contact implements Serializable, PropertyChangeListener {

	private static final long serialVersionUID = -8062971730282279711L;
	private long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Address address;
	private String email;
	private String url;
	private String telephone;
	private String comment;
	private String job;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		propertyChangeSupport.firePropertyChange("id", this.id, this.id = id);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		propertyChangeSupport.firePropertyChange("firstName", this.firstName,
				this.firstName = firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		propertyChangeSupport.firePropertyChange("lastName", this.lastName,
				this.lastName = lastName);
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		propertyChangeSupport.firePropertyChange("birthDate", this.birthDate,
				this.birthDate = birthDate);
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		address.addPropertyChangeListener("street", this);
		address.addPropertyChangeListener("houseNumber", this);
		address.addPropertyChangeListener("postalCode", this);
		address.addPropertyChangeListener("place", this);
		propertyChangeSupport.firePropertyChange("address", this.address,
				this.address = address);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		propertyChangeSupport.firePropertyChange("email", this.email,
				this.email = email);
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		propertyChangeSupport.firePropertyChange("url", this.url,
				this.url = url);
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		propertyChangeSupport.firePropertyChange("telephone", this.telephone,
				this.telephone = telephone);
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		propertyChangeSupport.firePropertyChange("comment", this.comment,
				this.comment = comment);
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		propertyChangeSupport.firePropertyChange("job", this.job,
				this.job = job);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}