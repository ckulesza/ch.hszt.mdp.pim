package ch.hszt.mdp.pim.daofactories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ch.hszt.mdp.pim.daos.HsqlDbContactDAO;
import ch.hszt.mdp.pim.daos.IContactDAO;

/**
 * Diese Klasse ist für die Verbindung der HSQLDB zuständig. Und bietet
 * Methoden für die Info-Abfragen an.
 * Hier wird das Singleton implementiert.
 * 
 * @author Ramy Hasan
 *
 */

public class HsqlDbDAOFactory extends DAOFactory {
	private static Connection conn; // presistente Db-Verbindung aufbauen
	
	public HsqlDbDAOFactory() {}
	
	/**
	 * Eine Verbindung zu HSQLDB aufbauen
	 * Die Methode verwendet den Singleton Pattern. Die Variable conn wird nur
	 * einmal instanziiert
	 * @return
	 */
	public static Connection openConnection() {
		if (conn == null) {
			try {
				// Laden der JDBC der HsqlDb Treiber
				Class.forName("org.hsqldb.jdbcDriver");
				
				// Verbindung zur Datei aufbauen.
				conn = DriverManager.getConnection("jdbc:hsqldb:" + "pimdb", // Dateiname
						"sa", // Db Benutzername
						""); // Db Passwort
			} catch (Exception e) {
				System.out.println("Fehler: Die Treiber fuer HsqlDB "
						+ "konnten nicht geladen werden!");
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/**
	 * Die Verbindung schliessen
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		Statement st = openConnection().createStatement();
		st.execute("SHUTDOWN");
		openConnection().close();
	}
	
	@Override
	public IContactDAO getCustomerDAO() {
		return new HsqlDbContactDAO();
	}

	@Override
	public String getName() {
		return "HSQLDB";
	}

	@Override
	public String getDescription() {
		return "HyperSQL ist eine freie vollständig in Java programmierte relationale SQL-Datenbank (RDBMS)";
	}

}
