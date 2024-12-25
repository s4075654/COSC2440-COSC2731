import org.springframework.context.annotation.AnnotationConfigApplicationContext;

final class LibrarySystem
{
   public static void main(String[] args)
     {
	final AnnotationConfigApplicationContext CONTEXT = new AnnotationConfigApplicationContext(Configuration.class);
     }
}
