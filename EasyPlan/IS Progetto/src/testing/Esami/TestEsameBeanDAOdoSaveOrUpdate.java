package testing.Esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.EsameBean;
import model.EsameBeanDAO;

public class TestEsameBeanDAOdoSaveOrUpdate {

	private EsameBean esame= new EsameBean(120,"JO-JO",12,"Za warudo",78,"primo");
	private EsameBeanDAO esameDAO= new EsameBeanDAO();
	
	@Test
	public void testdoSaveOrUpdate() {
		try {
			assertEquals(true,esameDAO.doSaveOrUpdate(esame));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
