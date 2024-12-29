import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

final class JavaProgramThatAllowsUsersToEnterAListOfIntegers
{
   final private static List<Integer> A_LIST_OF_INTEGERS = new ArrayList<Integer>();
   final private static Scanner ENTER = new Scanner(System.in);
   
   final private static void allow()
     {
	while (ENTER.hasNextInt())
	  {
	     A_LIST_OF_INTEGERS.add(ENTER.nextInt());
	  }
     }
   
   final private static void saveThisListOfIntegersInABinaryFileAndInATextFile()
     {
	A_LIST_OF_INTEGERS.parallelStream()
	  .forEach(integer ->
		   {
		      try (final DataOutputStream SAVE = new DataOutputStream(new FileOutputStream("a binary file")))
			{
			   Files.write(Path.of("a text file"), A_LIST_OF_INTEGERS.parallelStream()
				       .map(String::valueOf)
				       .collect(Collectors.toList()));
			   SAVE.writeInt(integer);
			}
		      catch (final Exception EXCEPTION)
			{
			}
		   }
		   );
     }
   
   public static void main(String[] args)
     {
	allow();
	saveThisListOfIntegersInABinaryFileAndInATextFile();
	
	ENTER.close();
     }
}
