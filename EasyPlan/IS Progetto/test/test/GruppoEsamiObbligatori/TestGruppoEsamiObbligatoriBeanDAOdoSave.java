package test.GruppoEsamiObbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.GruppoEsamiObbligatoriBean;
import model.GruppoEsamiObbligatoriBeanDAO;

public class TestGruppoEsamiObbligatoriBeanDAOdoSave {

	GruppoEsamiObbligatoriBean gruppo = new GruppoEsamiObbligatoriBean(18, 2, 2, null);
	GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
	
	@Test
	public void testDoSave() throws IOException {
		assertEquals(2,dao.doSave(gruppo));
	}
}
