package test.docente;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.docente.DocenteBean;
import model.docente.DocenteBeanDao;
import org.junit.Test;

public class TestDocenteBeanDao2 {
  DocenteBean docente = new DocenteBean(4321, "Antonio", "Verdi", "Sito2", "Matematica");
  DocenteBeanDao dd = new DocenteBeanDao();

  @Test
  public void testdoSaveOrUpdate() {

    try {
      dd.doSaveOrUpdate(docente, 12);
      assertEquals("Antonio", (dd.doRetrieveByKey(4321)).getNome());
      assertEquals("Verdi", (dd.doRetrieveByKey(4321)).getCognome());
      assertEquals("Sito2", (dd.doRetrieveByKey(4321)).getIndirizzoPaginaWeb());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
