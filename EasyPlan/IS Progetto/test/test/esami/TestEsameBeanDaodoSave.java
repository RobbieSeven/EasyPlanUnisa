package test.esami;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.esame.EsameBean;
import model.esame.EsameBeanDao;
import org.junit.Test;



public class TestEsameBeanDaodoSave {

  private EsameBean esame = new EsameBean(120, "The promised neverland",
      12, "è un easter-egg", 78, "primo");
  private EsameBeanDao esameDao = new EsameBeanDao();

  @Test
  public void testdoSave() {
    try {
      assertEquals(esame.getCodiceEsame(), esameDao.doSave(esame));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
