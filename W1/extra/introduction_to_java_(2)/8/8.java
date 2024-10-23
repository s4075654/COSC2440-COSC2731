import java.util.Scanner;
import java.util.HashSet;

final class ProgramThatReadsInTenIntegersBetween1And100ThenDisplaysTheNumberOfDistinctIntegersAndTheDistinctIntegersSeparatedByExactlyOneSpace
{
   final private static HashSet<Integer> readsInTenIntegersBetween1And100()
     {
	System.out.println("Ten integers between 1 and 100: ");
	final Scanner READS = new Scanner(System.in);
	
	HashSet<Integer> tenIntegersBetween1And100 = new HashSet<>(10);
	for (byte integer = 0; integer < 10; ++integer)
	  {
	     Integer integerBetween1And100 = READS.nextInt();
	     tenIntegersBetween1And100.add(integerBetween1And100);
	  }
	READS.close();
	return tenIntegersBetween1And100;
     }
   final private static void displaysTheNumberOfDistinctIntegers(final HashSet<Integer> DISTINCT_INTEGERS)
     {
	System.out.printf("The number of distinct integers: %d\n", DISTINCT_INTEGERS.size());
	System.out.print("The distinct integers separated by exactly one space (i.e., if a number appears multiple times, it is displayed only once): ");
	for (final Number distinctInteger: DISTINCT_INTEGERS)
	  {
	     System.out.printf("%d ", distinctInteger);
	  }
	System.out.println();
     }
   
   public static void main(String[] args)
     {
	displaysTheNumberOfDistinctIntegers(readsInTenIntegersBetween1And100());
     }
}
