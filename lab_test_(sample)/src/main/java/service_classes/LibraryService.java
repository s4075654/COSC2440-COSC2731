import java.util.Arrays;
import java.util.Collections;

final class LibraryService
{
   final private static LibraryRepo REPOSITORY = new LibraryRepo();
   private static SubLibrary[] searchResults;
   
   final SubLibrary[] add(final SubLibrary[] SUB_LIBRARIES)
     {
	return REPOSITORY.add(SUB_LIBRARIES);
     }
   final SubLibrary[] update(final SubLibrary[] SUB_LIBRARIES)
     {
	return REPOSITORY.update(SUB_LIBRARIES);
     }
   
   final SubLibrary[] searchBy(final String SUBJECT, final Order ORDER)
     {
	searchResults = REPOSITORY.searchBy(SUBJECT);
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
