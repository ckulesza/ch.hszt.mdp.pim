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
public class Contact implements Serializable, PropertyChangeListener,
		Comparable<Contact> {

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
	private String group;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

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
	 * Get's the first name of the contact.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * Set's the first name of the contact.
	 * 
	 * @param firstName
	 *            the first name to set
	 */
	public void setFirstName(String firstName) {
		propertyChangeSupport.firePropertyChange("firstName", this.firstName,
				this.firstName = firstName);
	}

	/**
	 * Get's the last name of the contact.
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set's the last name of the contact.
	 * 
	 * @param lastName
	 *            the last name to set
	 */
	public void setLastName(String lastName) {
		propertyChangeSupport.firePropertyChange("lastName", this.lastName,
				this.lastName = lastName);
	}

	/**
	 * Get's the birth date of the contact.
	 * 
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Set's the birth date of the contact.
	 * 
	 * @param birthDate
	 *            the birth date to set
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
	 * Get's the email address of the contact.
	 * 
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set's the email address of the contact.
	 * 
	 * @param email
	 *            the email address to set
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
	 * Get's the telephone number of the contact.
	 * 
	 * @return the telephone number
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Set's the telephone number of the contact.
	 * 
	 * @param telephone
	 *            the telephone number to set
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
	public void propertyChange(PropertyChangeEvent event) {
		propertyChangeSupport.firePropertyChange("address", null, address);
	}

	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		String s = this.firstName + " " + this.lastName + " [" + this.group
				+ "]";
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact contact = (Contact) obj;
		if (this.id != contact.getId()) {
			return false;
		}
		if (!this.firstName.equals(contact.getFirstName())) {
			return false;
		}
		if (!this.lastName.equals(contact.getLastName())) {
			return false;
		}
		if (!this.birthDate.equals(contact.getBirthDate())) {
			return false;
		}
		if (!this.address.equals(contact.getAddress())) {
			return false;
		}
		if (!this.email.equals(contact.getEmail())) {
			return false;
		}
		if (!this.url.equals(contact.getUrl())) {
			return false;
		}
		if (!this.telephone.equals(contact.getTelephone())) {
			return false;
		}
		if (!this.comment.equals(contact.getComment())) {
			return false;
		}
		if (!this.job.equals(contact.getJob())) {
			return false;
		}
		if (!this.group.equals(contact.getGroup())) {
			return false;
		}
		return true;
	}
}