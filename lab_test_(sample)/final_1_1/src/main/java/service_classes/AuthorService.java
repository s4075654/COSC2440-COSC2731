import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Collections;

@Service
  final class AuthorService
{
   @Autowired
     private AuthorRepo repository;
   
   private static Author[] searchResults;
   
   final Author[] add(final Author[] AUTHORS)
     {
	return repository.add(AUTHORS);
     }
   final Author[] update(final Author[] AUTHORS)
     {
	return repository.update(AUTHORS);
     }
   final void delete(final Author[] AUTHORS)
     {
	repository.delete(AUTHORS);
     }
   
   final Author[] search(final NameOrAcademicCredentials BY, final String NAME_OR_ACADEMIC_CREDENTIALS, final Order ORDER)
     {
	searchResults = (BY == NameOrAcademicCredentials.NAME) ? repository.searchByName(NAME_OR_ACADEMIC_CREDENTIALS) : repository.searchByAcademicCredentials(NAME_OR_ACADEMIC_CREDENTIALS);
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
