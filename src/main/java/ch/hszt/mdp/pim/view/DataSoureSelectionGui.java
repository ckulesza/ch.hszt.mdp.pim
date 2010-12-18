package ch.hszt.mdp.pim.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DataSoureSelectionGui extends JDialog {
	

	private JPanel panel = new JPanel();
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	private ArrayList<JRadioButton> rbList = new ArrayList<JRadioButton>();
	private static final Color color = new Color(240, 240, 240);
	private static final boolean resizeFrame = false;
	private static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private static final Dimension framesize = new Dimension(100,200 );
	private String selectedSource;
	
	/**
	 * overwrited constructor which need an String array 
	 * in the array is on first column the surce and in the 
	 * second column the text for the tooltip
	 * @param sa
	 */
	public DataSoureSelectionGui(String[][] sa) {
		setupGui(sa);
	}
	
	/**
	 * setup the window to select the data source
	 * @param sArray
	 */
	private void setupGui(final String[][] sArray) {
		
		panel.setLayout(new GridBagLayout());
		for (int i = 0; i < sArray.length; i++) {
			JPanel smallPanel = new JPanel();
			
			String name = sArray[i][0];
			rbList.add(new JRadioButton(name));
			rbList.get(i).setName(name);

			smallPanel.setLayout(new GridBagLayout());
			addcomponents1(panel, smallPanel, 1, i, 1, 1);
			addcomponents1(smallPanel, rbList.get(i), 1, i, 1, 1);
			
			rbList.get(i).setHorizontalAlignment(SwingConstants.LEADING);
			final int j =i;
			rbList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedSource = rbList.get(j).getName();
					setSelectedFunction(j, selectedSource);
				}
			});


			rbList.get(i).setToolTipText(sArray[i][1]);
		}


		addcomponents1(panel, okButton, 1, rbList.size()+1, 0, 0);
		addcomponents1(panel, cancelButton, 1, rbList.size()+2, 0, 0);


		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSelectedFunction();
				setVisible(false);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		
		

		getContentPane().add(panel);
		setSize(framesize);
		setResizable(resizeFrame);
		setTitle("Data Transmission selection");
		setBackground(color);
		setLocation(((d.width - getSize().width)/2), ((d.height - getSize().height)/2));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);	
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
	 * setRadioButton which is pressed to enable and disable all other Radiobuttons
	 * in this way it's not possible to select more that one radiobutton as true.
	 * @param i
	 */
	public void setSelectedFunction(int i, String s) {
		for (int j = 0; j < rbList.size(); j++) {
			rbList.get(j).setSelected(false);
		}
		rbList.get(i).setSelected(true);
		this.selectedSource = s;
	}
	
	/**
	 * return the selcted string
	 * @return
	 */
	public void getSelectedFunction() {
		System.out.println(selectedSource);
	}
}
