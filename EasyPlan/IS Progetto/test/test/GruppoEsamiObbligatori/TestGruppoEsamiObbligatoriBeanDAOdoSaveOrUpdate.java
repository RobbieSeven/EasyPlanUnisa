package test.GruppoEsamiObbligatori;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.GruppoEsamiObbligatoriBean;
import model.GruppoEsamiObbligatoriBeanDAO;

public class TestGruppoEsamiObbligatoriBeanDAOdoSaveOrUpdate {
	GruppoEsamiObbligatoriBean gruppo = new GruppoEsamiObbligatoriBean(18, 3,1, null);
	GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
	
	@Test
	public void testDoSaveOrUpdate() throws IOException {
		assertEquals(true,dao.doSaveOrUpdate(gruppo));
	}
}
