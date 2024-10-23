import java.util.Scanner;

final class ProgramThatPromptsTheUserToEnterAnIntegerFrom1To15AndDisplaysAPyramid
{
   final private static Integer promptsTheUserToEnterAnIntegerFrom1To15()
     {
	System.out.print("Enter an integer from 1 to 15: ");
	final Scanner ENTER = new Scanner(System.in);
	return ENTER.nextInt();
     }
   
   final private static void displaysAPyramid(final Integer AN_INTEGER)
     {
	for (byte line = 1; line <= AN_INTEGER; ++line)
	  {
	     for (byte tab = 1; tab <= AN_INTEGER - line; ++tab)
	       {
		  System.out.print('\t');
	       }
	     for (byte left = line; left != 1; --left)
	       {
		  System.out.printf("%d\t", left);
	       }
	     for (byte right = 1; right <= line; ++right)
	       {
		  System.out.printf("%d\t", right);
	       }
	     System.out.println();
	  }
     }
   
   public static void main(String[] args)
     {
	displaysAPyramid(promptsTheUserToEnterAnIntegerFrom1To15());
     }
}
