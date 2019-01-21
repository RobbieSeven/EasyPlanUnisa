package test.gruppo.esami.opzionali;

import static org.junit.Assert.assertEquals;

import model.gruppo.esami.GruppoEsamiOpzionaliBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBeanDao;
import org.junit.Test;





public class TestGruppoOpzionaleBeanDaoDoSaveorUpdate {

  private GruppoEsamiOpzionaliBean gopz = new GruppoEsamiOpzionaliBean(121, 1, 26, 2, null);
  private GruppoEsamiOpzionaliBeanDao gopzDao = new GruppoEsamiOpzionaliBeanDao();

  @Test
  public void testDoSaveOrUpdate() throws Exception {

    assertEquals(true, gopzDao.doSaveOrUpdate(gopz));
  }
}
