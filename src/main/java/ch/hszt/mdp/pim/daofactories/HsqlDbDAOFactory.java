package ch.hszt.mdp.pim.daofactories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch.hszt.mdp.pim.daos.HsqlDbIContactDAO;
import ch.hszt.mdp.pim.daos.IContactDAO;

/**
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
	
	/**
	 * Die Methode wird nur fuer SELECT-Statement verwendet. Sie nimmt ein
	 * SQL-Statement entgegen Und gibt einen ResultSet zurueck
	 * 
	 * @param expression
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static ResultSet query(String expression) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = openConnection().createStatement();
			rs = st.executeQuery(expression); // query ausfuehren
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Diese Methode wird fuer folgende Statements verwendet: - CREATE - DROP -
	 * INSERT - UPDATE Sie nimmt ein SQL-Statement entgegen und hat keinen
	 * Return-Wert
	 * 
	 * @param expression
	 * @throws SQLException
	 */
	public static void update(String expression){
		Statement st;
		try {
			st = openConnection().createStatement();
			st.executeUpdate(expression); // query ausfuehren
			st.close();
		} catch (SQLException e) {
			System.out.println("Falsche Datenbank-Abfrage: " + expression);
			e.printStackTrace();
		}
	}

	@Override
	public IContactDAO getCustomerDAO() {
		return new HsqlDbIContactDAO();
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
