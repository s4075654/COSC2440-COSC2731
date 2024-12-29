package a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import io.ebean.DB;
import java.util.stream.Stream;

public class Problem2
{
   @Entity
     @Table(name="students")
       final public static record Student(
					  @Id Integer id,
					  @Column(length=50) char[] fullName,
					  @Column(length=50) char[] major
					  )
	 {
	 }

   public static void main(String[] args)
     {
	try (final Stream<Student> STUDENT_RECORDS = DB.find(Student.class)
	     .findStream())
	  {
	     STUDENT_RECORDS.parallel()
	       .forEach(System.out::println);
	  }
     }
}
