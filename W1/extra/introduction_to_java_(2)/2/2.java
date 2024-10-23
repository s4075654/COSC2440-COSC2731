import java.util.Scanner;
import java.util.Arrays;

final class ProgramThatPromptsTheUserToEnterThreeCitiesAndDisplayThemInAscendingOrder
{
   final private static String[] promptsTheUserToEnterThreeCities()
     {
	System.out.println("Enter three cities:");
	final String[] THREE_CITIES = new String[3];
	final Scanner ENTER = new Scanner(System.in);
	for (byte them = 0; them < 3; ++them)
	  {
	     THREE_CITIES[them] = ENTER.nextLine();
	  }
	ENTER.close();
	return THREE_CITIES;
     }
   final private static void displayThemInAscendingOrder(final String[] THEM)
     {
	System.out.println();
	Arrays.stream(THEM)
	  .sorted()
	    .forEach(System.out::println);
     }
   
   public static void main(String args[])
     {
	displayThemInAscendingOrder(promptsTheUserToEnterThreeCities());
     }
}
