import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.Query;
import java.lang.reflect.Field;
import java.util.Arrays;

@Repository
  final class AuthorRepository
{
   @Autowired
     final private static Session SESSION;
   private static String query;
   final private Field[4] FIELDS = new Field[4];
   
   AuthorRepository()
     {
	this.SESSION = SESSION;
	FIELDS[0] = Author.class.getDeclaredField("ID");
	FIELDS[1] = Author.class.getDeclaredField("NAME");
	FIELDS[2] = Author.class.getDeclaredField("ACADEMIC_CREDENTIALS");
	FIELDS[3] = Author.class.getDeclaredField("BOOKS");
	Arrays.stream(FIELDS)
	  .parallel()
	    .forEach(field -> field.setAccessible(true));
     }
   
   final int add(final Author[] AUTHORS)
     {
	query = "insert into Author(ID, NAME, ACADEMIC_CREDENTIALS, BOOKS) values ";
	AUTHORS.stream()
	  .forEach(author ->
		   {
		      Arrays.stream(FIELDS)
			.forEach(field -> query += field.get(author));
		   }
		   );
	return FACTORY.getCurrentSession().createQuery(query).executeUpdate();
     }
   final int update(final Author[] AUTHORS)
     {
	query = "update 