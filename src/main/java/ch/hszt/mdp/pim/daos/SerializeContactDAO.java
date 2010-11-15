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
	public Contact loadContactById(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> loadAllContacts() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertContacts(List<Contact> contacts)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateContacts(List<Contact> contacts)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteContact(Contact contact) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContacts(List<Contact> contact)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}
}