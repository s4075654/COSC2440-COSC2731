import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class Problem4
{
   private RMITStudent student;
   
   @BeforeEach
     final void construct()
       {
	  student = new RMITStudent();
       }
   
   @Test
     final void throwCourseException()
       {
	  assertThrows(CourseException.class, () ->
		       {
			  student.updateCourse("the", 0);
			  student.updateCourse("String", 1);
			  student.updateCourse("key", 2);
			  student.updateCourse("represents", 3);
			  student.updateCourse("a", 4);
		       }
		       );
       }
   @Test
     final void throwMarkException()
       {
	  assertThrows(MarkException.class, () -> student.updateCourse("course", -1));
	  assertThrows(MarkException.class, () -> student.updateCourse("code", 101));
       }
}
