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
	     switch (theNumber)
	       {
		case final char THE_NUMBER when ((THE_NUMBER % 5 == 0 || THE_NUMBER % 6 == 0) && !(THE_NUMBER % 5 == 0 && THE_NUMBER % 6 == 0) && (THE_NUMBER <= 200)):
		  System.out.printf("%d ", (short)THE_NUMBER);
		  ++number;
		default:
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
