package test.esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.esame.EsameBean;
import model.esame.EsameBeanDao;

public class TestEsameBeanDaodoSaveOrUpdate {

  private EsameBean esame = new EsameBean(120, "JO-JO", 12, "Za warudo", 78, "primo");
  private EsameBeanDao esameDao = new EsameBeanDao();

  @Test
  public void testdoSaveOrUpdate() {
    try {
      assertEquals(true, esameDao.doSaveOrUpdate(esame));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
