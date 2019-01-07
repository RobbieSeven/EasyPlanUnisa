package testing.Curriculum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
  TestCurriculumBeanDAO1.class,
  TestCurriculumBeanDAO2.class,
  TestCurriculumBeanDAO3.class,
  TestCurriculumBeanDAO4.class,
  TestCurriculumBeanDAO5.class
})

public class JUnitTestSuiteCurriculum {}
