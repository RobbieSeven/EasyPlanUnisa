package testing.GruppoEsamiOpzionali;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
  TestGruppoOpzionaleBeanDaoDoSave.class,
  TestGruppoOpzionaleBeanDAODoSaveorUpdate.class,
  TestGruppoOpzionaleBeanDAOdoDelete.class,
  TestGruppoOpzionaleBeanDAOdoRetriveGruppoEsamiOpzByOfferta.class,
  TestGruppoOpzionaleBeanDAOdoRetriveGruppoEsamiOpzByOffertaAndAnno.class
  
})

public class JUnitTestSuiteGruppoOpzionale {}
