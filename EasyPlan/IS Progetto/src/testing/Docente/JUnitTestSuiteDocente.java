package testing.Docente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)

@Suite.SuiteClasses({
  TestDocenteBeanDAO1.class,
  TestDocenteBeanDAO2.class,
  TestDocenteBeanDAO3.class,
  TestDocenteBeanDAO4.class,
  TestDocenteBeanDAO5.class
})
public class JUnitTestSuiteDocente {

}
