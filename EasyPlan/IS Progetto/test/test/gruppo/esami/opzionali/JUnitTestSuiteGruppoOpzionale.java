package test.gruppo.esami.opzionali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestGruppoOpzionaleBeanDaoDoSave.class,
    TestGruppoOpzionaleBeanDaoDoSaveorUpdate.class,
    TestGruppoOpzionaleBeanDaodoDelete.class,
    TestGruppoOpzionaleBeanDaodoRetriveGruppoEsamiOpzByOfferta.class,
    TestGruppoOpzionaleBeanDaodoRetriveGruppoEsamiOpzByOffertaAndAnno.class
  
})

public class JUnitTestSuiteGruppoOpzionale {}
