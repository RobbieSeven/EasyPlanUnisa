package test.esami;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.esame.EsameBeanDao;

public class TestEsameBeanDaodoRetriveEsamiOffertaFormativaOpz {

  private String annoOffertaFormativa = "2018/19";
  private int tipoLaurea = 2;
  private String nomeCurricula = "Sicurezza Informatica";
  private int codiceGeOp = 9;
  private EsameBeanDao esameDao = new EsameBeanDao();

  @SuppressWarnings("resource")
  @Test
  public void testdoRetriveEsamiOffertaFormativaOpz() {

    Scanner in = new Scanner(System.in);
    System.out.print("Quanti esami opzionali sono presenti nel database nel curricula " 
        + nomeCurricula + ""
        + " dell'anno " + annoOffertaFormativa + " nel gruppo opzionale " + codiceGeOp + "?");
    int numeriEsami = in.nextInt();
    // ne ritorna 12
    try {
      assertEquals(numeriEsami, esameDao
          .doRetriveEsamiOffertaFormativaOpz(annoOffertaFormativa, tipoLaurea, 
              nomeCurricula, codiceGeOp).size());
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

  }
}
