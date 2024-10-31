import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

final class ProgramThatPromptsTheUserToEnterAYearAndAStringOfThreeCharactersForAMonthName
{
   final private static long promptsTheUserToEnterAYear()
     {
	System.out.print("Enter a year: ");
	final Scanner ENTER = new Scanner(System.in);
	long year = 0;
	try
	  {
	     year = ENTER.nextLong();
	  }
	catch (InputMismatchException invalidValueForYear)
	  {
	     System.out.println(invalidValueForYear.getMessage());
	  }
	return year;
     }
   final private static String enterAStringOfThreeCharactersForAMonthName()
     {
	System.out.print("And a string of three characters for a month name (with the first letter in uppercase): ");
	final Scanner ENTER = new Scanner(System.in);
	String monthName = null;
	try
	  {
	     monthName = ENTER.next("^(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)$");
	  }
	catch (NoSuchElementException orMonth)
	  {
	     System.out.println(orMonth.getMessage());
	  }
	ENTER.close();
	return monthName;
     }
   final private static void displaysTheNumberOfDaysInTheMonth(final long YEAR, final String MONTH_NAME)
     {
	try 
	  {
	     switch (MONTH_NAME)
	       {
		case "Jan":
		case "Mar":
		case "May":
		case "Jul":
		case "Aug":
		case "Oct":
		case "Dec":
		  System.out.println(31);
		  break;
	     
		case "Feb":
		  switch (YEAR)
		    {
		     case long year when ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)):
		       System.out.println(29);
		       break;
		     default:
		       System.out.println(28);
		    }
		  break;
	     
		case "Apr":
		case "Jun":
		case "Sep":
		case "Nov":
		  System.out.println(30);
	       }
	  }
	catch (NullPointerException month)
	  {
	     System.out.println(month.getMessage());
	  }
     }
   
   public static void main(String[] args)
     {	
	final long YEAR = promptsTheUserToEnterAYear();
	final String MONTH_NAME = enterAStringOfThreeCharactersForAMonthName();
	displaysTheNumberOfDaysInTheMonth(YEAR, MONTH_NAME);
     }
}