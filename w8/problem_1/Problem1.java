import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;

final public class Problem1
{
   private static Scanner enter = new Scanner(System.in);
   public static void main(String[] args)
     {
	System.out.println("Enter a file name:");
	while (true)
	  {
	     try
	       {
		  System.out.println(Files.readString(Path.of(enter.nextLine())));
	       }
	     catch (final Exception EXCEPTION)
	       {
		  System.err.println("The file does not exist, enter a new name:");
		  continue;
	       }
	     enter.close();
	     break;
	  }
     }
}

	     