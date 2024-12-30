import org.hibernate.Session;
import java.util.List;
import java.util.Arrays;

final class LibraryRepo
{
   final private static Session SESSION = SessionUtility.getInstance().FACTORY.openSession();
   private static List<SubLibrary> searchResults;
   
   final SubLibrary[] add(final SubLibrary[] SUB_LIBRARIES)
     {
	SESSION.beginTransaction();
	Arrays.stream(SUB_LIBRARIES)
	  .forEach(SESSION::persist);
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return SUB_LIBRARIES;
     }
   final SubLibrary[] update(final SubLibrary[] SUB_LIBRARIES)
     {
	SESSION.beginTransaction();
	Arrays.stream(SUB_LIBRARIES)
	  .forEach(subLibrary -> SESSION.update(subLibrary));
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return SUB_LIBRARIES;
     }

   final SubLibrary[] searchBy(final String SUBJECT)
     {
	searchResults = SESSION.createQuery("FROM SubLibrary WHERE SUBJECT = '" + SUBJECT + "'", SubLibrary.class).list();
	
	SESSION.close();
	return searchResults.toArray(new SubLibrary[0]);
     }
}
