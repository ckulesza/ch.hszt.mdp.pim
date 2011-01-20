package ch.hszt.mdp.pim.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 * @author Egon Pfammatter & Marcel Nemeth
 * 
 */
public class GuiMain {

	/**
	 * This are all variables for the mainGui
	 * */
	private static String VERSION = "0.1.5-14.01.2011";

	
	private JList list;
	private DefaultListModel lm = new DefaultListModel();
	private static boolean resizeFrame = true;
	private static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private static Color font_color = Color.BLUE;
	private static Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	private static Border border = BorderFactory.createEtchedBorder();
	private static Dimension framesize = new Dimension(700, 525);
	private static Color color = new Color(240, 240, 240);
	private JButton exitButton;
	private JButton saveContactButton;
	private JButton cancelContactButton;
	private JButton editContactButton;
	private JButton newContactButton;
	private JTextArea ta;
	private JFrame frame;
	private JTextField groupTextField;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField dateofirthTextField;
	private JTextField emailTextField;
	private JTextField urlTextField;
	private JTextField phonenumberTextField;
	private JTextField jobTextField;
	private JTextField addressTextField;
	private JTextField streetTextField;
	private JTextField streetnoTextField;
	private JTextField zipTextField;
	private JTextField cityTextField;
	private JTextField countryTextField;
	private String[][] dataSource = new String[4][2];

	private String[] s = new String[] { "Gruppe", "Vorname", "Name",
			"Geburtsdatum", "eMail", "URL", "Telefonnr.", "Job", "Adresse" };
	private String[] adressString = new String[] { "Strasse", "Nr.", "ZIP",
			"Stadt", "Land" };
	private JMenu menu = new JMenu("File");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem sourceMenuItem = new JMenuItem("Select Data Source");
	private JMenuItem aboutMenuItem = new JMenuItem("About");
	private JMenuBar menuBar = new JMenuBar();

	/**
	 * this constructor is only required for test
	 * 
	 * @param guiControl
	 */
	public GuiMain() {
		exitButton = new JButton("Exit");
		saveContactButton = new JButton("Save");
		cancelContactButton = new JButton("Cancel");
		editContactButton = new JButton("Edit");
		newContactButton = new JButton("New Contact");
		groupTextField = new JTextField("Gruppe");
		firstnameTextField = new JTextField("Vorname");
		lastnameTextField = new JTextField("Name");
		dateofirthTextField = new JTextField("Geburtstag");
		emailTextField = new JTextField("eMail");
		urlTextField = new JTextField("URL");
		phonenumberTextField = new JTextField("Telefonnr");
		jobTextField = new JTextField("Job");
		addressTextField = new JTextField("Adresse");
		streetTextField = new JTextField("Strasse");
		streetnoTextField = new JTextField("Nr.");
		zipTextField = new JTextField("ZIP");
		cityTextField = new JTextField("Stadt");
		countryTextField = new JTextField("Land");
		ta = new JTextArea(3, 20);
		frame = new JFrame("PIM-Viewer " + VERSION);
		createWindow();
	}

