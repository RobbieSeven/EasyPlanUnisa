package test.gruppo.esami.opzionali;

import static org.junit.Assert.assertEquals;

import model.gruppo.esami.GruppoEsamiOpzionaliBeanDao;
import org.junit.Test;





public class TestGruppoOpzionaleBeanDaodoRetriveGruppoEsamiOpzByOffertaAndAnno {

  private String offertaForm = "2018/19";
  private int laurea = 1;
  private String curricula = "Curriculum Standard";
  private int anno = 3;

  private GruppoEsamiOpzionaliBeanDao gopzDao = new GruppoEsamiOpzionaliBeanDao();

  @Test
  public void testDoRetriveGruppoEsamiOpzByOffertaAndAnno() throws Exception {

    assertEquals(1, gopzDao.doRetriveGruppoEsamiOpzByOffertaAndAnno(
        offertaForm, laurea, curricula, anno).size());
  }
}
