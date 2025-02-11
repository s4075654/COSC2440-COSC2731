package problem3;

import problem_4.Member;
import problem4.Project;
import java.time.Duration;
import problem_4.Researcher;

/**
 * @author COSC2440 Teaching Team
 * @version 1.0
 */

public class Student {
    private String studentId;
    private String fullName;
    private String major;

    public  Student() {
        this.studentId = "Default";
        this.fullName = "Default";
        this.major = "Default";
    }

    public Student(String studentId, String fullName, String major) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
    }

    // Getter and setter methods
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
   
   final public String toString()
     {
	return "studentId: " + studentId + "\tfullName: " + fullName + "\tmajor: " + major;
     }   
}

final class PartTime extends Student
{
   private Duration theMinimum;
   private Duration theMaximumHoursTheySpendOnInstructor;
   
   private PartTime(final Duration THE_MINIMUM, final Duration THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR)
     {
	this.theMinimum = THE_MINIMUM;
	this.theMaximumHoursTheySpendOnInstructor = THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR;
     }
   
   private PartTime(final String STUDENT_ID, final String FULL_NAME, final String MAJOR, final Duration THE_MINIMUM, final Duration THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR)
     {
	super(STUDENT_ID, FULL_NAME, MAJOR);
	this.theMinimum = THE_MINIMUM;
	this.theMaximumHoursTheySpendOnInstructor = THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR;
     }
 
   final private class PartTimeStudent
     {
	private PartTime student;
	private static long thisCounter = 0;
	
	public PartTimeStudent(final Duration THE_MINIMUM, final Duration THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR)
	  {
	     student = new PartTime(THE_MINIMUM, THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR);
	     ++thisCounter;
	  }
	
	final public PartTimeStudent studentId(final String STUDENT_ID)
	  {
	     student.setStudentId(STUDENT_ID);
	     return this;
	  }
	
	final public PartTimeStudent fullName(final String FULL_NAME)
	  {
	     student.setFullName(FULL_NAME);
	     return this;
	  }
	
	final public PartTimeStudent major(final String MAJOR)
	  {
	     student.setMajor(MAJOR);
	     return this;
	  }
	
	final public PartTime partTime()
	  {
	     return student;
	  }
	
	final public static long count()
	  {
	     return thisCounter;
	  }
     }	     

   final public Duration getTheMinimum()
     {
	return theMinimum;
     }
   
   final public void setTheMinimum(final Duration THE_MINIMUM)
     {
	this.theMinimum = THE_MINIMUM;
     }
   
   final public Duration getTheMaxinumHoursTheySpendOnInstructor()
     {
	return theMaximumHoursTheySpendOnInstructor;
     }
   
   final public void setTheMaximumHoursTheySpendOnInstructor(final Duration THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR)
     {
	this.theMaximumHoursTheySpendOnInstructor = THE_MAXIMUM_HOURS_THEY_SPEND_ON_INSTRUCTOR;
     }
}
