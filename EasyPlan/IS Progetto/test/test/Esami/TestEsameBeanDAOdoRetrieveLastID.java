package test.Esami;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.EsameBeanDAO;

public class TestEsameBeanDAOdoRetrieveLastID {

	private EsameBeanDAO esameDAO= new EsameBeanDAO();

	@Test
	public void testdoRetrieveLastID() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Qual' è l'id dell'ultimo esame presente nel database? ");
		int numeriEsami = in.nextInt(); 
		
		assertEquals(numeriEsami,esameDAO.doRetrieveLastID());
	}
}
