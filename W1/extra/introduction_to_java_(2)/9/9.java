import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

final class ProgramThatReadsAListOfIntegersBetween1And100ThenCountsTheOccurrencesOfEach
{
   final private static HashMap<Integer, Long> readsAListOfIntegersBetween1And100ThenCountsTheOccurrencesOfEach(final List<Integer> A_LIST_OF_INTEGERS_BETWEEN_1_AND_100)
     {
	HashMap<Integer, Long> theOccurrencesOfEach = new HashMap<>();
	for (Integer integer: A_LIST_OF_INTEGERS_BETWEEN_1_AND_100)
	  {
	     switch (integer)
	       {
		case final Integer INTEGER when (INTEGER == 0):
		  return theOccurrencesOfEach;
		case final Integer INTEGER when (INTEGER >= 1 && INTEGER <= 100):
		  theOccurrencesOfEach.put(INTEGER, theOccurrencesOfEach.getOrDefault(INTEGER, (long)0) + 1);
		default:
	       }
	  }
	return null;
     }
   
   public static void main(String[] args)
     {
	List<Integer> aListOfIntegersBetween1And100 = new LinkedList<>();
	for (String integerBetween1And100: args)
	  {
	     aListOfIntegersBetween1And100.add(Integer.parseInt(integerBetween1And100));
	  }
	final HashMap<Integer, Long> THE_OCCURRENCES_OF_EACH = readsAListOfIntegersBetween1And100ThenCountsTheOccurrencesOfEach(aListOfIntegersBetween1And100);
	THE_OCCURRENCES_OF_EACH.entrySet().parallelStream().forEach(each ->
					{
					   Integer integer = each.getKey();
					   long occurrencesOfEach = each.getValue();
					   System.out.printf("Integer: %d\n", integer);
					   System.out.printf("The occurrences: %d ", occurrencesOfEach);
					   switch (occurrencesOfEach)
					     {
					      case final long OCCURRENCES_OF_EACH when OCCURRENCES_OF_EACH > 1:
						System.out.printf("times");
					      default:
					     }
					   System.out.println('\n');
					}
								    );
     }
}