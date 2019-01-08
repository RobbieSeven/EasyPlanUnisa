package testing.Docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.DocenteBean;
import model.DocenteBeanDAO;

public class TestDocenteBeanDAO2 {
	DocenteBean d= new DocenteBean(4321,"Antonio","Verdi","Sito2","Matematica");
	DocenteBeanDAO dd= new DocenteBeanDAO();
	
	@Test
	public void testdoSaveOrUpdate() {
		
		try {
			dd.doSaveOrUpdate(d, 12);
			assertEquals("Antonio",(dd.doRetrieveByKey(4321)).getNome());
			assertEquals("Verdi",(dd.doRetrieveByKey(4321)).getCognome());
			assertEquals("Sito2",(dd.doRetrieveByKey(4321)).getIndirizzoPaginaWeb());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
