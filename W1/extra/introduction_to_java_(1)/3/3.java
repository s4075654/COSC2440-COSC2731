final class ProgramThatDisplaysAllTheNumbersFrom100To200
{  
   final private static char separateByExactlyOneSpace(char theNumber)
     {
	for (byte number = 1; number <= 10; ++theNumber)
	  {
	     if (theNumber > 200)
	       {
		  break;
	       }
	     if ((theNumber % 5 == 0 || theNumber % 6 == 0) && !(theNumber % 5 == 0 && theNumber % 6 == 0) && (theNumber <= 200))
	       {
		  System.out.printf("%d ", (short)theNumber);
		  ++number;
	       }
	  }
	return theNumber;
     }
   
   final private static void displaysTenNumbersPerLine()
     {
	char theNumber = 100;
	while (theNumber <= 200)
	  {
	     theNumber = separateByExactlyOneSpace(theNumber);
	     System.out.println();
	  }
     }
   
   public static void main(String[] args)
     {
	displaysTenNumbersPerLine();
     }
}
