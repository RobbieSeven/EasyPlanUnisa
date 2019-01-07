package testing.Curriculum;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import model.CurriculumBean;
import model.CurriculumBeanDAO;

public class TestCurriculumBeanDAO2 {
	
	CurriculumBeanDAO cbd= new CurriculumBeanDAO();
	int idCurriculum=100;
	
	@Test
	public void testdoDelete() {
		
		try {
			assertEquals(true,cbd.doDelete(idCurriculum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
