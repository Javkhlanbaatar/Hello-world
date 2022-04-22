import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * A GradeManager will create a command-line prompt that will let someone add
 * grades and display grades in histogram format.
 * 
 */

public class GradeManager {

	// Keeps track of the number of each grade this has
	public static HashMap<LetterGrade, Integer> allGrades;

	/**
	 * Creates a new GradeManager.
	 */
	@SuppressWarnings("static-access")
	public GradeManager() {
		// Create a new HashMap of the grades
		this.allGrades = new HashMap<LetterGrade, Integer>();

		// Add in all grades and set the occurance to 0
		for (LetterGrade gl : LetterGrade.values()) {
			allGrades.put(gl, 0);
		}
	}

	/**
	 * Adds grade to this GradeManager.
	 * 
	 * @param grade - grade to add to this grad manager
	 */
	public static void addGrade(String grade) throws InvalidGradeException {
		int i = 1;
		if (grade.equals("a")) {
			LetterGrade a = LetterGrade.A;
			int oldGrade = allGrades.get(a);
			allGrades.put(a, oldGrade + i);
		} else if (grade.equals("b")) {
			LetterGrade b = LetterGrade.B;
			@SuppressWarnings("unused")
			int oldGrade = allGrades.get(b);
			allGrades.put(b, i);
		} else if (grade.equals("c")) {
			LetterGrade c = LetterGrade.C;
			int oldGrade = allGrades.get(c);
			allGrades.put(c, oldGrade + i);
		} else if (grade.equals("d")) {
			LetterGrade d = LetterGrade.D;
			int oldGrade = allGrades.get(d);
			allGrades.put(d, oldGrade + i);
		} else if (grade.equals("f")) {
			LetterGrade f = LetterGrade.F;
			int oldGrade = allGrades.get(f);
			allGrades.put(f, oldGrade + i);
		} else // add/fdfd

			throw new InvalidGradeException("Grade is not acceptable ");
	}

	public static void addP(float grade) throws InvalidGradeException {
		int i = 1;
		if (grade <= 4 && grade >= 3.5) {
			LetterGrade a = LetterGrade.A;
			int oldGrade = allGrades.get(a);
			allGrades.put(a, oldGrade + i); // umnux utga deer n 1 eer nemegduulne ZASAX

		} else if (grade >= 2.7 && grade < 3.5) {
			LetterGrade b = LetterGrade.B;
			@SuppressWarnings("unused")
			int oldGrade = allGrades.get(b);
			allGrades.put(b, i);
		} else if (grade < 2.7 && grade > 1.7) {
			LetterGrade c = LetterGrade.C;
			int oldGrade = allGrades.get(c);
			allGrades.put(c, oldGrade + i);
		} else if (grade < 1.8 && grade > 0.7) {
			LetterGrade d = LetterGrade.D;
			int oldGrade = allGrades.get(d);
			allGrades.put(d, oldGrade + i);
		} else if (grade < 0.8 && grade >= 0) {
			LetterGrade f = LetterGrade.F;
			int oldGrade = allGrades.get(f);
			allGrades.put(f, oldGrade + i);
		} else
			throw new InvalidGradeException(grade);
	}

	/**
	 * Prints out a histogram of the grades to the console.
	 *
	 */
	public static void printHistogram() {
		try {
			System.out.println(getHistString());
		} catch (Exception e) {
			throw new RuntimeException(e + "GradeManger.printHistogram() not yet implemented!");
		}
	}

	/**
	 * Returns a string representation of the histogram of the grades.
	 * 
	 * @return a string representation of the histogram of the grades.
	 */
	public static String getHistString() {
		StringBuffer sb = new StringBuffer();
		for (LetterGrade gl : LetterGrade.values()) {
			sb.append(gl + ":");
			for (int i = 0; i < allGrades.get(gl); i++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Simple loop that accepts 3 commands from System.in: add <some grade> : for
	 * example, "add a" or "add b" adds the given grade to the GradeManager print :
	 * prints out all the grades in this GradeManager in a histogram format exit :
	 * exits the program
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		GradeManager gm = new GradeManager();

		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Starting the grade manager");
		System.out.println("\t Input format is   command/grade ");

		while (true) {
			String input = null;
			String[] grd = null;
			@SuppressWarnings("unused")
			int dun;
			System.out.println("\t Insert a input");
			try {

				input = cin.readLine();
				grd = input.split("/");

				if (input.startsWith("add")) {
					addGrade(grd[1]);

				} else if (input.startsWith("point")) {

					addP(Float.parseFloat(grd[1])); // point/3.3

				} else if (input.equals("print")) {
					printHistogram();

				} else if (input.equals("exit")) {

					break;
				}
			} catch (NumberFormatException e) { // point/hfghhgf

				throw new NumberFormatException(e + "  has an invalid format!");
			} catch (ArrayIndexOutOfBoundsException e) { // add////

				throw new ArrayIndexOutOfBoundsException(e + " index is out of bounds !!!");
			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
				throw new Exception("Value " + input + " has an invalid format!!!!!");
			}
		}
		cin.close();
	}

}