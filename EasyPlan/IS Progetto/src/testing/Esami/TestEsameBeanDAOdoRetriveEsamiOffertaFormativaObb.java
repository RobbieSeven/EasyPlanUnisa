package testing.Esami;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.EsameBeanDAO;

public class TestEsameBeanDAOdoRetriveEsamiOffertaFormativaObb {

	private String AnnoOffertaFormativa = "2018/19";
	private int tipoLaurea = 2;
	private String nomeCurricula = "Sicurezza Informatica"; 
	private int CodiceGEOp = 10;
	private EsameBeanDAO esameDAO= new EsameBeanDAO();

	@Test
	public void testdoRetriveEsamiOffertaFormativaObb() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Quanti esami obbligatori sono presenti nel database nel curricula "+nomeCurricula+""
				+ " dell'anno "+ AnnoOffertaFormativa +" nel gruppo opzionale "+CodiceGEOp+"?");
		int numeriEsami = in.nextInt(); 
		// ne ritorna 4
		try {
			assertEquals(numeriEsami,esameDAO.doRetriveEsamiOffertaFormativaObb(AnnoOffertaFormativa,tipoLaurea,nomeCurricula,CodiceGEOp).size());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}


