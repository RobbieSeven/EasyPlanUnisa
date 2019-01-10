package test.Curriculum;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.CurriculumBean;
import model.CurriculumBeanDAO;

public class TestCurriculumBeanDAO3 {

	int size=6;
	CurriculumBeanDAO cbd= new CurriculumBeanDAO();
	
	
	@Test
	public void testdoRetriveByAll() {
		
		try {
			assertEquals(size,(cbd.doRetriveByAll()).size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
