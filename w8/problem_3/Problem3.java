import java.util.Map;
import java.util.HashMap;

class RMITException extends Exception
{
   final private String MESSAGE;
   RMITException(final String AN_APPROPRIATE_MESSAGE)
     {
	MESSAGE = AN_APPROPRIATE_MESSAGE;
     }
}

final class CourseException extends RMITException
{
   CourseException(final String AN_APPROPRIATE_MESSAGE)
     {
	super(AN_APPROPRIATE_MESSAGE);
     }
}
final class MarkException extends RMITException
{
   MarkException(final String AN_APPROPRIATE_MESSAGE)
     {
	super(AN_APPROPRIATE_MESSAGE);
     }
}

final class RMITStudent
{
   final String NAME;
   Map<String, Integer> marks;
   private static Integer numberOfAddedCourses = 0;
   
   RMITStudent()
     {
	NAME = new String();
	marks = new HashMap<String, Integer>();
     }
   
   final void updateCourse(String code, int mark) throws RMITException
     {
	switch (Integer.valueOf(numberOfAddedCourses))
	  {
	   case final Integer NUMBER_OF_ADDED_COURSES when NUMBER_OF_ADDED_COURSES > 3:
	     throw new CourseException("An appropriate message.");
	   default:
	  }
	switch (Integer.valueOf(mark))
	  {
	   case final Integer MARK when (MARK < 0 || MARK > 100):
	     throw new MarkException("An appropriate message.");
	   default:
	  }
	
	numberOfAddedCourses = (marks.containsKey(code)) ? numberOfAddedCourses : numberOfAddedCourses + 1;
	marks.put(code, mark);
     }
}

final class Problem3
{
   final private static RMITStudent A_STUDENT = new RMITStudent();
   public static void main(String[] args)
     {
	try
	  {
	     A_STUDENT.updateCourse("the", -1);
	  }
	catch (final RMITException EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
	try
	  {
	     A_STUDENT.updateCourse("String", 101);
	  }
	catch (final RMITException EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
	try
	  {
	     A_STUDENT.updateCourse("key", 0);
	     A_STUDENT.updateCourse("represents", 1);
	     A_STUDENT.updateCourse("a", 2);
	     A_STUDENT.updateCourse("course", 3);
	     A_STUDENT.updateCourse("code", 4);
	  }
	catch (final RMITException EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
     }
}
