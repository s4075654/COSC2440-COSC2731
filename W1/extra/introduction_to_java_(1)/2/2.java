import java.util.Scanner;

final class ProgramThatRepeatedlyPromptsTheUserToEnterAPositiveIntegerAndChecksWhetherTheNumberIsDivisibleByBoth5And6
{
   final private static Integer promptTheUserToEnterAPositiveInteger()
     {
	System.out.print("Enter a positive integer: ");
	final Scanner ENTER = new Scanner(System.in);
	return checksWhetherTheNumberIsDivisibleByBoth5And6(ENTER.nextInt());
     }
   
   final private static Integer checksWhetherTheNumberIsDivisibleByBoth5And6(final Integer THE_NUMBER)
     {
	switch (THE_NUMBER)
	  {
	   case Integer theNumber when theNumber <= 0:
	     return 0;
	   case Integer theNumber when (theNumber % 5 == 0 && theNumber % 6 == 0):
	     System.out.println("The number is divisible by both 5 and 6.");
	     break;
	   case Integer theNumber when (theNumber % 5 == 0 || theNumber % 6 == 0):
	     System.out.println("Just one of them.");
	     break;
	   default:
	     System.out.println("Neither of them.");
	  }
	return promptTheUserToEnterAPositiveInteger();	
     }
   
   public static void main(String args[])
     {
	promptTheUserToEnterAPositiveInteger();
     }
}
