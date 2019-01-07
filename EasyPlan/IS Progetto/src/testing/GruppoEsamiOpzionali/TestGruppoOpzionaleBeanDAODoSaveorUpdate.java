package testing.GruppoEsamiOpzionali;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.GruppoEsamiOpzionaliBean;
import model.GruppoEsamiOpzionaliBeanDAO;

public class TestGruppoOpzionaleBeanDAODoSaveorUpdate {
	
	private GruppoEsamiOpzionaliBean gopz= new GruppoEsamiOpzionaliBean(121,1,26,2,null);
	private GruppoEsamiOpzionaliBeanDAO gopzDao= new GruppoEsamiOpzionaliBeanDAO ();
	
	
	@Test
	public void testDoSaveOrUpdate() throws Exception {
		
		assertEquals(true,gopzDao.doSaveOrUpdate(gopz));
	}
}
