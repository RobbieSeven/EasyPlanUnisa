package test.esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.esame.EsameBeanDao;



public class TestEsameBeanDaodoDelete {

  private int codice = 120;
  private EsameBeanDao esameDao = new EsameBeanDao();

  @Test
  public void testdoDelete() {
    try {
      assertEquals(true, esameDao.doDelete(codice));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
