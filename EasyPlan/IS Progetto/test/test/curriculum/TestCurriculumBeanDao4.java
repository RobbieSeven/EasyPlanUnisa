package test.curriculum;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import model.curriculum.CurriculumBeanDao;
import org.junit.Test;



public class TestCurriculumBeanDao4 {

  String anno = "2018/19";
  int laurea = 2;
  CurriculumBeanDao cbd = new CurriculumBeanDao();
  int size = 5;

  @Test
  public void testdoRetriveByCorsoDiLaureaOffertaFormativa() {

    try {
      assertEquals(size, (cbd.doRetriveByCorsoDiLaureaOffertaFormativa(laurea, anno)).size());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
