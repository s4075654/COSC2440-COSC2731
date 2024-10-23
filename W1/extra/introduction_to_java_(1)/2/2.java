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
	if (THE_NUMBER <= 0)
	  {
	     return 0;
	  }
	if (THE_NUMBER % 5 == 0 && THE_NUMBER % 6 == 0)
	  {
	     System.out.println("The number is divisible by both 5 and 6.");
	  }
	else if (THE_NUMBER % 5 == 0 || THE_NUMBER % 6 == 0)
	  {
	     System.out.println("Just one of them.");
	  }
	else 
	  {
	     System.out.println("Neither of them.");
	  }
	return promptTheUserToEnterAPositiveInteger();
     }
   
   public static void main(String args[])
     {
	promptTheUserToEnterAPositiveInteger();
     }
}
