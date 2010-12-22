package ch.hszt.mdp.pim.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.hszt.mdp.pim.models.Address;
import ch.hszt.mdp.pim.models.Contact;

public class GuiMain {
	/**
	 * This variables are only for first tests
	 */
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Contact c1 = new Contact();
	private Contact c2 = new Contact();
	private Contact c3 = new Contact();
	private Contact c4 = new Contact();
	private Contact c5 = new Contact();
	private JTextArea ta = new JTextArea(3,20);
	private Address address;

	/**
	 * This are all variables for the mainGui
	 * 	 */
	private static final String VERSION = "0.1.4-19.12.2010";
	private static final boolean resizeFrame = true;
	private static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private static final Color font_color = Color.BLUE;
	private static final Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	private static final Border border = BorderFactory.createEtchedBorder();
	private static final Dimension framesize = new Dimension(700,500 );
	private static final Color color = new Color(240, 240, 240);
	private final JButton exitButton = new JButton("Exit");
	private final JButton saveContactButton = new JButton("Save");
	private final JButton cancelContactButton = new JButton("Cancel");
	private final JButton editContactButton = new JButton("Edit");
	private final JButton newContactButton = new JButton("New Contact");
	private final String[][] dataSource = new String[4][2];

	private JFrame frame = new JFrame("PIM-Viewer "+VERSION);

	private String[] s = new String[]{"Gruppe", "Vorname", "Name", "Geburtsdatum", 
									  "eMail", "URL", "Telefonnr.", 
									  "Job", 
									  "Adresse"};
	private JTextField[] tf = new JTextField[s.length];
	
	private String[] adressString = new String[] {"Strasse" , 
												  "Nr.", 
												  "ZIP",
												  "Stadt",
												  "Land"};
	private JTextField[] addressFields = new JTextField[adressString.length];
	
	private Contact editPerson = new Contact();
	private int listIndex;

	/**
	 * String Array used for temporary setup the data Source selection
	 */
	private void setupStringArray() {
		this.dataSource[0][0] = "net";
		this.dataSource[0][1] =  "ToolTip Text for net- selection. This is only for test";
		this.dataSource[1][0] = "file";
		this.dataSource[1][1] = "tool Tip Text file- selection. This is only for test";
		this.dataSource[2][0] = "stream";
		this.dataSource[2][1] = "tool Tip Text stream- selection. This is only for test";
		this.dataSource[3][0] = "WiFi";
		this.dataSource[3][1] = "tool Tip Text WiFi- selection. This is only for test";
	}

