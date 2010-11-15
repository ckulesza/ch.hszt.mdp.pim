package ch.hszt.mdp.pim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatementTest {

	@Test
	public void testGetStatement() {
		assertEquals("Statement", "Konsole ist Mist!!!",
				Statement.getStatement("Mist"));
	}

}
