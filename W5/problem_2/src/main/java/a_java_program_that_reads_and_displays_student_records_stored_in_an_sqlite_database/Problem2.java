package a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import io.ebean.DB;
import java.util.stream.Stream;

final public class Problem2
{
   @Entity
     @Table(name = "students")
   private record Student(
			  @Id @Column(name = "id") Integer id,
			  StringBuilder fullName,
			  StringBuilder major
			  )
	 {
	    private Student
	      {
		 if (fullName.length() == 0)
		   {
		      fullName = new StringBuilder(50);
		   }
		 if (major.length() == 0)
		   {
		      major = new StringBuilder(50);
		   }
	      }
	 }
       
   public static void main(String[] args)
     {
	DB.getDefault();
	try (Stream<Student> studentRecords = DB.find(Student.class)
	     .findStream())
	  {
	     studentRecords.parallel()
	       .forEach(studentRecord -> System.out.println(studentRecord));
	  }
     }
}
