package test.docente;

import static org.junit.Assert.assertEquals;

import model.DocenteBeanDao;
import org.junit.Test;

public class TestDocenteBeanDao4 {
  DocenteBeanDao dd = new DocenteBeanDao();
  String anno = "2018/19";
  int laurea = 1;
  String curricula = "Curriculum Standard";
  int grOb = 1;
  String nome = "Matematica Discreta";
  int size = 3;

  @Test
  public void testdoRetrieveDocEsameObb() {

    assertEquals(size, (dd.doRetrieveDocEsameObb(anno, laurea, curricula, grOb, nome)).size());
  }

}
