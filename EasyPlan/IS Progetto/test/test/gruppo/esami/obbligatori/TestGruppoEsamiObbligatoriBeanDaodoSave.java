package test.gruppo.esami.obbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao;
import org.junit.Test;



public class TestGruppoEsamiObbligatoriBeanDaodoSave {

  GruppoEsamiObbligatoriBean gruppo = new GruppoEsamiObbligatoriBean(18, 2, 2, null);
  GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();

  @Test
  public void testDoSave() throws IOException {
    assertEquals(2, dao.doSave(gruppo));
  }
}
