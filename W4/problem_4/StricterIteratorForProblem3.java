import java.util.List;
import java.util.Arrays;

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
   
   private class Iterator
     {
	RMITStudent[] aListOfRMITStudent;
	private long student = 0;
	private Iterator()
	  {
	     this.aListOfRMITStudent = Arrays.stream(aListOfRMITStudent)
	       .parallel()
		 .filter(students -> students.isShared)
		   .toArray(RMITStudent[]::new);
	  }
	final private boolean hasNext()
	  {
	     return (student >= aListOfRMITStudent.length - 1) ? false : true;
	  }
	final private RMITStudent next()
	  { 
	     return aListOfRMITStudent[(int)++student];
	  }
     }
   
   final private class StudentsWhoAreWillingToShareTheirInformationAndHaveAMinimumGPAOf6 extends Iterator
     {
	private StudentsWhoAreWillingToShareTheirInformationAndHaveAMinimumGPAOf6()
	  {
	     this.aListOfRMITStudent = Arrays.stream(aListOfRMITStudent)
	       .parallel()
		 .filter(students -> students.isShared && Double.parseDouble(students.GPA) >= 6.5)
		   .toArray(RMITStudent[]::new);
	  }
     }
   
   private enum Problem
     {
	PROBLEM_3, PROBLEM_4;
     }
   
   final private Iterator iterator(final Problem ITERATOR)
     {
	return (ITERATOR == Problem.PROBLEM_3) ? new Iterator() : new StudentsWhoAreWillingToShareTheirInformationAndHaveAMinimumGPAOf6();
     }
}
