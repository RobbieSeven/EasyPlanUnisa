package testing.GruppoEsamiOpzionali;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.GruppoEsamiOpzionaliBeanDAO;

public class TestGruppoOpzionaleBeanDAOdoDelete {
	
	private int codice=121;
	
	private GruppoEsamiOpzionaliBeanDAO gopzDao= new GruppoEsamiOpzionaliBeanDAO ();
	
	@Test
	public void testDoDelete() throws Exception {
		
		assertEquals(true,gopzDao.doDelete(codice));
	}
}
