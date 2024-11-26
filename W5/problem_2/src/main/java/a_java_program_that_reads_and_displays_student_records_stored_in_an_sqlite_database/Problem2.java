package a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import io.ebean.Database;
import io.ebean.DatabaseBuilder;
import io.ebean.DB;
import java.util.stream.Stream;

public class Problem2
{
   @Entity
     @Table(name = "students")
   public record Student(
			  @Id Integer id,
			  @Size(max = 50) ArrayList<Character> fullName,
			  @Size(max = 50) ArrayList<Character> major
			  )
	 {
	 }
	    
   public static void main(String[] args)
     {
	final Database AN_SQLITE_DATABASE = Database.builder()
	  .name("an_sqlite_database")
	    .loadFromProperties()
	      .defaultDatabase(true)
		.addClass(Student.class)
		  .build();
	
	try (final Stream<Student> STUDENT_RECORDS = DB.find(Student.class)
	     .findStream())
	  {
	     STUDENT_RECORDS.parallel()
	       .forEach(studentRecord -> System.out.println(studentRecord));
	  }
     }
}
