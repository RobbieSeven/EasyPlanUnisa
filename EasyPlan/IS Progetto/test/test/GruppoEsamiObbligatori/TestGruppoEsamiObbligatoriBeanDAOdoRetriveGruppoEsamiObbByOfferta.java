package test.GruppoEsamiObbligatori;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.GruppoEsamiObbligatoriBeanDAO;

public class TestGruppoEsamiObbligatoriBeanDAOdoRetriveGruppoEsamiObbByOfferta {
	
	Scanner in = new Scanner(System.in);
	int numeroGruppi = 0;
	GruppoEsamiObbligatoriBeanDAO dao = new GruppoEsamiObbligatoriBeanDAO();
	
	@Test
	public void testDoRetriveGruppoEsamiObbByOfferta() throws ClassNotFoundException, SQLException {
		System.out.println("Inserire il  codice dell'offerta formativa su cui si intende testare il metodo: ");
		String codiceOfferta = in.nextLine();
		System.out.println("Inseriro 1 se � laurea triennale, 2 se � magistrale: ");
		int tipoLaurea = in.nextInt();
		Scanner in2 = new Scanner(System.in);
		System.out.println("Inserire il nome del Curriculum su cui si intende testare il metodo: ");
		String nomeCurriculum = in2.nextLine();
		System.out.println("Inserire quanti gruppi obbligatori relativi a quell'offerta e curriculum sono presenti nel database per testare se il metodo funziona: ");
		int numeroDiGruppi = in2.nextInt();
		assertEquals(numeroDiGruppi, dao.doRetriveGruppoEsamiObbByOfferta(codiceOfferta, tipoLaurea, nomeCurriculum).size());
		
	}
}
