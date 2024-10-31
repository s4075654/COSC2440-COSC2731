import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

final class ProgramThatDeterminesIfAListIsAlreadySortedInIncreasingOrder
{
   final private static List<String> promptTheUserToEnterAList()
     {
	System.out.println("Enter a list:");
	final Scanner ENTER = new Scanner(System.in);
	Number theFirstNumberInTheInput = ENTER.nextLong();
	switch (theFirstNumberInTheInput.intValue())
	  {	  
	   case 0:
	     System.exit(0);
	  }
	List<String> theList = new ArrayList<>(theFirstNumberInTheInput.intValue());
	for (long theElementsInTheList = 0; theElementsInTheList < theFirstNumberInTheInput.longValue(); ++theElementsInTheList)
	  {
	     theList.add(ENTER.next());
	  }
	ENTER.close();
	return theList;
     }
   final private static boolean displaysWhetherTheListIsSortedInAscendingOrderOrNot(final List<String> THE_LIST)
     {
	for (int theElementsInTheList = 0; theElementsInTheList < THE_LIST.size(); theElementsInTheList += 2)
	  {
	     switch (theElementsInTheList)
	       {
		case final int THE_ELEMENTS_IN_THE_LIST when (THE_ELEMENTS_IN_THE_LIST + 1 < THE_LIST.size() && THE_LIST.get(THE_ELEMENTS_IN_THE_LIST).compareTo(THE_LIST.get(THE_ELEMENTS_IN_THE_LIST + 1)) > 0):
		  return false;
		default:
	       }
	  }
	return true;
     }
   
   public static void main(String[] args)
     {
	System.out.println(displaysWhetherTheListIsSortedInAscendingOrderOrNot(promptTheUserToEnterAList()));
     }
}
