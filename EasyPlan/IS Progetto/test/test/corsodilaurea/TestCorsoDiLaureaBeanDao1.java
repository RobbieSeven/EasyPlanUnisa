package test.corsodilaurea;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.corso.di.laurea.CorsoDiLaureaBean;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;

public class TestCorsoDiLaureaBeanDao1 {
  CorsoDiLaureaBean cl = new CorsoDiLaureaBean(17, 2, "2018/19", null);
  CorsoDiLaureaBeanDao cld = new CorsoDiLaureaBeanDao();

  @Test
  public void testdoSave() {

    try {
      assertEquals(17, cld.doSave(cl));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      cld.doDelete(17);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
