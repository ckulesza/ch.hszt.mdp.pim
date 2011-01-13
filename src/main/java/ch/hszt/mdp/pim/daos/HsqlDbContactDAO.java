package ch.hszt.mdp.pim.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.hszt.mdp.pim.daofactories.HsqlDbDAOFactory;
import ch.hszt.mdp.pim.db.SqlStatements;
import ch.hszt.mdp.pim.exceptions.DataAccessException;
import ch.hszt.mdp.pim.models.Contact;

/**
 * 
 * @author Ramy Hasan
 *
 */
public class HsqlDbContactDAO implements IContactDAO {
	
	@Override
	public Contact loadContactById(long id) throws DataAccessException {
		Contact c = new Contact();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = HsqlDbDAOFactory.openConnection().createStatement();
			rs = st.executeQuery(SqlStatements.loadContactById(id));
			st.close();
			
			//save data in contact object c
			c.setGroup(rs.getNString("cGroup"));
			c.setFirstName(rs.getNString("cFirstName"));
			c.setLastName(rs.getNString("cLastName"));
			c.setBirthDate(rs.getDate("cBirthday"));
			c.setEmail(rs.getNString("cEmail"));
			c.setUrl(rs.getNString("cUrl"));
			c.setTelephone(rs.getNString("cTel"));
			c.setJob(rs.getNString("cJob"));
			c.getAddress().setStreet(rs.getNString("cAddStreet"));
			c.getAddress().setHouseNumber(rs.getNString("cAddStreetNo"));
			c.getAddress().setPostalCode(rs.getNString("cAddZip"));
			c.getAddress().setPlace(rs.getNString("cAddCity"));
			c.getAddress().setCountry(rs.getNString("cAddCountry"));
			c.setComment(rs.getNString("cNotes"));			
		} catch (Exception e) {
			throw new DataAccessException();
		}		
		return c;
	}

	@Override
	public List<Contact> loadAllContacts() throws DataAccessException {
		List<Contact> contactList = new ArrayList<Contact>();
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = HsqlDbDAOFactory.openConnection().createStatement();
			rs = st.executeQuery(SqlStatements.loadAllContacts());
			st.close();
			
			for (; rs.next();) {
				Contact c = new Contact();
				
				//save data in contact object c
				c.setGroup(rs.getNString("cGroup"));
				c.setFirstName(rs.getNString("cFirstName"));
				c.setLastName(rs.getNString("cLastName"));
				c.setBirthDate(rs.getDate("cBirthday"));
				c.setEmail(rs.getNString("cEmail"));
				c.setUrl(rs.getNString("cUrl"));
				c.setTelephone(rs.getNString("cTel"));
				c.setJob(rs.getNString("cJob"));
				c.getAddress().setStreet(rs.getNString("cAddStreet"));
				c.getAddress().setHouseNumber(rs.getNString("cAddStreetNo"));
				c.getAddress().setPostalCode(rs.getNString("cAddZip"));
				c.getAddress().setPlace(rs.getNString("cAddCity"));
				c.getAddress().setCountry(rs.getNString("cAddCountry"));
				c.setComment(rs.getNString("cNotes"));
				
				//add object to list
				contactList.add(c);
			}			
		} catch (Exception e) {
			throw new DataAccessException();
		}
		return contactList;
	}

	@Override
	public int insertContact(Contact contact) throws DataAccessException {
		int retCodeSt = 0;
		try {
			Statement st = HsqlDbDAOFactory.openConnection().createStatement();
			retCodeSt    = st.executeUpdate(SqlStatements.insertContact(contact));
			st.close();
		} catch (Exception e) {
			throw new DataAccessException();
		}
		return retCodeSt;
	}

	@Override
	public int insertContacts(List<Contact> contacts)
			throws DataAccessException {
		
		int retCodeSt = 0;		
		try {
			for ( int i=0 ; i < contacts.size() ; i++ ) {
				Statement st = HsqlDbDAOFactory.openConnection().createStatement();
				retCodeSt    = st.executeUpdate(SqlStatements.insertContact(contacts.get(i)));
				st.close();
				//falls fehler auftreten soll die for-schleife abgebrochen werden
				if(retCodeSt == -1) {
					break;
				}
			}
		} catch (Exception e) {
			throw new DataAccessException();
		}
		
		return retCodeSt;
	}

	@Override
	public boolean updateContact(Contact contact) throws DataAccessException {
		int retCodeSt = 0;
		try {
			Statement st = HsqlDbDAOFactory.openConnection().createStatement();
			retCodeSt    = st.executeUpdate(SqlStatements.updateContact(contact));
			st.close();
		} catch (Exception e) {
			throw new DataAccessException();
		}
		
		if(retCodeSt == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void updateContacts(List<Contact> contacts)
			throws DataAccessException {
		try {
			for ( int i=0 ; i < contacts.size() ; i++ ) {
				Statement st = HsqlDbDAOFactory.openConnection().createStatement();
				st.executeUpdate(SqlStatements.updateContact(contacts.get(i)));
				st.close();
			}
		} catch (Exception e) {
			throw new DataAccessException();
		}
	}

	@Override
	public boolean deleteContact(Contact contact) throws DataAccessException {
		int retCodeSt = 0;
		try {
			Statement st = HsqlDbDAOFactory.openConnection().createStatement();
			retCodeSt    = st.executeUpdate(SqlStatements.deleteContact(contact));
			st.close();
		} catch (Exception e) {
			throw new DataAccessException();
		}
		
		if(retCodeSt == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteContacts(List<Contact> contacts)
			throws DataAccessException {
		int retCodeSt = 0;		
		try {
			for ( int i=0 ; i < contacts.size() ; i++ ) {
				Statement st = HsqlDbDAOFactory.openConnection().createStatement();
				retCodeSt    = st.executeUpdate(SqlStatements.deleteContact(contacts.get(i)));
				st.close();
				//falls fehler auftreten soll die for-schleife abgebrochen werden
				if(retCodeSt == -1) {
					break;
				}
			}
		} catch (Exception e) {
			throw new DataAccessException();
		}
		
		if(retCodeSt == 0) {
			return false;
		}
		return true;
	}

}
