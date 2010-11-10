package ch.hszt.mdp.pim;

import junit.framework.TestCase;

public class StatementTest extends TestCase {

	public void testGetStatement() {
		assertEquals("Statement", "Konsole ist Mist!!!",
				Statement.getStatement("Mist"));
	}

}
