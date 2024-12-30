import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

final class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
{
   @Override
     protected Class<?>[] getRootConfigClasses() 
       {
	  return null;
       }
   
   @Override
     protected Class<?>[] getServletConfigClasses() 
       {
	  return new Class<?>[] 
	    {
	        WebConfigurer.class 
	    }
	  ;
       }
   @Override
     protected String[] getServletMappings() 
       {
	  return new String[] 
	    {
	        "/" 
	    }
	  ;
       }
}
