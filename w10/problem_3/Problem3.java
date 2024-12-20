import java.util.Arrays;

final class Person extends Thread
{
   final private String[] AN_ARRAY_OF_MESSAGES_TO_BE_SENT;
   Person(final String[] AN_ARRAY_OF_MESSAGES_TO_BE_SENT)
     {
	this.AN_ARRAY_OF_MESSAGES_TO_BE_SENT = AN_ARRAY_OF_MESSAGES_TO_BE_SENT;
     }
   
   final String send(final String A_MESSAGE)
     {
	return A_MESSAGE;
     }
   final void receive(final String THE_MESSAGE)
     {
	display(THE_MESSAGE);
     }
   final void display(final String THE_MESSAGE)
     {
	System.out.println(THE_MESSAGE);
     }
   
   @Override
     public void run()
       {
	  Arrays.stream(AN_ARRAY_OF_MESSAGES_TO_BE_SENT)
	    .forEach(message ->
		     {
			receive(send(message));
			try
			  {
			     Thread.sleep(1000);
			  }
			catch (final Exception EXCEPTION)
			  {
			     EXCEPTION.printStackTrace();
			  }
		     }
		     );
       }
   
}

final class Problem3
{  
   final private static int N = 2;
   final private static Person[] N_PEOPLE = new Person[N];
   
   public static void main(String[] args)
     {
	Arrays.stream(N_PEOPLE)
	  .parallel()
	    .map(person -> new Person(args))
	      .forEach(Thread::start);
     }
}

