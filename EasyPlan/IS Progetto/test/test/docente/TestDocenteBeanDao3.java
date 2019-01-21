package test.docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import model.docente.DocenteBeanDao;
import org.junit.Test;


public class TestDocenteBeanDao3 {
  DocenteBeanDao dd = new DocenteBeanDao();

  @Test
  public void testdoDelete() {

    try {
      assertEquals(true, dd.doDelete(4321));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
