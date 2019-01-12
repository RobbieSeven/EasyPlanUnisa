package test.gruppo.esami.obbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao;

public class TestGruppoEsamiObbligatoriBeanDaodoSaveOrUpdate {
  GruppoEsamiObbligatoriBean gruppo = new GruppoEsamiObbligatoriBean(18, 3, 1, null);
  GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();

  @Test
  public void testDoSaveOrUpdate() throws IOException {
    assertEquals(true, dao.doSaveOrUpdate(gruppo));
  }
}
