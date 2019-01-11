package test.esami;

import static org.junit.Assert.assertEquals;

import model.EsameBeanDao;
import org.junit.Test;



public class TestEsameBeanDaodoRetriveByKey {

  private int codice = 120;
  private EsameBeanDao esameDao = new EsameBeanDao();

  @Test
  public void testdoRetrieveByKey() {
    assertEquals(codice, esameDao.doRetrieveByKey(120).getCodiceEsame());
  }
}
