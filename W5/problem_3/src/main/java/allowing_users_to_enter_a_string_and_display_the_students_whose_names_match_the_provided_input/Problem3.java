package allowing_users_to_enter_a_string_and_display_the_students_whose_names_match_the_provided_input;

import a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database.Problem2;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.List;
import io.ebean.Database;
import io.ebean.DatabaseBuilder;
import io.ebean.DB;

final public class Problem3 extends Problem2
{
   final private static Scanner SCANNER = new Scanner(System.in);
   
   final private static String enterAString()
     {
	return SCANNER.nextLine();
     }
   final private static void displayTheStudentsWhoseNamesMatchTheProvidedInput(final List<Character> THE_PROVIDED_INPUT)
     {
	try (final Stream<Student> STUDENT_RECORDS = DB.find(Student.class)
	     .findStream())
	  {
	     STUDENT_RECORDS.parallel()
	       .forEach(studentRecord -> System.out.println((studentRecord.FULL_NAME().equals(THE_PROVIDED_INPUT)) ? studentRecord : ""));
	  }
     }
   
   final private static void updateStudentData()
     {
	DB.deleteAll(DB.find(Student.class)
		     .findSet());
     }
   
   public static void main(String[] args)
     {
	final Database AN_SQLITE_DATABASE = Database.builder()
	  .name("an_sqlite_database")
	    .loadFromProperties()
	      .defaultDatabase(true)
		.addClass(Student.class)
		  .build();
	
	displayTheStudentsWhoseNamesMatchTheProvidedInput(enterAString().chars()
							  .mapToObj(character -> (char)character)
							  .toList());
	updateStudentData();
	SCANNER.close();
     }
}
