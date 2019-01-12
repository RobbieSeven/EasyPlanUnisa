package test.offertaformativa;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import model.offerta.formativa.OffertaFormativaBeanDao;

public class TestOffertaFormativaDao3 {
  int size = 2;
  OffertaFormativaBeanDao ofd = new OffertaFormativaBeanDao();

  @Test
  public void testdoRetriveByAll() {

    try {
      assertEquals(size, (ofd.doRetriveByAll()).size());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
