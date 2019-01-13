package test.gruppo.esami.obbligatori;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;
import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBeanDao;
import org.junit.Test;



public class TestGruppoEsamiObbligatoriBeanDaodoRetriveGruppoEsamiObbligatoriByOffertaAndAnno {

  int numeroGruppi = 0;
  GruppoEsamiObbligatoriBeanDao dao = new GruppoEsamiObbligatoriBeanDao();

  @SuppressWarnings("resource")
  @Test
  public void testDoRetriveGruppoEsamiObbByOffertaAndAnno() 
      throws ClassNotFoundException, SQLException {
    System.out.println("Inserire il  codice dell'offerta formativa "
        + "su cui si intende testare il metodo: ");
    Scanner in = new Scanner(System.in);
    String temp = in.next();
    System.out.println("Inseriro 1 se � laurea triennale, 2 se � magistrale: ");
    String codiceOfferta = temp;
    int tipoLaurea = in.nextInt();
    Scanner in2 = new Scanner(System.in);
    System.out.println("Inserire il nome del Curriculum su cui si intende testare il metodo: ");
    String nomeCurriculum = in2.nextLine();
    System.out.println("Inserire quanti gruppi obbligatori relativi a quell'offerta"
        + " e curriculum sono presenti nel database per testare se il metodo funziona: ");
    int numeroDiGruppi = in2.nextInt();
    assertEquals(numeroDiGruppi,
        dao.doRetriveGruppoEsamiObbByOffertaAndAnno(codiceOfferta, tipoLaurea, nomeCurriculum, 
            numeroDiGruppi).size());

  }
}
