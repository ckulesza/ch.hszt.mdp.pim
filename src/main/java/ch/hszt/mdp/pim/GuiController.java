package ch.hszt.mdp.pim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ch.hszt.mdp.pim.daofactories.DAOFactory;
import ch.hszt.mdp.pim.daos.IContactDAO;
import ch.hszt.mdp.pim.exceptions.DataAccessException;
import ch.hszt.mdp.pim.models.Address;
import ch.hszt.mdp.pim.models.Contact;
import ch.hszt.mdp.pim.view.GuiMain;

/**
 * @author Marcel Nemeth Achtung! Model ist noch nicht implementiert. Habe das
 *         Model deswegen auskommentiert.
 * 
 */
public class GuiController implements ActionListener {

	// GUIModel model; // TODO Model implementieren
	GuiMain view;

	public GuiController(GuiMain view)// ,GridGUIModel model)
	{
		// this.model=model;
		this.view = view;
		view.getAddressTextField().addActionListener(this);
		view.getCancelContactButton().addActionListener(this);
		view.getCityTextField().addActionListener(this);
		view.getCountryTextField().addActionListener(this);
		view.getDateofirthTextField().addActionListener(this);
		view.getEditContactButton().addActionListener(this);
		view.getEmailTextField().addActionListener(this);
		view.getExitButton().addActionListener(this);
		view.getFirstnameTextField().addActionListener(this);
		view.getGroupTextField().addActionListener(this);
		view.getJobTextField().addActionListener(this);
		view.getLastnameTextField().addActionListener(this);
		view.getNewContactButton().addActionListener(this);
		view.getPhonenumberTextField().addActionListener(this);
		view.getSaveContactButton().addActionListener(this);
		view.getStreetnoTextField().addActionListener(this);
		view.getStreetTextField().addActionListener(this);
		view.getUrlTextField().addActionListener(this);
		view.getZipTextField().addActionListener(this);
	}

	private void saveContact(Contact contact) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HSQLDB);
		IContactDAO dao = factory.getCustomerDAO();
		try {
			dao.insertContact(contact);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<Contact> loadContacts() {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HSQLDB);
		IContactDAO dao = factory.getCustomerDAO();
		try {
			List<Contact> list = dao.loadAllContacts();
			return list;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		if (action == "Exit") {
			System.exit(0);
		}
		if (action == "Save") {
			view.setButtonsOnSave();
			Contact contact = new Contact();
			contact.setFirstName(view.getFirstnameTextField().getText());
			contact.setAddress(new Address());
			saveContact(contact);
			fillList(loadContacts());
		}
		if (action == "Cancel") {
			view.setButtonsOnCancel();
		}
		if (action == "Edit") {
			view.setButtonsOnEdit();
		}
		if (action == "New Contact") {
			view.setButtonsOnNew();
		}
		if (action == "About PIM") {
			view.showInfo();
		}
		if (action == "Select Data Source") {

		}
		if (action == "About") {
		}
	}

	private void fillList(List<Contact> contacts) {
		for (int i = 0; i < contacts.size(); i++) {
			view.getLm().addElement(contacts.get(i).getFirstName());
			view.getList().setModel(view.getLm());
		}
	}

	/*
	 * // Only for test purposes public static void main(String[] args) { //
	 * GridGUIModel model=new GridGUIModel(); GuiMain view = new GuiMain();
	 * GuiController controller = new GuiController(view); }
	 */
}
