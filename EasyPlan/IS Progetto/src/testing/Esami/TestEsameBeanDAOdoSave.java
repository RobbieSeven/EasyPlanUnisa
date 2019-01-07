package testing.Esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.EsameBean;
import model.EsameBeanDAO;

public class TestEsameBeanDAOdoSave {

	private EsameBean esame= new EsameBean(120,"The promised neverland",12,"è un easter-egg",78,"primo");
	private EsameBeanDAO esameDAO= new EsameBeanDAO();
	
	@Test
	public void testdoSave() {
		try {
			assertEquals(esame.getCodiceEsame(),esameDAO.doSave(esame));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
