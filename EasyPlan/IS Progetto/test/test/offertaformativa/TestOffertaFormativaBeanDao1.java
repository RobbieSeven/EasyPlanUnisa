package test.offertaformativa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.offerta.formativa.OffertaFormativaBean;
import model.offerta.formativa.OffertaFormativaBeanDao;
import org.junit.Test;

public class TestOffertaFormativaBeanDao1 {
  OffertaFormativaBean of = new OffertaFormativaBean("2022/23", null, true);
  OffertaFormativaBeanDao ofd = new OffertaFormativaBeanDao();

  @Test
  public void testdoSave() {

    try {
      assertEquals(1, ofd.doSave(of));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
