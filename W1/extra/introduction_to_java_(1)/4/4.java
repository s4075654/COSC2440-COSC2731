final class ProgramThatUsesASuitableLoopToDisplayAConversionTableNicelyAsTheOneBelow
{
   final private static void displayAConversionTableNicelyAsTheOneBelow()
     {
	System.out.println("Miles\tKilometers\t|\tKilometers\tMiles");
	for (byte miles = 1, kilometers = 20; miles <= 10 || kilometers <= 65; ++miles, kilometers += 5)
	  {
	     System.out.printf("%3d\t%7.2f\t\t|\t%7d\t\t%.2f\n", miles, miles * 1.609, kilometers, kilometers / 1.609);
	  }
     }
   
   public static void main(String[] args)
     {
	displayAConversionTableNicelyAsTheOneBelow();
     }
}
