/**
 * 
 */
package ch.hszt.mdp.pim.daos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import ch.hszt.mdp.pim.daofactories.SerializeDAOFactory;
import ch.hszt.mdp.pim.exceptions.DataAccessException;
import ch.hszt.mdp.pim.models.Contact;

/**
 * @author Christof Kulesza
 * 
 */
public class SerializeContactDAO implements IContactDAO {

	@Override
	public Contact loadContactById(long id) throws DataAccessException {

		return null;
	}

	@Override
	public List<Contact> loadAllContacts() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertContact(Contact contact) throws DataAccessException {
		// TODO get list and write whole list
		return 0;
	}

	@Override
	public int insertContacts(List<Contact> contacts)
			throws DataAccessException {
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
					SerializeDAOFactory.getContactFile()));
			out.writeObject(contacts);
			out.close();
		} catch (IOException e) {
			throw new DataAccessException("Contact couldn't be loaded.", e);
		}
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