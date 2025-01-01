import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

@Configuration
  @EnableWebMvc
  class WebConfigurer implements WebMvcConfigurer
{
   @Override
     public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer CONFIGURER)
       {
	  CONFIGURER.enable();
       }
}
   