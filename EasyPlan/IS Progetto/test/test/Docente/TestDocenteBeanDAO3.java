package test.Docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;


import model.DocenteBeanDAO;

public class TestDocenteBeanDAO3 {
	DocenteBeanDAO dd= new DocenteBeanDAO();
	
	@Test
	public void testdoDelete() {
		
		try {
			assertEquals(true,dd.doDelete(4321));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
