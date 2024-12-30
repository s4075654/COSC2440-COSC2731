import org.hibernate.Session;
import java.util.List;
import java.util.Arrays;

final class AuthorRepo
{
   final private static Session SESSION = SessionUtility.getInstance().FACTORY.openSession();
   private static List<Author> searchResults;
   
   final Author[] add(final Author[] AUTHORS)
     {
	SESSION.beginTransaction();
	Arrays.stream(AUTHORS)
	  .forEach(SESSION::persist);
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return AUTHORS;
     }
   final Author[] update(final Author[] AUTHORS)
     {
	SESSION.beginTransaction();
	Arrays.stream(AUTHORS)
	  .forEach(SESSION::update);
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return AUTHORS;
     }
   final void delete(final Author[] AUTHORS)
     {
	SESSION.beginTransaction();
	Arrays.stream(AUTHORS)
	  .forEach(SESSION::delete);
	SESSION.getTransaction().commit();
	
	SESSION.close();
     }
   
   final Author[] searchByName(final String NAME)
     {
	searchResults = SESSION.createQuery("FROM Author WHERE NAME = '" + NAME + "'", Author.class).list();
	
	SESSION.close();
	return searchResults.toArray(new Author[0]);
     }
   final Author[] searchByAcademicCredentials(final String ACADEMIC_CREDENTIALS)
     {
	searchResults = SESSION.createQuery("FROM Author WHERE ACADEMIC_CREDENTIALS = '" + ACADEMIC_CREDENTIALS + "'", Author.class).list();
	
	SESSION.close();
	return searchResults.toArray(new Author[0]);
     }
}
