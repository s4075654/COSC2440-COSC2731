import java.util.Arrays;

final class Lecturer
{
   Object projectLed;
}

final class Problem2 implements Runnable
{
   private Lecturer lecturer;
   private Object newProject;
   
   Problem2()
     {
	lecturer = new Lecturer();
     }
   
   @Override
     public void run()
       {
	  if (lecturer.projectLed == null)
	    {
	       // this lecturer can lead a new project
	       // assign lecturer.projectLed = newProject
	       lecturer.projectLed = newProject;
	    }
       }
   public static void main(String[] args)
     {
	final Thread[] PROVE_IT_USING_CODE = new Thread[]
	  {
	     new Thread(new Problem2()),
	     new Thread(new Problem2())
	  }
	;
	Arrays.stream(PROVE_IT_USING_CODE)
	  .parallel()
	    .forEach(Thread::start);	
     }
}
