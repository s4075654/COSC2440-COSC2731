import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Collections;

@Service
  final class LibraryService
{
   @Autowired
     private LibraryRepo repository;
   
   private static SubLibrary[] searchResults;
   
   final SubLibrary[] add(final SubLibrary[] SUB_LIBRARIES)
     {
	return repository.add(SUB_LIBRARIES);
     }
   final SubLibrary[] update(final SubLibrary[] SUB_LIBRARIES)
     {
	return repository.update(SUB_LIBRARIES);
     }
   
   final SubLibrary[] searchBy(final String SUBJECT, final Order ORDER)
     {
	searchResults = repository.searchBy(SUBJECT);
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
