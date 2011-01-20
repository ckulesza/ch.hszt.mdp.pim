/**
 * 
 */
package ch.hszt.mdp.pim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.hszt.mdp.pim.daos.IContactDAO;
import ch.hszt.mdp.pim.daos.SerializeContactDAO;
import ch.hszt.mdp.pim.models.Contact;
import ch.hszt.mdp.pim.view.GuiMain;

/**
 * @author Miroslav Mirkovic
 * 
 *
 */
public class Controller implements ActionListener{
	
	private List<Contact> contacts = new ArrayList<Contact>();
	private IContactDAO serial = new SerializeContactDAO();
	

	/*
	 * Die Main-Methode, die alles notwendige instanziert und auf
	 * Benutzereingaben reagiert. Der Link zwischen dem View und dem Model
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// GridGUIModel model=new GridGUIModel();
		GuiMain view = new GuiMain();
		GuiController control = new GuiController(view);
		IContactDAO serial = new SerializeContactDAO();
		control.view.getEmailTextField();
	}

	/*
	 * Die actionPerformed Methode wird auf die Eingaben im View reagieren.
	 */
	public void actionPerformed(ActionEvent arg) {
		
		
	}
	/* 
	 * Die Methode setCurrentContact wird den momentan angewählten Kontakt im 
	 * Ansichtsfenster anzeigen lassen.
	 */
	public void setCurrentContact(){
		
	}

	/* 
	 * Die Methode setSelectedContact wird den momentan angewählten Kontakt im 
	 * Ansichtsfenster anzeigen lassen.
	 */
	public void setSelectedContact(){
		
	}
	
	/*
	 * Die validateEmail Methode wird die Eingaben im Emailfeld des views validieren
	 */
	public static boolean validateEmail(String s){
			boolean isEMailAddressOK = true;
			Pattern p = Pattern.compile("[a-zA-Z1-9]{1,}(.|_)?[a-zA-Z1-9]{2,}@[a-zA-Z1-9-]{2,}.[a-zA-Z]{2,5}");
			Matcher m = p.matcher(s);

			if (!m.matches()) {
				isEMailAddressOK = false;
				System.out.println("EMail adresse ist ungueltig. Sie enthaelt kein @ oder keinen Domainnamen.\n"+
						"Beispiel: hansMuster@dingdong.com Email Adresse Fehler");
			}
			return isEMailAddressOK;
	}
	
	/*
	 * Die validateText
	 * 	
	*/
	public static boolean validateText(String s){
		boolean isTextfieldOK = true;
		Pattern p = Pattern.compile("[a-zA-Z1-9]*");
		Matcher m = p.matcher(s);

		if (!m.matches()) {
			isTextfieldOK = false;
			System.out.println("Text enthaelt unzulaessige Zeichen!!!");
		}
		return isTextfieldOK;
	}
	
	

}