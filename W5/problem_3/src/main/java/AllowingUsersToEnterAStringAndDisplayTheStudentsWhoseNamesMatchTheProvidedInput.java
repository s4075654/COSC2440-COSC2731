import problem_2.Problem2;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.List;
import io.ebean.Database;
import io.ebean.DatabaseBuilder;
import io.ebean.DB;

final public class AllowingUsersToEnterAStringAndDisplayTheStudentsWhoseNamesMatchTheProvidedInput extends Problem2
{
   final private static Scanner SCANNER = new Scanner(System.in);
   
   final private static String enterAString()
     {
	return SCANNER.nextLine();
     }
   final private static void displayTheStudentsWhoseNamesMatchTheProvidedInput(final List<Character> THE_PROVIDED_INPUT)
     {
	SCANNER.close();
	try (final Stream<Student> STUDENT_RECORDS = DB.find(Student.class)
	     .findStream())
	  {
	     STUDENT_RECORDS.parallel()
	       .forEach(studentRecord -> System.out.println((studentRecord.FULL_NAME().equals(THE_PROVIDED_INPUT)) ? studentRecord : ""));
	  }
     }
   
   final private static int updateStudentData()
     {
	return DB.find(Student.class).update();
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
	System.out.println(updateStudentData());
     }
}
