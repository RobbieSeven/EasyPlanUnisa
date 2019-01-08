package testing.OffertaFormativa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.OffertaFormativaBean;
import model.OffertaFormativaBeanDAO;


public class TestOffertaFormativaBeanDAO1 {
	OffertaFormativaBean of= new OffertaFormativaBean("2022/23",null,true);
	OffertaFormativaBeanDAO ofd= new OffertaFormativaBeanDAO();
	
	@Test
	public void testdoSave() {
		
		try {
			assertEquals(1,ofd.doSave(of));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
