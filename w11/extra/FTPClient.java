import java.net.DatagramSocket;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.nio.file.Path;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.net.InetSocketAddress;

final public class FTPClient
{
   private static DatagramSocket aSocket;
   static
     {
	try
	  {
	     aSocket = new DatagramSocket();
	  }
	catch (final Exception EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
     }
   final private static Scanner TAKE_THE_INPUT_FROM_THE_CLIENTS = new Scanner(System.in);
   private enum Load
     {
	DOWNLOAD, UPLOAD
     }
   final private static Load OPTION = Load.valueOf(TAKE_THE_INPUT_FROM_THE_CLIENTS.nextLine());
   
   public static void main(String[] args)
     {
	switch (OPTION)
	  {
	   case Load.DOWNLOAD:
	     DatagramPacket theDataThatIsSentFromTheServer = new DatagramPacket(new byte[0], 0);
	     try
	       {
		  aSocket.receive(theDataThatIsSentFromTheServer);
		  Files.write(Path.of("a file in the current directory"), theDataThatIsSentFromTheServer.getData(), StandardOpenOption.CREATE);
	       }
	     catch (final Exception EXCEPTION)
	       {
		  EXCEPTION.printStackTrace();
	       }
	     break;
	   case Load.UPLOAD:
	     final Path FILE = Path.of(".", TAKE_THE_INPUT_FROM_THE_CLIENTS.nextLine());
	     final byte[] THE_FILE_NAME = FILE.toString().getBytes();
	     byte[] theData = new byte[0];
	     try
	       {
		  theData = Files.readAllBytes(FILE);
	       }
	     catch (final Exception EXCEPTION)
	       {
		  EXCEPTION.printStackTrace();
	       }
	     byte[] theFileNameAndTheData = new byte[THE_FILE_NAME.length + theData.length];
	     System.arraycopy(THE_FILE_NAME, 0, theFileNameAndTheData, 0, THE_FILE_NAME.length);
	     System.arraycopy(theData, 0, theFileNameAndTheData, THE_FILE_NAME.length, theData.length);
	     try
	       {
		  aSocket.send(new DatagramPacket(theFileNameAndTheData, theFileNameAndTheData.length, new InetSocketAddress(9876)));
	       }
	     catch (final Exception EXCEPTION)
	       {
		  EXCEPTION.printStackTrace();
	       }
	     break;
	  }
	TAKE_THE_INPUT_FROM_THE_CLIENTS.close();
	aSocket.close();
     }
}
