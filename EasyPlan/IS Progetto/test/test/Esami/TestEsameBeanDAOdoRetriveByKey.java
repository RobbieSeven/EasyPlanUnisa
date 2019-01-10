package test.Esami;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.EsameBeanDAO;

public class TestEsameBeanDAOdoRetriveByKey {

	private int codice = 120;
	private EsameBeanDAO esameDAO= new EsameBeanDAO();
	
	@Test
	public void testdoRetrieveByKey() {
		assertEquals(codice,esameDAO.doRetrieveByKey(120).getCodiceEsame());
	}
}
