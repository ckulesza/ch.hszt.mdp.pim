/**
 * 
 */
package ch.hszt.mdp.pim.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Christof Kulesza
 * ja der Christof war's
 * so ist es
 * noch ein Versuch
 */
public class AddressTest {

	@Test
	public void testAdressInitialize() {
		@SuppressWarnings("unused")
		Address adress = new Address();
	}

	@Test
	public void testGetterAndSetter() {
		Address address = new Address();
		address.setHouseNumber("22a");
		address.setPlace("Place");
		address.setPostalCode("PostalCode");
		address.setStreet("Street");
		assertEquals("HouseNumber", "22a", address.getHouseNumber());
		assertEquals("Place", "Place", address.getPlace());
		assertEquals("PostalCode", "PostalCode", address.getPostalCode());
		assertEquals("Street", "Street", address.getStreet());
	}

}
