package ch.hszt.mdp.pim.db;

import ch.hszt.mdp.pim.models.Contact;

/**
 * Diese Klasse kann nur statisch aufgerufen werden.
 * Sie ist zuständing fürs herstellen der SQL-Strings.
 * 
 * @author Ramy Hasan
 *
 */
public class SqlStatements {
	
	public SqlStatements() {}
	
	/**
	 * Diese Mehtode erstellt Ein SQL-String für die Abfrage
	 * Eines Kontakts
	 * 
	 * @param id des Kontakts
	 * @return SQL-String
	 */
	public static String loadContactById(long id) {
		return "SELECT * FROM contacts WHERE cId = " + id;
	}
	
	/**
	 * Diese Mehtode erstellt Ein SQL-String für die Abfrage
	 * für alle Kontakte
	 * 
	 * @return SQL-String
	 */
	public static String loadAllContacts() {
		return "SELECT * FROM contacts";
	}
	
	/**
	 * Diese Mehtode erstellt Ein SQL-String fürs Einfügen
	 * eines Kontakts
	 * 
	 * @param c Contact Object
	 * @return SQL-String
	 */
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
	
	/**
	 * Diese Mehtode erstellt Ein SQL-String fürs Updaten
	 * eines Kontakts
	 * 
	 * @param c Contact Object
	 * @return SQL-String
	 */
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
	
	/**
	 * Diese Mehtode erstellt Ein SQL-String fürs Löschen
	 * eines Objektes
	 * 
	 * @param c Contact Object
	 * @return SQL-String
	 */
	public static String deleteContact(Contact c) {
		return "DELETE FROM contacts WHERE cId = " + c.getId();
	}
}
