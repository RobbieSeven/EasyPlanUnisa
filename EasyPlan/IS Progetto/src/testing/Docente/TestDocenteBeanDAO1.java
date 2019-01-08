package testing.Docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.DocenteBean;
import model.DocenteBeanDAO;



public class TestDocenteBeanDAO1 {

	DocenteBean d= new DocenteBean(4321,"Antonio","Rossi","Sito","Matematica");
	DocenteBeanDAO dd= new DocenteBeanDAO();
	
	@Test
	public void testdoSave() {
		
		try {
			assertEquals(1,dd.doSave(d,12));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
