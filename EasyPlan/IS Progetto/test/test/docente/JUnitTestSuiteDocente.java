package test.docente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ TestDocenteBeanDao1.class, TestDocenteBeanDao2.class, 
    TestDocenteBeanDao3.class,
    TestDocenteBeanDao4.class, TestDocenteBeanDao5.class })
public class JUnitTestSuiteDocente {

}
