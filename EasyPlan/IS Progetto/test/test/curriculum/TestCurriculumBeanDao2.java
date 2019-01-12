package test.curriculum;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.curriculum.CurriculumBeanDao;


public class TestCurriculumBeanDao2 {

  CurriculumBeanDao cbd = new CurriculumBeanDao();
  int idCurriculum = 100;

  @Test
  public void testdoDelete() {

    try {
      assertEquals(true, cbd.doDelete(idCurriculum));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
