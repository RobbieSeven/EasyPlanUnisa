package test.offertaformativa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import model.OffertaFormativaBeanDao;
import org.junit.Test;

public class TestOffertaFormativaBeanDao2 {
  OffertaFormativaBeanDao ofd = new OffertaFormativaBeanDao();
  String anno = "2022/23";

  @Test
  public void testdoDelete() {

    try {
      assertEquals(true, ofd.doDelete(anno));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
