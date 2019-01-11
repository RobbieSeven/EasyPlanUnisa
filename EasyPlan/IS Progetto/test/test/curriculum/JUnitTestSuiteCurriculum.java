package test.curriculum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ TestCurriculumBeanDao1.class, TestCurriculumBeanDao2.class, 
    TestCurriculumBeanDao3.class,
    TestCurriculumBeanDao4.class, TestCurriculumBeanDao5.class })

public class JUnitTestSuiteCurriculum {
}
