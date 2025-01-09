import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final class SessionUtility
{
   private static SessionUtility instance;
   final SessionFactory FACTORY;
   
   SessionUtility()
     {
	try
	  {
	     Class.forName("org.monetdb.jdbc.MonetDriver");
	     System.out.println("reached.");
	  }
	catch (final Exception EXCEPTION)
	  {
	     System.out.println("failed.");
	     EXCEPTION.printStackTrace();
	  }
	
	Configuration configuration = new Configuration();
	
	configuration.setProperty("hibernate.connection.driver_class", "org.monetdb.jdbc.MonetDriver");
	configuration.setProperty("hibernate.connection.url", "jdbc:monetdb://localhost/demo?username=monetdb&password=monetdb");
	
	configuration.addAnnotatedClass(SubLibrary.class);
	configuration.addAnnotatedClass(Author.class);
	configuration.addAnnotatedClass(Book.class);
	
	FACTORY = configuration.buildSessionFactory();
     }
   
   final static SessionUtility getInstance()
     {
	return (instance == null) ? (instance = new SessionUtility()) : instance;
     }
}
