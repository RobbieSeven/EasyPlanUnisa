package test.curriculum;

import static org.junit.Assert.assertEquals;

import model.CurriculumBeanDao;

import org.junit.Test;

public class TestCurriculumBeanDao5 {

  CurriculumBeanDao cbd = new CurriculumBeanDao();
  int confronto = 7;

  @Test
  public void testdoRetriveByIdMaggiore() {

    assertEquals(confronto, cbd.doRetrieveByIdMaggiore());

  }
}
