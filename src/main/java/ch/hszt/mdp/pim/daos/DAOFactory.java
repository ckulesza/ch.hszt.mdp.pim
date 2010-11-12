/**
 * 
 */
package ch.hszt.mdp.pim.daos;

import java.io.File;

/**
 * @author Christof Kulesza
 * 
 */
public abstract class DAOFactory {

	private static Class<?>[] classes = { SerializeDAOFactory.class };
	private static DAOFactory[] daoFactories = new DAOFactory[classes.length];

	// List of DAO types supported by the factory
	public static final int SERIALIZE = 0;
	public static final int HSQLDB = 1;

	static {
		try {
			for (int i = 0; i < classes.length; i++) {
				daoFactories[i] = (DAOFactory) classes[i].newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// There will be a method for each DAO that can be
	// created. The concrete factories will have to
	// implement these methods.
	public abstract IContactDAO getCustomerDAO();

	public abstract String getName();

	public abstract String getDescription();

	public static DAOFactory getDAOFactory(int id) {
		return daoFactories[id];
	}

	public static void setSerializeFile(File file) {
		SerializeDAOFactory.setContactFile(file);
	}

	public static String[] getDescriptions() {
		String[] descriptions = new String[daoFactories.length];
		for (int i = 0; i < daoFactories.length; i++) {
			descriptions[i] = daoFactories[i].getDescription();
		}
		return descriptions;
	}

	public static String[] getNames() {
		String[] names = new String[daoFactories.length];
		for (int i = 0; i < daoFactories.length; i++) {
			names[i] = daoFactories[i].getName();
		}
		return names;
	}
	
	public static String[][] getNamesAnDescriptions() {
		String[][] namesAndDescriptions = new String[daoFactories.length][2];
		for (int i = 0; i < daoFactories.length; i++) {
			namesAndDescriptions[i][0] = daoFactories[i].getName();
			namesAndDescriptions[i][1] = daoFactories[i].getDescription();
		}
		return namesAndDescriptions;
	}
}