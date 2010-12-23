
package ch.hszt.mdp.pim;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTest {
	
	private Controller control = new Controller();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testNewInstance(){
		assertEquals(control, control);
	}
	
	@Test
	public void testsetCurrentContact(){
		control.setCurrentContact();
	}
	
	@Test
	public void testsetSelectedContact(){
		control.setSelectedContact();
	}

}
