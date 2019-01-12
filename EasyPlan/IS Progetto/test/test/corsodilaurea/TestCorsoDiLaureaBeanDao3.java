package test.corsodilaurea;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.corso.di.laurea.CorsoDiLaureaBeanDao;

public class TestCorsoDiLaureaBeanDao3 {
  CorsoDiLaureaBeanDao cld = new CorsoDiLaureaBeanDao();
  String anno = "2018/19";
  int size = 2;

  @Test
  public void testgetCorsiDiLaureaOfferta() {

    assertEquals(size, (cld.getCorsiLaureaOfferta(anno)).size());
  }

}
