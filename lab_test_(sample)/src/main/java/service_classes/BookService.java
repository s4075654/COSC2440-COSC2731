import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

final class BookService
{
   final private static BookRepo REPOSITORY = new BookRepo();
   private static Book[] searchResults;
   
   final Book[] add(final Book[] BOOKS)
     {
	return REPOSITORY.add(BOOKS);
     }
   final Book[] update(final Book[] BOOKS)
     {
	return REPOSITORY.update(BOOKS);
     }
   final void delete(final Book[] BOOKS)
     {
	REPOSITORY.delete(BOOKS);
     }
   
   final Book[] searchBy(final Object NAME_OR_THE_CREATED_DATE, final Order ORDER)
     {
	searchResults = (NAME_OR_THE_CREATED_DATE instanceof String) ? REPOSITORY.searchBy(String.class.cast(NAME_OR_THE_CREATED_DATE)) : REPOSITORY.searchBy(LocalDate.class.cast(NAME_OR_THE_CREATED_DATE));
	switch (ORDER)
	  {
	   case DESCENDING:
	     Arrays.sort(searchResults, Collections.reverseOrder());
	     break;
	   case ASCENDING:
	     Arrays.sort(searchResults);
	  }
	return searchResults;
     }
}
