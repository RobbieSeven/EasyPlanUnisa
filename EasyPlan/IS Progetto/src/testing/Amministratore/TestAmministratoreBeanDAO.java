package testing.Amministratore;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.AmministratoreBean;
import model.AmministratoreBeanDAO;


public class TestAmministratoreBeanDAO {

	String username="admin";
	
	AmministratoreBean ab= new AmministratoreBean("admin","admin");
	AmministratoreBeanDAO amd= new AmministratoreBeanDAO();
	
	
	@Test
	public void testdoRetriveByKey() {
		
		assertEquals(ab,amd.doRetrieveByKey(username));
	}
}
