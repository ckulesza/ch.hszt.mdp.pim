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
public class SerializeContactDAO implements IContactDAO {

	@Override
	public Contact loadContactById() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> loadAllContacts() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertContacts(List<Contact> contacts) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContacts(List<Contact> contacts)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContacts(List<Contact> contact)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
}