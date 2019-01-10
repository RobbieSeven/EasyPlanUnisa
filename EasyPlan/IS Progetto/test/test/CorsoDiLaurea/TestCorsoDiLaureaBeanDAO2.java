package test.CorsoDiLaurea;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import model.CorsoDiLaureaBeanDAO;



public class TestCorsoDiLaureaBeanDAO2 {
	CorsoDiLaureaBeanDAO cld= new CorsoDiLaureaBeanDAO();
	String anno="2018/19";
	int size=2;
	
	@Test
	public void testgetCorsiDiLaureaOfferta() {
	
		assertEquals(size,(cld.doRetriveCorsoDiLaureaInOfferta(anno)).size());
	}

}
