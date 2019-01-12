package test.curriculum;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.curriculum.CurriculumBean;
import model.curriculum.CurriculumBeanDao;

public class TestCurriculumBeanDao1 {

  CurriculumBean cb = new CurriculumBean("TestCurriculum", 100, 1, null, null);
  CurriculumBeanDao cbd = new CurriculumBeanDao();

  @Test
  public void testdoSave() {

    try {
      assertEquals(1, cbd.doSave(cb));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
