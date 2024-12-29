import java.util.Scanner;
import java.io.File;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

final public class JavaProgramThatAsksTheUserToEnterATextFileName implements NativeKeyListener
{
   private static Scanner enter = new Scanner(System.in);
   
   final private static File Ask()
     {
	System.out.println("Enter a text file name:");
	return new File(enter.nextLine());
     }
   final private static void displayTheContentOfTheFileLineByLineUntilEitherTheEndOfTheFileIsReached(final File A_TEXT_FILE_NAME)
     {
	GlobalScreen.addNativeKeyListener(new JavaProgramThatAsksTheUserToEnterATextFileName());
	try
	  {
	     enter = new Scanner(A_TEXT_FILE_NAME);
	     while (enter.hasNextLine())
	       {
		  System.out.println(enter.nextLine());
	       }
	  }
	catch (final Exception EXCEPTION)
	  {
	  }
     }
   
   public void nativeKeyPressed(final NativeKeyEvent PRESS)
     {
	switch (PRESS.getKeyCode())
	  {
	   case NativeKeyEvent.VC_X:
	     System.exit(0);
	  }
     }
   
   public static void main(String[] args)
     {
	try
	  {
	     GlobalScreen.registerNativeHook();
	  }
	catch (final Exception EXCEPTION)
	  {
	  }
	
	displayTheContentOfTheFileLineByLineUntilEitherTheEndOfTheFileIsReached(Ask());
	enter.close();
     }
}
