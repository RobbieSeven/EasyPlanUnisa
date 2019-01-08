package testing.OffertaFormativa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.OffertaFormativaBeanDAO;



public class TestOffertaFormativaBeanDAO2 {
	OffertaFormativaBeanDAO ofd= new OffertaFormativaBeanDAO();
	String anno="2022/23";
	
	@Test
	public void testdoDelete() {
		
		try {
			assertEquals(true,ofd.doDelete(anno));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
