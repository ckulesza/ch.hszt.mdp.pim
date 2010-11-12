/**
 * 
 */
package ch.hszt.mdp.pim.daos;

import java.util.List;

import ch.hszt.mdp.pim.exceptions.DataAccessException;
import ch.hszt.mdp.pim.models.Contact;

/**
 * @author Christof Kulesza
 * 
 */
public interface IContactDAO {

	public Contact loadContactById() throws DataAccessException;

	public List<Contact> loadAllContacts() throws DataAccessException;

	public void insertContact(Contact contact) throws DataAccessException;

	public void insertContacts(List<Contact> contacts) throws DataAccessException;

	public void updateContact(Contact contact) throws DataAccessException;

	public void updateContacts(List<Contact> contacts)
			throws DataAccessException;

	public void deleteContact(Contact contact) throws DataAccessException;

	public void deleteContacts(List<Contact> contact)
			throws DataAccessException;
}
