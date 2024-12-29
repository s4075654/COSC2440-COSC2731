import a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database.Problem2;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;
import io.ebean.UpdateQuery;
import io.ebean.DB;

final public class AllowingUsersToEnterAStringAndDisplayTheStudentsWhoseNamesMatchTheProvidedInput extends Problem2
{
   final private static Scanner SCANNER = new Scanner(System.in);
   
   final private static String enterAString()
     {
	return SCANNER.nextLine();
     }
   final private static void displayTheStudentsWhoseNamesMatchTheProvidedInput(final char[] THE_PROVIDED_INPUT)
     {
	SCANNER.close();
	try (final Stream<Student> STUDENT_RECORDS = DB.find(Student.class)
	     .findStream())
	  {
	     STUDENT_RECORDS.parallel()
	       .forEach(studentRecord -> System.out.print((Arrays.equals(studentRecord.fullName(), THE_PROVIDED_INPUT)) ? studentRecord + "\n" : ""));
	  }
     }
   
   final private static UpdateQuery<Student> updateStudentData()
     {
	return DB.update(Student.class);
     }
   
   public static void main(String[] args)
     {
	displayTheStudentsWhoseNamesMatchTheProvidedInput(enterAString().toCharArray());
	System.out.println(updateStudentData());
     }
}
