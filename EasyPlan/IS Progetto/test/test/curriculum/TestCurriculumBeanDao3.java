package test.curriculum;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import model.curriculum.CurriculumBeanDao;



public class TestCurriculumBeanDao3 {

  int size = 6;
  CurriculumBeanDao cbd = new CurriculumBeanDao();

  @Test
  public void testdoRetriveByAll() {

    try {
      assertEquals(size, (cbd.doRetriveByAll()).size());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
