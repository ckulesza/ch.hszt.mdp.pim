/**
 * 
 */
package ch.hszt.mdp.pim.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import org.junit.Test;

/**
 * @author Christof Kulesza
 * 
 */
public class ContactTest {

	@Test
	public void testGetterAndSetter() {
		Contact contact = new Contact();
		contact.setId(1);
		contact.setLastName("Last name");
		contact.setFirstName("First name");
		Date date = new Date();
		contact.setBirthDate(date);
		contact.setUrl("URL");
		contact.setTelephone("Telephone");
		contact.setJob("Job");
		contact.setEmail("Email");
		contact.setComment("Comment");
		Address address = new Address();
		contact.setAddress(address);		
		assertEquals("Id", 1, contact.getId());
		assertEquals("Last name", "Last name", contact.getLastName());
		assertEquals("First name", "First name", contact.getFirstName());
		assertEquals("Birth date", date, contact.getBirthDate());
		assertEquals("URL", "URL", contact.getUrl());
		assertEquals("Telephone", "Telephone", contact.getTelephone());
		assertEquals("Job", "Job", contact.getJob());
		assertEquals("Email", "Email", contact.getEmail());
		assertEquals("Comment", "Comment", contact.getComment());
		assertEquals("Address", address, contact.getAddress());
	}

	@Test
	public void testAddAndRemovePropertyChangeListener() {
		Contact contact = new Contact();
		PropertyChangeListener listener = new PropertyChangeListener() {

			int counter = 0;

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (counter > 0) {
					fail("The listener wasn't removed.");
				}
				counter++;
			}
		};
		contact.addPropertyChangeListener("id", listener);
		contact.setId(2);
		contact.removePropertyChangeListener(listener);
		contact.setId(3);
	}

	@Test
	public void testPropertyChange() {
		fail();
	}

}
