package test.docente;

import static org.junit.Assert.assertEquals;

import model.docente.DocenteBeanDao;
import org.junit.Test;





public class TestDocenteBeanDao5 {
  DocenteBeanDao dd = new DocenteBeanDao();
  String anno = "2018/19";
  int laurea = 1;
  String curricula = "Curriculum Standard";
  int grOp = 1;
  String nome = "Sicurezza";
  int size = 1;

  @Test
  public void testdoRetrieveDocEsameOpz() {

    assertEquals(size, (dd.doRetrieveDocEsameOpz(anno, laurea, curricula, grOp, nome)).size());
  }

}
