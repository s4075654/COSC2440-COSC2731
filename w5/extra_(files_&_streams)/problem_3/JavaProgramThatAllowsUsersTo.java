import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.ObjectInputStream;

final class JavaProgramThatAllowsUsersTo
{
   final private static class StudentObject implements Serializable
     {
	final private String STUDENT_ID, FULL_NAME, MAJOR, GPA;
	private static enum StudentType
	  {
	     FULL_TIME, PART_TIME
	  }
	private StudentType STUDENT_TYPE;
	
	private StudentObject(final String STUDENT_ID, final String FULL_NAME, final String MAJOR, final StudentType STUDENT_TYPE, final String GPA)
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
     }
}
