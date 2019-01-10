package test.OffertaFormativa;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import model.OffertaFormativaBeanDAO;





public class TestOffertaFormativaDAO3 {
	int size=2;
	OffertaFormativaBeanDAO ofd= new OffertaFormativaBeanDAO();
	
	
	@Test
	public void testdoRetriveByAll() {
		
		try {
			assertEquals(size,(ofd.doRetriveByAll()).size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
