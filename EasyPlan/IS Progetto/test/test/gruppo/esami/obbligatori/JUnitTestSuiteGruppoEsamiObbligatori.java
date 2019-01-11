package test.gruppo.esami.obbligatori;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestGruppoEsamiObbligatoriBeanDaodoSave.class,
    TestGruppoEsamiObbligatoriBeanDaodoSaveOrUpdate.class,
    TestGruppoEsamiObbligatoriBeanDaodoDelete.class,
    TestGruppoEsamiObbligatoriBeanDaodoRetriveGruppoEsamiObbByOfferta.class,
    TestGruppoEsamiObbligatoriBeanDaodoRetriveGruppoEsamiObbligatoriByOffertaAndAnno.class
})

public class JUnitTestSuiteGruppoEsamiObbligatori {}