	/**
	 * Method which set up the main gui
	 */
	public void createWindow() {
		JPanel panel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel rightUpperPanel = new JPanel();
		JPanel rightLowerPanel = new JPanel();
		JPanel leftLowerPanel = new JPanel();

		saveContactButton.setEnabled(false);
		editContactButton.setEnabled(false);
		cancelContactButton.setEnabled(false);

		leftPanel.setBorder(BorderFactory.createTitledBorder(border,
				"Contacts", 0, 0, boldFont, font_color));
		rightPanel.setBorder(BorderFactory.createTitledBorder(border, "Person",
				0, 0, boldFont, font_color));

		panel.setLayout(new GridLayout(0, 2));
		leftPanel.setLayout(new GridBagLayout());
		rightPanel.setLayout(new GridBagLayout());
		leftLowerPanel.setLayout(new GridBagLayout());
		rightUpperPanel.setLayout(new GridBagLayout());
		rightLowerPanel.setLayout(new GridBagLayout());

		addcomponents(panel, leftPanel, 0, 0, 0, 0, 0);
		addcomponents(panel, rightPanel, 0, 0, 0, 0, 0);

		addcomponents(leftPanel, createList(), 0, 0, 1, 1, 0);
		addcomponents(leftPanel, leftLowerPanel, 0, 1, 1, 1, 0);

		addcomponents(rightPanel, setAllPanels(), 0, 0, 1, 0, 1);
		addcomponents(rightPanel, rightLowerPanel, 0, 1, 1, 0, 1);

		addcomponents(leftLowerPanel, exitButton, 0, 0, 1, 0, 0);

		addcomponents(rightLowerPanel, newContactButton, 0, 0, 1, 0, 0);
		addcomponents(rightLowerPanel, editContactButton, 1, 0, 1, 0, 0);
		addcomponents(rightLowerPanel, saveContactButton, 2, 0, 1, 0, 0);
		addcomponents(rightLowerPanel, cancelContactButton, 3, 0, 1, 0, 0);

		createMenu(frame);

		frame.setSize(framesize);
		frame.setResizable(resizeFrame);
		frame.getContentPane().add(panel);
		frame.setBackground(color);
		frame.setLocation(((d.width - frame.getSize().width) / 2),
				((d.height - frame.getSize().height) / 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Method which set up the list
	 * 
	 * @return
	 */
	private JScrollPane createList() {
	

		// Iterator<Contact> iter = contacts.iterator();
		// while (iter.hasNext()) {
		// lm.addElement(iter.next());
		// }
		list = new JList(lm);

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(0);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(100, 200));
		return listScroller;
	}

	/**
	 * Method to setup the window menu
	 * 
	 * @param fenster
	 */
	public void createMenu(JFrame fenster) {
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask();
		fenster.setJMenuBar(menuBar);
		menuBar.add(menu);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				SHORTCUT_MASK));
		menu.add(exitMenuItem);
		sourceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				SHORTCUT_MASK));
		sourceMenuItem.setEnabled(false);
		menu.add(sourceMenuItem);
		menu = new JMenu("Help");
		menuBar.add(menu);
		aboutMenuItem = new JMenuItem("About PIM");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				SHORTCUT_MASK));
		menu.add(aboutMenuItem);
	}

	/**
	 * pop up an message with failure information
	 * 
	 * @param failureInformation
	 * @param failureMessage
	 */
	private void showFailure(String failureInformation, String failureMessage) {
		JOptionPane.showMessageDialog(frame, failureInformation,
				failureMessage, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Info: Shows information about this application
	 */
	public void showInfo() {
		JOptionPane.showMessageDialog(frame, "PIM Editor Version: " + VERSION
				+ "\nEditors:\n" + "- Christof Kulesza\n"
				+ "- Egon Pfammatter\n" + "- Marcel Nemeth\n"
				+ "- Miroslav Mirkovic\n" + "- Ramy Hasan\n", "Info about PIM",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Method to add components to panels
	 */
	private void addcomponents(JPanel panel, Component comp, int x, int y,
			int width, double witdhx, double witdhy) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.weightx = witdhx;
		gbc.weighty = witdhy;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(comp, gbc);
	}

	/**
	 * Method to add labels to panels
	 */
	private void addJlables(JPanel panel, JLabel label, String value,
			Font font, int x, int y, int width, double weightx, double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.weightx = weightx;
		gbc.weighty = weighty;

		gbc.fill = GridBagConstraints.BOTH;
		label.setText(value);
		label.setFont(font);
		panel.add(label, gbc);
	}

	/**
	 * Add all labels and textfields to one panel and
	 * 
	 * @return JPanel as back for further action.
	 */
	public JPanel setAllPanels() {
		JPanel panel = new JPanel();
		JPanel contatPanel = new JPanel();
		JPanel jobPanel = new JPanel();
		JPanel addressPanel = new JPanel();
		JPanel notePanel = new JPanel();

		contatPanel.setBorder(BorderFactory.createTitledBorder(border,
				"Contact", 0, 0, boldFont, font_color));
		jobPanel.setBorder(BorderFactory.createTitledBorder(border, "Job", 0,
				0, boldFont, font_color));
		addressPanel.setBorder(BorderFactory.createTitledBorder(border,
				"Addresse", 0, 0, boldFont, font_color));
		notePanel.setBorder(BorderFactory.createTitledBorder(border, "Note", 0,
				0, boldFont, font_color));

		panel.setLayout(new GridBagLayout());
		contatPanel.setLayout(new GridBagLayout());
		jobPanel.setLayout(new GridBagLayout());
		addressPanel.setLayout(new GridBagLayout());
		notePanel.setLayout(new GridBagLayout());

		// add contact-textields to panel

		for (int i = 0; i < 7; i++) {
			addJlables(contatPanel, new JLabel(), s[i], boldFont, 1, i, 1, 0, 1);
		}
		addcomponents(contatPanel, groupTextField, 2, 0, 1, 1, 1);
		addcomponents(contatPanel, firstnameTextField, 2, 1, 1, 1, 1);
		addcomponents(contatPanel, lastnameTextField, 2, 2, 1, 1, 1);
		addcomponents(contatPanel, dateofirthTextField, 2, 3, 1, 1, 1);
		addcomponents(contatPanel, emailTextField, 2, 4, 1, 1, 1);
		addcomponents(contatPanel, urlTextField, 2, 5, 1, 1, 1);
		addcomponents(contatPanel, phonenumberTextField, 2, 6, 1, 1, 1);
		addcomponents(contatPanel, jobTextField, 2, 7, 1, 1, 1);
		addcomponents(contatPanel, addressTextField, 2, 8, 1, 1, 1);

		// add address-textfields for addressinfo to panel
		// x, y, , gridtwidth, witdhx, widthy

		addJlables(addressPanel, new JLabel(), adressString[0], boldFont, 0, 0,
				1, 0.05, 0.5); // street_label
		addcomponents(addressPanel, streetTextField, 1, 0, 3, 100.0, 0.5); // street

		addJlables(addressPanel, new JLabel(), adressString[1], boldFont, 4, 0,
				1, 0.05, 0.5); // streetnumber_label
		addcomponents(addressPanel, streetnoTextField, 5, 0, 1, 5.0, 0.5); // streetnumber

		addJlables(addressPanel, new JLabel(), adressString[2], boldFont, 0, 1,
				1, 0.05, 0.5); // zip_label
		addcomponents(addressPanel, zipTextField, 1, 1, 1, 0.05, 0.5); // zip

		addJlables(addressPanel, new JLabel(), adressString[3], boldFont, 2, 1,
				1, 0.05, 0.5); // city_label
		addcomponents(addressPanel, cityTextField, 3, 1, 3, 100.0, 0.5); // city

		addJlables(addressPanel, new JLabel(), adressString[4], boldFont, 0, 2,
				1, 0.05, 0.5); // country_label
		addcomponents(addressPanel, countryTextField, 1, 2, 1, 100.0, 0.5); // country

		// setup the notefiled
		// JScrollPane sp = new JScrollPane(ta);
		// addcomponents(notePanel, sp, 1, 2, 1, 1, 1);

		// add all panels to mainpanel in numberd order
		addcomponents(panel, contatPanel, 0, 0, 1, 1, 0);
		addcomponents(panel, jobPanel, 0, 1, 1, 1, 0);
		addcomponents(panel, addressPanel, 0, 2, 1, 1, 0);
		addcomponents(panel, notePanel, 0, 3, 1, 1, 0);

		return panel;
	}

	/**
	 * Set textFields to edit mode
	 */
	private void enableTextFields() {
		groupTextField.setEditable(true);
		firstnameTextField.setEditable(true);
		lastnameTextField.setEditable(true);
		dateofirthTextField.setEditable(true);
		emailTextField.setEditable(true);
		urlTextField.setEditable(true);
		phonenumberTextField.setEditable(true);
		jobTextField.setEditable(true);
		addressTextField.setEditable(true);
		streetTextField.setEditable(true);
		streetnoTextField.setEditable(true);
		zipTextField.setEditable(true);
		cityTextField.setEditable(true);
		countryTextField.setEditable(true);
		ta.setEditable(true);
	}

	/**
	 * unset textFields to edit mode
	 */
	private void disableTextFields() {

		groupTextField.setEditable(false);
		firstnameTextField.setEditable(false);
		lastnameTextField.setEditable(false);
		dateofirthTextField.setEditable(false);
		emailTextField.setEditable(false);
		urlTextField.setEditable(false);
		phonenumberTextField.setEditable(false);
		jobTextField.setEditable(false);
		addressTextField.setEditable(false);
		streetTextField.setEditable(false);
		streetnoTextField.setEditable(false);
		zipTextField.setEditable(false);
		cityTextField.setEditable(false);
		countryTextField.setEditable(false);
		ta.setEditable(false);
	}

	/**
	 * Set state of buttons according to chosen function. Some buttons have to
	 * be set Enable/Unable
	 */
	public void setButtonsOnCancel() {
		enableTextFields();

		cancelContactButton.setEnabled(true);
		newContactButton.setEnabled(false);
		saveContactButton.setEnabled(true);
	}

	/**
	 * Set state of buttons according to chosen function. Some buttons have to
	 * be set Enable/Unable
	 */
	public void setButtonsOnSave() {

		disableTextFields();
		cancelContactButton.setEnabled(false);
		editContactButton.setEnabled(true);
		newContactButton.setEnabled(true);
	}

	/**
	 * Set state of buttons according to chosen function. Some buttons have to
	 * be set Enable/Unable
	 */
	public void setButtonsOnNew() {
		enableTextFields();
		cancelContactButton.setEnabled(true);
		newContactButton.setEnabled(false);
		saveContactButton.setEnabled(true);
	}

	/**
	 * Set state of buttons according to chosen function. Some buttons have to
	 * be set Enable/Unable
	 */
	public void setButtonsOnEdit() {
		// if (editPerson.getFirstName() != null) {
		// view.disableTextFields();
		// view.setData(editPerson);
		// }
		enableTextFields();
		newContactButton.setEnabled(true);
		saveContactButton.setEnabled(false);
		cancelContactButton.setEnabled(false);
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JButton getCancelContactButton() {
		return cancelContactButton;
	}

	public void setCancelContactButton(JButton cancelContactButton) {
		this.cancelContactButton = cancelContactButton;
	}

	public JButton getEditContactButton() {
		return editContactButton;
	}

	public void setEditContactButton(JButton editContactButton) {
		this.editContactButton = editContactButton;
	}

	public JButton getSaveContactButton() {
		return saveContactButton;
	}

	public void setSaveContactButton(JButton saveContactButton) {
		this.saveContactButton = saveContactButton;
	}

	public JButton getNewContactButton() {
		return newContactButton;
	}

	public void setNewContactButton(JButton newContactButton) {
		this.newContactButton = newContactButton;
	}

	public JTextField getGroupTextField() {
		return groupTextField;
	}

	public void setGroupTextField(JTextField groupTextField) {
		this.groupTextField = groupTextField;
	}

	public JTextField getFirstnameTextField() {
		return firstnameTextField;
	}

	public void setFirstnameTextField(JTextField firstnameTextField) {
		this.firstnameTextField = firstnameTextField;
	}

	public JTextField getLastnameTextField() {
		return lastnameTextField;
	}

	public void setLastnameTextField(JTextField lastnameTextField) {
		this.lastnameTextField = lastnameTextField;
	}

	public JTextField getDateofirthTextField() {
		return dateofirthTextField;
	}

	public void setDateofirthTextField(JTextField dateofirthTextField) {
		this.dateofirthTextField = dateofirthTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JTextField getUrlTextField() {
		return urlTextField;
	}

	public void setUrlTextField(JTextField urlTextField) {
		this.urlTextField = urlTextField;
	}

	public JTextField getPhonenumberTextField() {
		return phonenumberTextField;
	}

	public void setPhonenumberTextField(JTextField phonenumberTextField) {
		this.phonenumberTextField = phonenumberTextField;
	}

	public JTextField getJobTextField() {
		return jobTextField;
	}

	public void setJobTextField(JTextField jobTextField) {
		this.jobTextField = jobTextField;
	}

	public JTextField getAddressTextField() {
		return addressTextField;
	}

	public void setAddressTextField(JTextField addressTextField) {
		this.addressTextField = addressTextField;
	}

	public JTextField getStreetTextField() {
		return streetTextField;
	}

	public void setStreetTextField(JTextField streetTextField) {
		this.streetTextField = streetTextField;
	}

	public JTextField getStreetnoTextField() {
		return streetnoTextField;
	}

	public void setStreetnoTextField(JTextField streetnoTextField) {
		this.streetnoTextField = streetnoTextField;
	}

	public JTextField getZipTextField() {
		return zipTextField;
	}

	public void setZipTextField(JTextField zipTextField) {
		this.zipTextField = zipTextField;
	}

	public JTextField getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(JTextField cityTextField) {
		this.cityTextField = cityTextField;
	}

	public JTextField getCountryTextField() {
		return countryTextField;
	}

	public void setCountryTextField(JTextField countryTextField) {
		this.countryTextField = countryTextField;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel getLm() {
		return lm;
	}

	public void setLm(DefaultListModel lm) {
		this.lm = lm;
	}

}
