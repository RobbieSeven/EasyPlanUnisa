package test.Docente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.DocenteBeanDAO;

public class TestDocenteBeanDAO5 {
	DocenteBeanDAO dd= new DocenteBeanDAO();
	String anno="2018/19";
	int laurea=1;
	String curricula="Curriculum Standard";
	int grOp=1;
	String nome="Sicurezza";
	int size=1;
	@Test
	public void testdoRetrieveDocEsameOpz() {
	
		assertEquals(size,(dd.doRetrieveDocEsameOpz(anno,laurea,curricula,grOp,nome)).size());
	}

}
