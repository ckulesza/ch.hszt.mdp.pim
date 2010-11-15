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

	public Contact loadContactById(long id) throws DataAccessException;

	public List<Contact> loadAllContacts() throws DataAccessException;

	public int insertContact(Contact contact) throws DataAccessException;

	public int insertContacts(List<Contact> contacts)
			throws DataAccessException;

	public boolean updateContact(Contact contact) throws DataAccessException;

	public void updateContacts(List<Contact> contacts)
			throws DataAccessException;

	public boolean deleteContact(Contact contact) throws DataAccessException;

	public boolean deleteContacts(List<Contact> contact)
			throws DataAccessException;
}
