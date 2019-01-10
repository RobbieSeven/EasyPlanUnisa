package test.GruppoEsamiOpzionali;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDAO;

public class TestGruppoOpzionaleBeanDAOdoRetriveGruppoEsamiOpzByOfferta {
	
	private String anno="2018/19";
	private int laurea=1;
	private String curricula="Curriculum Standard";
	
	private GruppoEsamiOpzionaliBeanDAO gopzDao= new GruppoEsamiOpzionaliBeanDAO ();
	
	@Test
	public void testDoRetriveGruppoEsamiOpzByOfferta() throws Exception {
		
		assertEquals(1,gopzDao.doRetriveGruppoEsamiOpzByOfferta(anno, laurea, curricula).size());
	}
}
