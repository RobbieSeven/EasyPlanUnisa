package test.esami;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestEsameBeanDaodoSave.class,
    TestEsameBeanDaodoSaveOrUpdate.class,
    TestEsameBeanDaodoRetriveByKey.class,
    TestEsameBeanDaodoRetriveEsamiOffertaFormativaObb.class,
    TestEsameBeanDaodoRetriveEsamiOffertaFormativaOpz.class,
    TestEsameBeanDaodoRetrieveLastId.class,
    TestEsameBeanDaodoDelete.class
})

public class JUnitTestSuiteEsame {}
