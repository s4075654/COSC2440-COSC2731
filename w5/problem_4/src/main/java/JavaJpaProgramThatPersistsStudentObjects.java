import a_java_program_that_reads_and_displays_student_records_stored_in_an_sqlite_database.Problem2.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.Arrays;

final public class JavaJpaProgramThatPersistsStudentObjects
{
   final private static Student[] OBJECTS = new Student[0];
   final private static EntityManager MANAGER = Persistence.createEntityManagerFactory("default").createEntityManager();
   
   private static void persistStudentObject(final Student OBJECT)
     {
	MANAGER.persist(OBJECT);
     }
   
   public static void persistStudentObjects()
     {
	MANAGER.getTransaction().begin();
	Arrays.stream(OBJECTS)
	  .parallel()
	    .forEach(JavaJpaProgramThatPersistsStudentObjects::persistStudentObject);
	MANAGER.getTransaction().commit();
	MANAGER.close();
     }
   
   public static void main(String[] args)
     {
	persistStudentObjects();
     }
}
