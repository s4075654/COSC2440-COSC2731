package the_same_package;

final public class Student
{
   public StringBuilder studentId, fullName, major;
   
   public Student(final String STUDENTID, final String FULLNAME, final String MAJOR)
     {
	this.studentId = new StringBuilder(STUDENTID);
	this.fullName = new StringBuilder(FULLNAME);
	this.major = new StringBuilder(MAJOR);
     }
   
}
