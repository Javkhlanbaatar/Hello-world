import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("unused")
public class GradeManagerUnitTest {

	@SuppressWarnings("static-access")
	@Test
	public void gradeManagerTest() {
		GradeManager gm = new GradeManager();

		for (LetterGrade gl : LetterGrade.values())
			Assert.assertTrue(gm.allGrades.containsKey(gl));
	}

	@SuppressWarnings("static-access")
	@Test
	public void addGRadeTest() {
		GradeManager gm = new GradeManager();

		try {
			for (int i = 4; i >= 0; i--)
				gm.addP(i);
			
			String str= "{B=1, D=1, A=1, C=1, F=1}";
			Assert.assertEquals(str , gm.allGrades.toString());
		} catch (InvalidGradeException e) {
			e.printStackTrace();
		} 
		

	}

}
