import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;

@Repository
  final class BookRepo
{
   final private static Session SESSION = SessionUtility.getInstance().FACTORY.openSession();
   private static List<Book> searchResults;
   
   final Book[] add(final Book[] BOOKS)
     {
	SESSION.beginTransaction();
	Arrays.stream(BOOKS)
	  .forEach(SESSION::persist);
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return BOOKS;
     }
   final Book[] update(final Book[] BOOKS)
     {
	SESSION.beginTransaction();
	Arrays.stream(BOOKS)
	  .forEach(SESSION::merge);
	SESSION.getTransaction().commit();
	
	SESSION.close();
	return BOOKS;
     }
   final void delete(final Book[] BOOKS)
     {
	SESSION.beginTransaction();
	Arrays.stream(BOOKS)
	  .forEach(SESSION::remove);
	SESSION.getTransaction().commit();
	
	SESSION.close();
     }
   
   final Book[] searchBy(final String NAME)
     {
	searchResults = SESSION.createQuery("FROM Book WHERE NAME = '" + NAME + "'", Book.class).list();
	
	SESSION.close();
	return searchResults.toArray(new Book[0]);
     }
   final Book[] searchBy(final LocalDate THE_CREATED_DATE)
     {
	searchResults = SESSION.createQuery("FROM Book WHERE DATE_OF_CREATION = '" + THE_CREATED_DATE + "'", Book.class).list();
	
	SESSION.close();
	return searchResults.toArray(new Book[0]);
     }
}
