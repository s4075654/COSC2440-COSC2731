import java.util.Scanner;

final class ProgramThatGetThreeIntegersFromTheUserAndThenPrintsThemOutInAscendingOrder
{
   final private static Integer[] getThreeIntegersFromTheUser()
     {
	Integer[] threeIntegers = new Integer[3];
	final Scanner GET = new Scanner(System.in);
	for (byte integer = 0; integer < 3; ++integer)
	  {
	     threeIntegers[integer] = GET.nextInt();
	  }
	GET.close();
	return threeIntegers;
     }
   
   final private static void printsThemOutInAscendingOrder(final Integer[] THREE_INTEGERS)
     {
	final Thread[] threads = new Thread[3];
	for (byte integer = 0; integer < 3; ++integer)
	  {
	     final long THEM = THREE_INTEGERS[integer];
	     threads[integer] = new Thread(() -> 
			{
			   try
			     {
				Thread.sleep(THEM);
				System.out.println(THEM);
			     }
			   catch (InterruptedException exception)
			     {
			     }
			}
			);
	     threads[integer].start();
	  }
	for (Thread thread: threads)
	  {
	     try 
	       {
		  thread.join();
	       }
	     catch (InterruptedException exception)
	       {
	       }
	  }
     }
   
   public static void main(String[] args)
     {
	printsThemOutInAscendingOrder(getThreeIntegersFromTheUser());
     }
}
