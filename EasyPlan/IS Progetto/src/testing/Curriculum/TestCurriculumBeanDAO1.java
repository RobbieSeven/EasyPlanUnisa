package testing.Curriculum;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.CurriculumBean;
import model.CurriculumBeanDAO;

public class TestCurriculumBeanDAO1 {

	CurriculumBean cb= new CurriculumBean("TestCurriculum",100,1,null,null);
	CurriculumBeanDAO cbd= new CurriculumBeanDAO();
	
	@Test
	public void testdoSave() {
		
		try {
			assertEquals(1,cbd.doSave(cb));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
