package ch.hszt.mdp.pim.exceptions;

import org.junit.Test;

public class DataAccessExceptionTest {

	@Test
	public void testDataAccessExceptionInitialize() {
		@SuppressWarnings("unused")
		DataAccessException dae = new DataAccessException();
		dae = new DataAccessException("");
		dae = new DataAccessException(new Throwable());
		dae = new DataAccessException("", new Throwable());
	}

}
