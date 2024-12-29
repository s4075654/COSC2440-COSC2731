import java.time.LocalTime;

final class ThreadThatDisplaysTheCurrentTimeToTheConsoleEverySecond implements Runnable
{
   @Override
     public void run()
       {
	  while (true)
	    {
	       System.out.println(LocalTime.now());
	       try
		 {
		    Thread.sleep(1000);
		 }
	       catch (final Exception EXCEPTION)
		 {
		    EXCEPTION.printStackTrace();
		 }
	    }
       }
   public static void main(String[] args)
     {
	final Thread A_THREAD_THAT_DISPLAYS_THE_CURRENT_TIME_TO_THE_CONSOLE_EVERY_SECOND = new Thread(new Problem1());
	A_THREAD_THAT_DISPLAYS_THE_CURRENT_TIME_TO_THE_CONSOLE_EVERY_SECOND.start();
     }
}
