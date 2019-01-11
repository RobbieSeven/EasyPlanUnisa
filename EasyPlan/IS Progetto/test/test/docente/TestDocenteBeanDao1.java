package test.docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.DocenteBean;
import model.DocenteBeanDao;
import org.junit.Test;

public class TestDocenteBeanDao1 {

  DocenteBean docente = new DocenteBean(4321, "Antonio", "Rossi", "Sito", "Matematica");
  DocenteBeanDao dd = new DocenteBeanDao();

  @Test
  public void testdoSave() {

    try {
      assertEquals(1, dd.doSave(docente, 12));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
