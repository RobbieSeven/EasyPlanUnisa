package test.Esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.EsameBeanDAO;

public class TestEsameBeanDAOdoDelete {

	private int codice = 120;
	private EsameBeanDAO esameDAO= new EsameBeanDAO();
	
	@Test
	public void testdoDelete() {
		try {
			assertEquals(true,esameDAO.doDelete(codice));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
