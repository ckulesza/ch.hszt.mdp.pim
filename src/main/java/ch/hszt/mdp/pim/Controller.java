/**
 * 
 */
package ch.hszt.mdp.pim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.hszt.mdp.pim.daos.SerializeContactDAO;
import ch.hszt.mdp.pim.models.Contact;
import ch.hszt.mdp.pim.view.GuiMain;

/**
 * @author Miroslav
 *
 */
public class Controller implements ActionListener{
	
	private List<Contact> contacts = new ArrayList<Contact>();
	private GuiMain view = new GuiMain();
	private SerializeContactDAO serial = new SerializeContactDAO();
	

	
	public static void main(String[] args) {
		

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
	public boolean validateEmail(String s){
			boolean isEMailAddressOK = true;
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+\\.+[1,4]");
			Matcher m = p.matcher(s);

			if (!m.matches()) {
				isEMailAddressOK = false;
				System.out.println("EMail adresse ist ungueltig. Sie enhaelt kein @ oder keine Domainname.\n"+
						"Beispiel: hansMuster@dingdong.com Email Adresse Fehler");
			}
			return isEMailAddressOK;
	}
	
	

}