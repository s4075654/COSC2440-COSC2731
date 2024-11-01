import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

final class Student {
    private String studentId;
    private String fullName;
    private String major;

    Student()
     {
	this.studentId = null;
        this.fullName = null;
        this.major = null;
     }

    Student(final String STUDENT_ID, final String FULL_NAME, final String MAJOR)
     {
	this.studentId = STUDENT_ID;
        this.fullName = FULL_NAME;
        this.major = MAJOR;
     }

   final String getStudentId()
     {
	return studentId;
     }
   
   final void setStudentId(final String STUDENT_ID)
     {
	this.studentId = STUDENT_ID;
     }

   final String getFullName()
     {
	return fullName;
     }
   
   final void setFullName(final String FULL_NAME)
     {
	this.fullName = FULL_NAME;
     }

   final String getMajor()
     {
	return major;
     }
   
   final void setMajor(final String MAJOR)
     {
	this.major = MAJOR;
     }
   
   final public String toString()
     {
	return studentId + "\0" + fullName + "\0" + major;
     }
   
   final void toFile() throws IOException
     {
	Files.writeString(Path.of("Student.instances"), toString() + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
     }
   
   final void fromFile() throws IOException
     {
	List<String> lines = Files.readAllLines(Path.of("Student.instances"));
	Files.write(Path.of("Student.instances"), lines.parallelStream()
		    .filter(line -> !line.startsWith(studentId))
		    .collect(Collectors.toList()), StandardOpenOption.TRUNCATE_EXISTING);
     }
}

final class StudentView
{
   private static StudentView studentView;
   
   private StudentView()
     {
     }
   
   static StudentView getStudentView()
     {
	switch (studentView)
	  {
	   case null:
	     studentView = new StudentView();
	   default:
	  }
	return studentView;
     }
   
   final <Result> void viewResults(final Result RESULTS)
     {
	System.out.print("Results: ");
	switch (RESULTS)
	  {
	   case final IllegalArgumentException EXCEPTION:
	     System.out.println(EXCEPTION.getMessage());
	     break;
	   default:
	     System.out.println(RESULTS);
	  }
     }
}

final class StudentController
{
   private static StudentController studentController;
   private enum Controller
     {
	CREATE, EDIT;
	
	final static Controller getController(final String CONTROLLER)
	  {
	     return Controller.valueOf(CONTROLLER);
	  }
     }
   
   private StudentController(final String[] ARGS)
     {
	Student[] studentInstances = new Student[(ARGS.length - 1) / 3];
	Controller controller;
	try 
	  {
	     controller = Controller.getController(ARGS[0]);
	  }
	catch (final IllegalArgumentException EXCEPTION)
	  {
	     StudentView.getStudentView().viewResults(EXCEPTION);
	     return;
	  }
	long instance = 0;
	for (long arg = 1; arg < ARGS.length; ++arg)
	  {
	     switch (arg)
	       {
		case final long ARG when ARG % 3 == 1:
		  studentInstances[(int)instance] = new Student();
		  studentInstances[(int)instance].setStudentId(ARGS[(int)ARG]);
		  break;
		case final long ARG when ARG % 3 == 2:
		  studentInstances[(int)instance].setFullName(ARGS[(int)ARG]);
		  break;
		case final long ARG when ARG % 3 == 0:
		  studentInstances[(int)instance++].setMajor(ARGS[(int)ARG]);
		default:
	       }
	  }
	switch (controller)
	  {
	   case EDIT:
	     Arrays.stream(studentInstances)
	       .parallel()
		 .forEach(student ->
			  {
			     try
			       {
				  student.fromFile();
			       }
			     catch (final IOException EXCEPTION)
			       {
				  StudentView.getStudentView().viewResults(EXCEPTION);
				  return;
			       }
			  }
			  );
	   default:
	     Arrays.stream(studentInstances)
	       .parallel()
		 .forEach(student ->
			  {
			     try
			       {
				  student.toFile();
			       }
			     catch (final IOException EXCEPTION)
			       {
				  StudentView.getStudentView().viewResults(EXCEPTION);
				  return;
			       }
			  }
			  );
	  }	  
	StudentView.getStudentView().viewResults("Good.");
     }
   
   final static StudentController getStudentController(final String[] ARGS)
     {
	switch (studentController)
	  {
	   case null:
	     studentController = new StudentController(ARGS);
	   default:
	  }
	return studentController;
     }
   
   public static void main(String[] args)
     {
	getStudentController(args);
     }   
}
