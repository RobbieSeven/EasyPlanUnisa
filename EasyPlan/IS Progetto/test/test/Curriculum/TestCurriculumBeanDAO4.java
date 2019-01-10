package test.Curriculum;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import model.CurriculumBeanDAO;

public class TestCurriculumBeanDAO4 {

	String anno="2018/19";
	int laurea=2;
	CurriculumBeanDAO cbd= new CurriculumBeanDAO();
	int size=5;
	
	@Test
	public void testdoRetriveByCorsoDiLaureaOffertaFormativa() {
		
		try {
			assertEquals(size,(cbd.doRetriveByCorsoDiLaureaOffertaFormativa(laurea, anno)).size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
