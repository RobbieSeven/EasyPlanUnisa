package test.Curriculum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.CurriculumBeanDAO;

public class TestCurriculumBeanDAO5 {

	CurriculumBeanDAO cbd= new CurriculumBeanDAO();
	int confronto=7;
	
	
	@Test
	public void testdoRetriveByIDMaggiore() {
		
		
			assertEquals(confronto,cbd.doRetrieveByIDMaggiore());
		
	}
}
