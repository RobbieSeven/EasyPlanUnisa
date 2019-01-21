package test.amministratore;

import static org.junit.Assert.assertEquals;

import model.amministratore.AmministratoreBean;
import model.amministratore.AmministratoreBeanDao;

import org.junit.Test;

public class TestAmministratoreBeanDao {

  String username = "admin";

  AmministratoreBean ab = new AmministratoreBean("admin", "admin");
  AmministratoreBeanDao amd = new AmministratoreBeanDao();

  @Test
  public void testdoRetriveByKey() {

    assertEquals(ab.toString(), amd.doRetrieveByKey(username).toString());
  }
}
