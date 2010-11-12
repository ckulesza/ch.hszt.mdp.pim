/**
 * 
 */
package ch.hszt.mdp.pim.daos;

import java.io.File;

/**
 * @author Christof Kulesza
 * 
 */
public class SerializeDAOFactory extends DAOFactory {

	private static File contactFile;

	@Override
	public IContactDAO getCustomerDAO() {
		return new SerializeContactDAO();
	}

	/**
	 * @return the file
	 */
	public static File getContactFile() {
		return contactFile;
	}

	/**
	 * @param contactFile
	 *            the file to set
	 */
	public static void setContactFile(File contactFile) {
		SerializeDAOFactory.contactFile = contactFile;
	}

	@Override
	public String getName() {
		return "Serialize";
	}

	@Override
	public String getDescription() {
		return "Saves all data in a file.";
	}
}