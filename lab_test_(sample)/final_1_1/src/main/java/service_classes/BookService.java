import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Service
  final class BookService
{
   @Autowired
     private BookRepo repository;
   
   private static Book[] searchResults;
   
   final Book[] add(final Book[] BOOKS)
     {
	return repository.add(BOOKS);
     }
   final Book[] update(final Book[] BOOKS)
     {
	return repository.update(BOOKS);
     }
   final void delete(final Book[] BOOKS)
     {
	repository.delete(BOOKS);
     }
   
   final Book[] searchBy(final Object NAME_OR_THE_CREATED_DATE, final Order ORDER)
     {
	searchResults = (NAME_OR_THE_CREATED_DATE instanceof String) ? repository.searchBy(String.class.cast(NAME_OR_THE_CREATED_DATE)) : repository.searchBy(LocalDate.class.cast(NAME_OR_THE_CREATED_DATE));
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
