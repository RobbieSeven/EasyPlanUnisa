package test.Docente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import model.DocenteBeanDAO;



public class TestDocenteBeanDAO4 {
	DocenteBeanDAO dd= new DocenteBeanDAO();
	String anno="2018/19";
	int laurea=1;
	String curricula="Curriculum Standard";
	int grOb=1;
	String nome="Matematica Discreta";
	int size=3;
	@Test
	public void testdoRetrieveDocEsameObb() {
	
		assertEquals(size,(dd.doRetrieveDocEsameObb(anno,laurea,curricula,grOb,nome)).size());
	}

}