	/**
	 * this constructor is only required for test
	 */
	public GuiMain() {
		setSomePerson();
		setupStringArray();
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

		leftPanel.setBorder(BorderFactory.createTitledBorder(border, "Contacts", 0, 0, boldFont, font_color));
		rightPanel.setBorder(BorderFactory.createTitledBorder(border, "Person", 0, 0, boldFont, font_color));

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		saveContactButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				saveData(editPerson ,listIndex);
				disableTextFields();
				cancelContactButton.setEnabled(false);
				editContactButton.setEnabled(true);
				newContactButton.setEnabled(true);
			}
		});

		editContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableTextFields();
				changeData();
				cancelContactButton.setEnabled(true);
				newContactButton.setEnabled(false);
				saveContactButton.setEnabled(true);
			}
		});

		cancelContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editPerson.getFirstName() != null) {
					disableTextFields();
					setData(editPerson);
				}
				newContactButton.setEnabled(true);
				saveContactButton.setEnabled(false);
				cancelContactButton.setEnabled(false);
			}
		});

		newContactButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				enableTextFields();
				addNewPerson();
				newContactButton.setEnabled(false);
				editContactButton.setEnabled(false);
				saveContactButton.setEnabled(true);
				cancelContactButton.setEnabled(true);
			}
		});

		panel.setLayout(new GridLayout(0,2));
		leftPanel.setLayout(new GridBagLayout());
		rightPanel.setLayout(new GridBagLayout());
		leftLowerPanel.setLayout(new GridBagLayout());
		rightUpperPanel.setLayout(new GridBagLayout());
		rightLowerPanel.setLayout(new GridBagLayout());

		addcomponents1(panel, leftPanel, 	0, 0, 0, 0);
		addcomponents1(panel, rightPanel,  	0, 0, 0, 0);

		addcomponents1(leftPanel, createList(), 	0, 0, 1, 0);
		addcomponents1(leftPanel, leftLowerPanel,   0, 1, 1, 0);
		
		
		addcomponents1(rightPanel, setAllPanels(), 0, 0, 0, 1);
		addcomponents1(rightPanel, rightLowerPanel, 0, 1, 0, 1);

		addcomponents1(leftLowerPanel, exitButton, 0, 0, 0, 0);

		addcomponents1(rightLowerPanel, newContactButton, 		0, 0, 0, 0);
		addcomponents1(rightLowerPanel, editContactButton, 		1, 0, 0, 0);
		addcomponents1(rightLowerPanel, saveContactButton,		2, 0, 0, 0);
		addcomponents1(rightLowerPanel, cancelContactButton, 	3, 0, 0, 0);

		createMenu(frame);

		frame.setSize(framesize);
		frame.setResizable(resizeFrame);
		frame.getContentPane().add(panel);
		frame.setBackground(color);
		frame.setLocation(((d.width - frame.getSize().width)/2), ((d.height - frame.getSize().height)/2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

	/**
	 * Method which set up the list
	 * @return
	 */
	private JScrollPane createList() {
		final JList list;
		final DefaultListModel lm = new DefaultListModel();

		Iterator<Contact> iter = contacts.iterator();
		while (iter.hasNext()) {
			lm.addElement(iter.next());
		}
		list = new JList(lm);

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(0);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(100, 200));


		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				editContactButton.setEnabled(true);
				editPerson = (Contact) list.getSelectedValue();
				lm.getElementAt(list.getSelectedIndex());
				listIndex = list.getSelectedIndex();
				setData(list.getSelectedValue());				
			}
		});
		return listScroller;
	}

	/**
	 * method which gets an object<PERSON>
	 * setup the TextField with data from
	 */
	public void setData(Object o) {
		editPerson = (Contact) o;

		tf[0].setText(editPerson.getGroup());
		tf[1].setText(editPerson.getFirstName());
		tf[2].setText(editPerson.getLastName());
		tf[3].setText(editPerson.getBirthDate().toString());
		tf[4].setText(editPerson.getEmail());
		tf[5].setText(editPerson.getUrl());
		tf[6].setText(editPerson.getTelephone());
		tf[7].setText(editPerson.getJob());

		addressFields[0].setText(editPerson.getAddress().getStreet());
		addressFields[1].setText(editPerson.getAddress().getHouseNumber());
		addressFields[2].setText(editPerson.getAddress().getPostalCode());
		addressFields[3].setText(editPerson.getAddress().getPlace());
		addressFields[4].setText(editPerson.getAddress().getCountry());
		
		disableTextFields();
	}

	/**
	 * Change all info in view
	 * @param o
	 */
	private void changeData() {
		for (int i = 0; i < tf.length-1; i++) {
			tf[i].setText(tf[i].getText());
		}

		for (int i = 0; i < addressFields.length; i++) {
			addressFields[i].setText(addressFields[i].getText());
		}
	}

	/**
	 * save all info to the Person Object
	 * @param o
	 */
	private void saveData(Object o, int i) {
		editPerson = (Contact) o;
		editPerson.getAddress();
		listIndex = contacts.indexOf(editPerson);
		editPerson.setGroup(tf[0].getText());
		editPerson.setFirstName(tf[1].getText());
		editPerson.setLastName(tf[2].getText());
		// Geburtsdatum fehlt noch editPerson.setUrl(tf[3].getText());
		
		if (!(validateEmailAdress(tf[4].getText()))) {
			editPerson.setEmail(editPerson.getEmail());			
		}
		else
		{
			editPerson.setEmail(tf[4].getText());
		}
		editPerson.setUrl(tf[5].getText());
		editPerson.setTelephone(tf[6].getText());
		editPerson.setJob(tf[7].getText());

		address.setStreet(addressFields[0].getText());
		address.setHouseNumber(addressFields[0].getText());
		address.setPostalCode(addressFields[2].getText());
		address.setPlace(addressFields[3].getText());
		address.setCountry(addressFields[4].getText());
		editPerson.setAddress(address);
		
		contacts.remove(listIndex);
		contacts.add(i, editPerson);
	}

	/**
	 * Method to add new Person
	 */
	private void addNewPerson() {
		Contact newPerson = new Contact();
		this.listIndex = contacts.size();
		if (contacts.get(listIndex-1).getFirstName().equals("") && 
				contacts.get(listIndex).getLastName().equals("")) {
			contacts.add(listIndex-1, newPerson);
		}
		else {
			contacts.add(newPerson);
		}
		if (tf[1].getText() != null) {
			for (int i = 0; i < tf.length; i++) {
				tf[i].setText("");
			}
		}
		saveData(newPerson, listIndex);
	}

	/**
	 * Method to setup the window menu
	 * @param fenster
	 */
	public void createMenu(JFrame fenster)
	{
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		JMenuBar menuezeile = new JMenuBar();
		fenster.setJMenuBar(menuezeile);

		JMenu menu;
		JMenuItem entry;


		menu = new JMenu("File");
		menuezeile.add(menu);
		entry = new JMenuItem("Exit");
		entry.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
		entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				exit();
			}
		}
		);
		menu.add(entry);

		entry = new JMenuItem("Select Data Source");
		entry.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
		entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				@SuppressWarnings("unused")
				DataSoureSelectionGui ds = new DataSoureSelectionGui(dataSource);
			}
		});
		menu.add(entry);

		menu = new JMenu("Help");
		menuezeile.add(menu);

		entry = new JMenuItem("About PIM");
		entry.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
		entry.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 
				showInfo();
			}
		}
		);
		menu.add(entry);
	}

	/**
	 * Exit the application
	 */
	private void exit()
	{
		System.exit(0);
	}

	/**
	 * pop up an message with failure information
	 * @param failureInformation
	 * @param failureMessage
	 */
	private void showFailure(String failureInformation, String failureMessage) {
		JOptionPane.showMessageDialog(frame,
				failureInformation,
				failureMessage,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Info: Shows information about this application
	 */
	private void showInfo()
	{
		JOptionPane.showMessageDialog(frame,
				"PIM Editor Version: " + VERSION+"\nEditors:\n" +
				"- Christof Kulesza\n" +
				"- Egon Pfammatter\n" + 
				"- Marcel Nemeth\n" +
				"- Miroslav Mirkovic\n" + 
				"- Ramy Hasan\n",
				"Info about PIM", 
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Method to add components to panels
	 */
	private void addcomponents1(JPanel panel, Component comp, int x, int y, int witdhx, int witdhy) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.weightx = witdhx;
		gbc.weighty = witdhy;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(comp, gbc);
	}

	/**
	 * Method to add labels to panels
	 */
	private void addJlables(JPanel panel, JLabel label, String value, Font font, int x, int y, int witdhx) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.weightx = witdhx;

		gbc.fill = GridBagConstraints.BOTH;
		label.setText(value);
		label.setFont(font);
		panel.add(label, gbc);
	}

	/**
	 * Set textFields to edit mode
	 */
	private void enableTextFields() {
		for (int i = 0; i < tf.length-1; i++) {
			tf[i].setEditable(true);
		}
		for (int i = 0; i < addressFields.length; i++) {
			addressFields[i].setEditable(true);
		}
		ta.setEditable(true);
	}

	/**
	 * unset textFields to edit mode
	 */
	private void disableTextFields() {
		for (int i = 0; i < tf.length-1; i++) {
			tf[i].setEditable(false);
		}
		for (int i = 0; i < addressFields.length; i++) {
			addressFields[i].setEditable(false);
		}
		
		ta.setEditable(false);
	}

	/**
	 * Validate if the entered eMailadress is in the correct format
	 * @param s
	 */
	public boolean validateEmailAdress(String s) {
		boolean isEMailAddressOK = true;
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(s);

		if (!m.matches()) {
			isEMailAddressOK = false;
			showFailure("EMail adresse ist ungueltig. Sie enhaelt kein @ oder keine Domainname.\n"+
					"Beispiel: hansMuster@dingdong.com",
			"Email Adresse Fehler");
		}
		return isEMailAddressOK;
	}

	/**
	 * This method is only for test to setup some person objects.
	 * and add them to the arrylist
	 */
	public void setSomePerson() {
		
		Calendar datum1 = Calendar.getInstance();
		datum1.set(1000, 1, 19);
		c1.setBirthDate(datum1.getTime());
		c1.setFirstName("Dracula");
		c1.setLastName("Graf");
		c1.setEmail("Dracula@transsilvanien.ro");
		c1.setJob("Vampir");
		c1.setTelephone("123 456 789 0");
		c1.setId(1232342342);
		c1.setUrl("http://Blutbank.transsilvanien.ro");
		c1.setGroup("Person");
		address = new Address();
		c1.setAddress(address);
		address.setStreet("Burgstrasse");
		address.setHouseNumber("222");
		address.setPostalCode("345345");
		address.setPlace("Transilvaninen");
		address.setCountry("Ungarn");
		
		Calendar datum2 = Calendar.getInstance();
		datum2.set(1105, 11, 24);
		c2.setBirthDate(datum2.getTime());
		c2.setFirstName("Aschenputzel");
		c2.setLastName("Kanllfrosch");
		c2.setEmail("Aschenputzel");
		c2.setTelephone("123 123 123 123 123");
		c2.setUrl("http://IchHabGenugKoernerPickt.net");
		c2.setJob("Dienstmaedchen");
		c2.setGroup("Person");
		address = new Address();
		c2.setAddress(address);
		address.setStreet("altes Haus");
		address.setHouseNumber("190");
		address.setPostalCode("10e42");
		address.setPlace("Nirwana");
		address.setCountry("Maerchenland");

		Calendar datum3 = Calendar.getInstance();
		datum3.set(1921, 01, 31);
		c3.setBirthDate(datum3.getTime());
		c3.setFirstName("Raeuber");
		c3.setLastName("HosenPlatz");
		c3.setEmail("HosenPlatz@Raeuberhoele.rb");
		c3.setTelephone("666 666 666 666");
		c3.setUrl("http://HierHabIchEtwasGestohlen.har");
		c3.setJob("Raeuber ... steht doch in meinen Namen!");
		c3.setGroup("Person");
		address = new Address();
		c3.setAddress(address);
		address.setStreet("Raeuberhoehle");
		address.setHouseNumber("12c");
		address.setPostalCode("120c2");
		address.setPlace("Schlumpfhausen");
		address.setCountry("Wald");

		Calendar datum4 = Calendar.getInstance();
		datum4.set(901, 10, 1);
		c4.setBirthDate(datum4.getTime());
		c4.setFirstName("Rapunzel");
		c4.setLastName("Auf der Lauer");
		c4.setEmail("Rapunzel@soLassDeinHaarHerunter.yy");
		c4.setTelephone("111 111 111 111");
		c4.setUrl("http://HohlMichHier.weg");
		c4.setJob("Turmwaerterin ... hihi");
		c4.setGroup("Person");
		address = new Address();
		c4.setAddress(address);
		address.setStreet("Turm auf dem Land");
		address.setHouseNumber("1A2");
		address.setPostalCode("212331");
		address.setPlace("Bibiland");
		address.setCountry("Nirgendwo");
		
		Calendar datum5 = Calendar.getInstance();
		datum5.set(1001, 05, 30);
		c5.setBirthDate(datum5.getTime());
		c5.setFirstName("Kater");
		c5.setLastName("Der gestiefelte");
		c5.setEmail("Kater@maerchenland.cx");
		c5.setTelephone("324 534 234");
		c5.setUrl("http://Kater.maerchenland.cx");
		c5.setJob("Vagabund");
		c5.setGroup("Tier");
		address = new Address();
		c5.setAddress(address);
		address.setStreet("Am Wegerand");
		address.setHouseNumber("00a");
		address.setPostalCode("6345");
		address.setPlace("Mulhausen");
		address.setCountry("blah");

		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
		contacts.add(c5);
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		GuiMain gui = new GuiMain();
		gui.createWindow();
	}

	/**
	 * Add all labels and textfields to one panel and 
	 * @return JPanel as back for further action.
	 */
	public JPanel setAllPanels() {
		JPanel panel = new JPanel();
		JPanel contatPanel = new JPanel();
		JPanel jobPanel = new JPanel();
		JPanel addressPanel = new JPanel();
		JPanel notePanel = new JPanel();
		
		contatPanel.setBorder(BorderFactory.createTitledBorder(border, "Contact", 0, 0, boldFont, font_color));
		jobPanel.setBorder(BorderFactory.createTitledBorder(border, "Job", 0, 0, boldFont, font_color));
		addressPanel.setBorder(BorderFactory.createTitledBorder(border, "Addresse", 0, 0, boldFont, font_color));
		notePanel.setBorder(BorderFactory.createTitledBorder(border, "Note", 0, 0, boldFont, font_color));
		
		panel.setLayout(new GridBagLayout());
		contatPanel.setLayout(new GridBagLayout());
		jobPanel.setLayout(new GridBagLayout());
		addressPanel.setLayout(new GridBagLayout());
		notePanel.setLayout(new GridBagLayout());

		// add contact-textields to panel
		for (int i = 0; i < 7; i++) {
			addJlables(contatPanel, new JLabel(), s[i], boldFont, 0, i, 0);
			addcomponents1(contatPanel, tf[i] = new JTextField(), 1, i, 1, 1);
		}
		// add job-textfield to panel
		addcomponents1(jobPanel, tf[7] = new JTextField(), 1, 7, 1, 1);
		
		// add address-textfields for addressinfo to panel
		addJlables(addressPanel, new JLabel(), adressString[0], boldFont, 0, 0, 0);
		addJlables(addressPanel, new JLabel(), adressString[1], boldFont, 2, 0, 0);
		addJlables(addressPanel, new JLabel(), adressString[2], boldFont, 0, 1, 0);
		addJlables(addressPanel, new JLabel(), adressString[3], boldFont, 2, 1, 0);
		addJlables(addressPanel, new JLabel(), adressString[4], boldFont, 0, 2, 0);

		addcomponents1(addressPanel, addressFields[0] = new JTextField(), 1, 0, 5, 1);
		addcomponents1(addressPanel, addressFields[1] = new JTextField(), 3, 0, 0, 1);
		addcomponents1(addressPanel, addressFields[2] = new JTextField(), 1, 1, 0, 1);
		addcomponents1(addressPanel, addressFields[3] = new JTextField(), 3, 1, 5, 1);
		addcomponents1(addressPanel, addressFields[4] = new JTextField(), 1, 2, 5, 1);
		
		// setup the notefiled
		addcomponents1(notePanel, ta, 1, 1, 1, 1);
			
		// add all panels to mainpanel in numberd order
		addcomponents1(panel, contatPanel, 0, 0, 1, 1);
		addcomponents1(panel, jobPanel, 0, 1, 1, 1);
		addcomponents1(panel, addressPanel, 0, 2, 1, 1);
		addcomponents1(panel, notePanel, 0, 3, 1, 1);
		
		return panel;
	}
	
}
