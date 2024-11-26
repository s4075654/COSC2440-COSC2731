package allowing_users_to_enter_a_string_and_display_the_students_whose_names_match_the_provided_input;

import a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database.Problem2;
import java.util.Scanner;

final public class Problem3 extends Problem2
{
   final Scanner SCANNER = new Scanner(System.in);
   
   final private String enterAString()
     {
	return SCANNER.nextLine();
     }
   final private void displayTheStudentsWhoseNamesMatchTheProvidedInput(final String THE_PROVIDED_INPUT)
     {
     }
   
   final private void updateStudentData()
     {
     }
   
   public static void main(String[] args)
     {
	displayTheStudentsWhoseNamesMatchTheProvidedInput(enterAString());
	updateStudentData();
	SCANNER.close();
     }
}
