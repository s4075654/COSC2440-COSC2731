import java.util.Arrays;
import java.util.Collections;

final class AuthorService
{
   final private static AuthorRepo REPOSITORY = new AuthorRepo();
   private static Author[] searchResults;
   
   final Author[] add(final Author[] AUTHORS)
     {
	return REPOSITORY.add(AUTHORS);
     }
   final Author[] update(final Author[] AUTHORS)
     {
	return REPOSITORY.update(AUTHORS);
     }
   final void delete(final Author[] AUTHORS)
     {
	REPOSITORY.delete(AUTHORS);
     }
   
   final Author[] search(final NameOrAcademicCredentials BY, final String NAME_OR_ACADEMIC_CREDENTIALS, final Order ORDER)
     {
	searchResults = (BY == NameOrAcademicCredentials.NAME) ? REPOSITORY.searchByName(NAME_OR_ACADEMIC_CREDENTIALS) : REPOSITORY.searchByAcademicCredentials(NAME_OR_ACADEMIC_CREDENTIALS);
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
