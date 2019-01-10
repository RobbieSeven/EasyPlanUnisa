package test.GruppoEsamiObbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.GruppoEsamiObbligatoriBeanDAO;

public class TestGruppoEsamiObbligatoriBeanDAOdoDelete {

	int idGruppo = 18;
	GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
	
	@Test
	public void testDoDelete() throws IOException {
		assertEquals(true,dao.doDelete(idGruppo));
	}
}
