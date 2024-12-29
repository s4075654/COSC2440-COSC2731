import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.ObjectInputStream;
import java.util.Collection;

final class JavaProgramThatAllowsUsersTo
{
   final static class StudentObject implements Serializable
     {
	final String STUDENT_ID, FULL_NAME, MAJOR, GPA;
	static enum StudentType
	  {
	     FULL_TIME, PART_TIME
	  }
	StudentType STUDENT_TYPE;
	
	StudentObject(final String STUDENT_ID, final String FULL_NAME, final String MAJOR, final StudentType STUDENT_TYPE, final String GPA)
	  {
	     this.STUDENT_ID = STUDENT_ID;
	     this.FULL_NAME = FULL_NAME;
	     this.MAJOR = MAJOR;
	     this.STUDENT_TYPE = STUDENT_TYPE;
	     this.GPA = GPA;
	  }
     }
   private static ArrayList<StudentObject> studentObjects = new ArrayList<StudentObject>();
   final private static Scanner ENTER = new Scanner(System.in);
   final private static Path A_FILE = Path.of("a file");
   
   final private static void askUsersToEnterAtLeastStudentId()
     {
	System.out.println("Enter at least student id, full name, major, student type, and GPA:");
	studentObjects.add(new StudentObject(ENTER.nextLine(), ENTER.nextLine(), ENTER.nextLine(), StudentObject.StudentType.valueOf(ENTER.nextLine()), ENTER.nextLine()));
     }
   final private static void displayAllStudents()
     {
	studentObjects.parallelStream()
	  .forEach(System.out::println);
     }
   final private static void saveAllDataToAFile()
     {
	try (final ObjectOutputStream SAVE = new ObjectOutputStream(Files.newOutputStream(A_FILE)))
	  {
	     SAVE.writeObject(studentObjects);
	  }
	catch (final Exception EXCEPTION)
	  {
	  }
     }
   final private static void loadAllStudentObjects()
     {
	try (final ObjectInputStream LOAD = new ObjectInputStream(Files.newInputStream(A_FILE)))
	  {
	     studentObjects = (ArrayList<StudentObject>)(LOAD.readObject());
	  }
	catch (final Exception EXCEPTION)
	  {
	  }
     }
   
   public static void main(String[] args)
     {
	loadAllStudentObjects();
	askUsersToEnterAtLeastStudentId();
	
	ENTER.close();
	
	displayAllStudents();
	saveAllDataToAFile();
	
	Activities.applyThe(studentObjects);
     }   
}

final class Activities
{
   final static void applyThe(final Collection<JavaProgramThatAllowsUsersTo.StudentObject> THE_COLLECTION_OF_STUDENTS_READ_FROM_A_FILE)
     {
	THE_COLLECTION_OF_STUDENTS_READ_FROM_A_FILE.parallelStream()
	  .filter(student -> student.STUDENT_TYPE == JavaProgramThatAllowsUsersTo.StudentObject.StudentType.FULL_TIME)
	    .map(student -> new JavaProgramThatAllowsUsersTo.StudentObject(student.STUDENT_ID, student.FULL_NAME, student.MAJOR, student.STUDENT_TYPE, student.GPA))
	      .sorted((student, STUDENT) -> STUDENT.GPA.compareTo(student.GPA))
		.forEach(student -> System.out.println(student.STUDENT_ID + "\t" + student.FULL_NAME.split(" ")[0] + "\t" + student.GPA));
     }
}
