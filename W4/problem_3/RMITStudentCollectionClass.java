import java.util.List;

final class RMITStudentCollection
{
   final private class RMITStudent
     {
	private String id;
	private String name;
	final private String GPA = new String();
	private boolean isShared;
     }
   private List<RMITStudent> aListOfRMITStudent;
   
   final private class Iterator
     {
	final private RMITStudent[] A_LIST_OF_RMIT_STUDENT;
	private long student = 0;
	private Iterator()
	  {
	     this.A_LIST_OF_RMIT_STUDENT = aListOfRMITStudent.toArray(new RMITStudent[aListOfRMITStudent.size()]);
	  }
	final private boolean hasNext()
	  {
	     return (next() == null) ? false : true;
	  }
	final private RMITStudent next()
	  {
	     for (long students = student + 1; students < A_LIST_OF_RMIT_STUDENT.length; ++students)
	       {
		  final long STUDENTS = students;
		  switch (A_LIST_OF_RMIT_STUDENT)
		    {
		     case RMITStudent[] aListOfRMITStudent when aListOfRMITStudent[(int)STUDENTS].isShared:
		       student = STUDENTS;
		       return aListOfRMITStudent[(int)student];
		     default:
		    }
	       }
	     return null;
	  }
     }
   
   final private Iterator iterator()
     {
	return new Iterator();
     }
}
