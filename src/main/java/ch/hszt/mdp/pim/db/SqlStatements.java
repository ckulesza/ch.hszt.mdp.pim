package ch.hszt.mdp.pim.db;

import ch.hszt.mdp.pim.models.Contact;

public class SqlStatements {
	
	public SqlStatements() {}
	
	public static String loadContactById(long id) {
		return "SELECT * FROM contacts WHERE cId = " + id;
	}
	
	public static String loadAllContacts() {
		return "SELECT * FROM contacts";
	}
	
	public static String insertContact(Contact c) {
		return "INSERT INTO contacts(cGroup, cFirstName, cLastName" +
				", cBirthday, cEmail, cUrl, cTel, cJob, cAddStreet" +
				", cAddStreetNo, cAddZip, cAddCity, cAddCountry, cNotes) " +
				
				" VALUES( '" + c.getGroup() + "'" +
						",'" + c.getFirstName() + "'" +
						",'" + c.getLastName() + "'" +
						",'" + c.getBirthDate() + "'" +
						",'" + c.getEmail() + "'" +
						",'" + c.getUrl() + "'" +
						",'" + c.getTelephone() + "'" +
						",'" + c.getJob() + "'" +
						",'" + c.getAddress().getStreet()+ "'" +
						",'" + c.getAddress().getHouseNumber() + "'" +
						",'" + c.getAddress().getPostalCode() + "'" +
						",'" + c.getAddress().getPlace() + "'" +
						",'" + c.getAddress().getCountry() + "'" +
						",'" + c.getComment() + "' ) ";
	}
	
	public static String updateContact(Contact c) {
		return "UPDATE contacts " +
				"SET cGroup = '" + c.getGroup() + "'" +
						", cFirstName = '" + c.getFirstName() + "'" +
						", cLastName = '" + c.getLastName() + "'" +
						", cBirthday = '" + c.getBirthDate() + "'" +
						", cEmail = '" + c.getEmail() + "'" +
						", cUrl = '" + c.getUrl() + "'" +
						", cTel = '" + c.getTelephone() + "'" +
						", cJob = '" + c.getJob() + "'" +
						", cAddStreet = '" + c.getAddress().getStreet() + "'" +
						", cAddStreetNo = '" + c.getAddress().getHouseNumber() + "'" +
						", cAddZip = '" + c.getAddress().getPostalCode() + "'" +
						", cAddCity = '" + c.getAddress().getPlace() + "'" +
						", cAddCountry = '" + c.getAddress().getCountry() + "'" +
						", cNotes = '" + c.getComment() + "'" +
				"WHERE cId = " + c.getId();
	}
	
	public static String deleteContact(Contact c) {
		return "DELETE FROM contacts WHERE cId = " + c.getId();
	}
}
