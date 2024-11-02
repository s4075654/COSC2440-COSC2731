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
	     A_LIST_OF_RMIT_STUDENT = aListOfRMITStudent
	       .parallelStream()
		 .filter(students -> students.isShared)
		   .toArray(RMITStudent[]::new);
	  }
	final private boolean hasNext()
	  {
	     return (student >= A_LIST_OF_RMIT_STUDENT.length - 1) ? false : true;
	  }
	final private RMITStudent next()
	  { 
	     return A_LIST_OF_RMIT_STUDENT[(int)++student];
	  }
     }
   
   final private Iterator iterator()
     {
	return new Iterator();
     }
}
