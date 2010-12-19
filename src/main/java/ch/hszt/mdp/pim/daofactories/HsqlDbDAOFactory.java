package ch.hszt.mdp.pim.daofactories;

import ch.hszt.mdp.pim.daos.IContactDAO;

/**
 * 
 * @author Ramy Hasan
 *
 */

public class HsqlDbDAOFactory extends DAOFactory {
	
	public HsqlDbDAOFactory() {}

	@Override
	public IContactDAO getCustomerDAO() {
		return null;
	}

	@Override
	public String getName() {
		return "HSQLDB";
	}

	@Override
	public String getDescription() {
		return "Eine Java basierte relationale Datanbank";
	}

}
