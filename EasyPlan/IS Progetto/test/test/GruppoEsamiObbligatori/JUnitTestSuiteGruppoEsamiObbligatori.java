package test.GruppoEsamiObbligatori;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
  TestGruppoEsamiObbligatoriBeanDAOdoSave.class,
  TestGruppoEsamiObbligatoriBeanDAOdoSaveOrUpdate.class,
  TestGruppoEsamiObbligatoriBeanDAOdoDelete.class,
  TestGruppoEsamiObbligatoriBeanDAOdoRetriveGruppoEsamiObbByOfferta.class,
  TestGruppoEsamiObbligatoriBeanDAOdoRetriveGruppoEsamiObbligatoriByOffertaAndAnno.class
})

public class JUnitTestSuiteGruppoEsamiObbligatori {}
