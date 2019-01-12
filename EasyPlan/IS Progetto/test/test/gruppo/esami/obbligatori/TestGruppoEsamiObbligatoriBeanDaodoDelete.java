package test.gruppo.esami.obbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao;

public class TestGruppoEsamiObbligatoriBeanDaodoDelete {

  int idGruppo = 18;
  GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();

  @Test
  public void testDoDelete() throws IOException {
    assertEquals(true, dao.doDelete(idGruppo));
  }
}
