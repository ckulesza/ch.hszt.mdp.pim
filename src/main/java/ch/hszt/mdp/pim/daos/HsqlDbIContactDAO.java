package ch.hszt.mdp.pim.daos;

import java.util.List;

import ch.hszt.mdp.pim.exceptions.DataAccessException;
import ch.hszt.mdp.pim.models.Contact;

/**
 * 
 * @author Ramy Hasan
 *
 */
public class HsqlDbIContactDAO implements IContactDAO {

	@Override
	public Contact loadContactById(long id) throws DataAccessException {
		return null;
	}

	@Override
	public List<Contact> loadAllContacts() throws DataAccessException {
		return null;
	}

	@Override
	public int insertContact(Contact contact) throws DataAccessException {
		return 0;
	}

	@Override
	public int insertContacts(List<Contact> contacts)
			throws DataAccessException {
		return 0;
	}

	@Override
	public boolean updateContact(Contact contact) throws DataAccessException {
		return false;
	}

	@Override
	public void updateContacts(List<Contact> contacts)
			throws DataAccessException {
		
	}

	@Override
	public boolean deleteContact(Contact contact) throws DataAccessException {
		return false;
	}

	@Override
	public boolean deleteContacts(List<Contact> contact)
			throws DataAccessException {
		return false;
	}

}
