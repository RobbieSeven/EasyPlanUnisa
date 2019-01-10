package test.Esami;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.EsameBeanDAO;

public class TestEsameBeanDAOdoRetriveEsamiOffertaFormativaOpz {
	
	private String AnnoOffertaFormativa = "2018/19";
	private int tipoLaurea = 2;
	private String nomeCurricula = "Sicurezza Informatica"; 
	private int CodiceGEOp = 9;
	private EsameBeanDAO esameDAO= new EsameBeanDAO();
	
	@Test
	public void testdoRetriveEsamiOffertaFormativaOpz() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Quanti esami opzionali sono presenti nel database nel curricula "+nomeCurricula+""
				+ " dell'anno "+ AnnoOffertaFormativa +" nel gruppo opzionale "+CodiceGEOp+"?");
		int numeriEsami = in.nextInt(); 
		// ne ritorna 12
		try {
			assertEquals(numeriEsami,esameDAO.doRetriveEsamiOffertaFormativaOpz(AnnoOffertaFormativa,tipoLaurea,nomeCurricula,CodiceGEOp).size());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
