package test.Esami;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
  TestEsameBeanDAOdoSave.class,
  TestEsameBeanDAOdoSaveOrUpdate.class,
  TestEsameBeanDAOdoRetriveByKey.class,
  TestEsameBeanDAOdoRetriveEsamiOffertaFormativaObb.class,
  TestEsameBeanDAOdoRetriveEsamiOffertaFormativaOpz.class,
  TestEsameBeanDAOdoRetrieveLastID.class,
  TestEsameBeanDAOdoDelete.class
})

public class JUnitTestSuiteEsame {}
