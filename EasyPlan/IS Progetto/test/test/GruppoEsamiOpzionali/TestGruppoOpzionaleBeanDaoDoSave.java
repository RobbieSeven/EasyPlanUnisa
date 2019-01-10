package test.GruppoEsamiOpzionali;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDAO;

public class TestGruppoOpzionaleBeanDaoDoSave {

	private GruppoEsamiOpzionaliBean gopz= new GruppoEsamiOpzionaliBean(121,1,25,2,null);
	private GruppoEsamiOpzionaliBeanDAO gopzDao= new GruppoEsamiOpzionaliBeanDAO ();
	
	
	@Test
	public void testDoSave() throws Exception {
		assertEquals(2,gopzDao.doSave(gopz));
	}
}
