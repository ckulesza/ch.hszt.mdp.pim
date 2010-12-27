package ch.hszt.mdp.pim.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class HsqlDbIContactDAO implements IContactDAO {
	
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
			c.setStreet(rs.getNString("cAddStreet"));
			c.setStreetNo(rs.getNString("cAddStreetNo"));
			c.setZip(rs.getNString("cAddZip"));
			c.setCity(rs.getNString("cAddCity"));
			c.setCountry(rs.getNString("cAddCountry"));
			c.setComment(rs.getNString("cNotes"));			
			
		} catch (SQLException e) {
			e.printStackTrace();
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
				c.setStreet(rs.getNString("cAddStreet"));
				c.setStreetNo(rs.getNString("cAddStreetNo"));
				c.setZip(rs.getNString("cAddZip"));
				c.setCity(rs.getNString("cAddCity"));
				c.setCountry(rs.getNString("cAddCountry"));
				c.setComment(rs.getNString("cNotes"));
				
				//add object to list
				contactList.add(c);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;
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
