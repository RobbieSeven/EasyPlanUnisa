package testing.CorsoDiLaurea;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.CorsoDiLaureaBean;
import model.CorsoDiLaureaBeanDAO;



public class TestCorsoDiLaureaBeanDAO1 {
	CorsoDiLaureaBean cl= new CorsoDiLaureaBean(17,2,"2018/19",null);
	CorsoDiLaureaBeanDAO cld= new CorsoDiLaureaBeanDAO();
	
	@Test
	public void testdoSave() {
		
		try {
			assertEquals(17,cld.doSave(cl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cld.doDelete(17);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
