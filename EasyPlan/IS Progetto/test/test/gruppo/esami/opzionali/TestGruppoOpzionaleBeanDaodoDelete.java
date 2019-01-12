package test.gruppo.esami.opzionali;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBeanDao;



public class TestGruppoOpzionaleBeanDaodoDelete {

  private int codice = 121;

  private GruppoEsamiOpzionaliBeanDao gopzDao = new GruppoEsamiOpzionaliBeanDao();

  @Test
  public void testDoDelete() throws Exception {

    assertEquals(true, gopzDao.doDelete(codice));
  }
}
