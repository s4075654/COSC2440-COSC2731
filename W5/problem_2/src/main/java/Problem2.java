package problem_2;

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
     @Table(name="students")
     public record Student(
			   @Id Integer ID,
			   @Size(max = 50) ArrayList<Character> FULL_NAME,
			   @Size(max = 50) ArrayList<Character> MAJOR
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
