package test.gruppo.esami.opzionali;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.gruppo.esami.GruppoEsamiOpzionaliBeanDao;



public class TestGruppoOpzionaleBeanDaodoRetriveGruppoEsamiOpzByOfferta {

  private String anno = "2018/19";
  private int laurea = 1;
  private String curricula = "Curriculum Standard";

  private GruppoEsamiOpzionaliBeanDao gopzDao = new GruppoEsamiOpzionaliBeanDao();

  @Test
  public void testDoRetriveGruppoEsamiOpzByOfferta() throws Exception {

    assertEquals(1, gopzDao.doRetriveGruppoEsamiOpzByOfferta(anno, laurea, curricula).size());
  }
}
