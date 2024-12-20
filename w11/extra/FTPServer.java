import java.net.DatagramSocket;
import java.util.Queue;
import java.net.DatagramPacket;
import java.util.ArrayDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;
import java.net.SocketAddress;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.StandardOpenOption;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

final public class FTPServer
{
   static DatagramSocket serverSocket = null;
   static
     {
	try
	  {
	     serverSocket = new DatagramSocket(9876);
	  }
	catch (final Exception EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
     }
   final private static ThreadPoolExecutor A_THREAD_POOL = ThreadPoolExecutor.class.cast(Executors.newFixedThreadPool(4));
   private static Queue<DatagramPacket> packets = new ArrayDeque<DatagramPacket>();
   private static DatagramPacket packet = new DatagramPacket(new byte[0], 0);
   
   public static void main(String[] args)
     {
	while (true)
	  {
	     switch (Integer.valueOf(A_THREAD_POOL.getActiveCount()))
	       {
		case final Integer CLIENTS when CLIENTS > 0 && CLIENTS < 4:
		  A_THREAD_POOL.submit(new WorkerThread(packets.poll()));
		default:
		  try
		    {
		       serverSocket.receive(packet);
		    }
		  catch (final Exception EXCEPTION)
		    {
		       EXCEPTION.printStackTrace();
		    }
		  packets.add(packet);
	       }
	  }
     }   
}

final class WorkerThread implements Runnable
{
   final private ByteArrayInputStream INPUT_STREAM;
   private enum Load
     {
	DOWNLOAD, UPLOAD
     }
   
   Load can;
   final SocketAddress ADDRESS;
   
   WorkerThread(final DatagramPacket PACKET)
     {
	INPUT_STREAM = new ByteArrayInputStream(PACKET.getData(), 0, PACKET.getLength());
	ADDRESS = PACKET.getSocketAddress();
     }
   
   final private DatagramPacket send(final Path... THE_FILE_NAME)
     {
	switch (THE_FILE_NAME.length)
	  {
	   case 0:
	     try (final DirectoryStream<Path> FOLDERS = Files.newDirectoryStream(Path.of("."), Files::isDirectory))
	       {
		  List<Path> theFolderList = new ArrayList<Path>();
		  for (final Path FOLDER: FOLDERS)
		    {
		       theFolderList.add(FOLDER);
		    }
		  try (final ByteArrayOutputStream STREAM = new ByteArrayOutputStream();
		       final ObjectOutputStream OUTPUT_STREAM = new ObjectOutputStream(STREAM))
		    {
		       OUTPUT_STREAM.writeObject(theFolderList);
		       OUTPUT_STREAM.flush();
		       return new DatagramPacket(STREAM.toByteArray(), STREAM.toByteArray().length, ADDRESS);
		    }
	       }
	     catch (final Exception EXCEPTION)
	       {
		  EXCEPTION.printStackTrace();
	       }
	   default:
	     try (final ByteArrayOutputStream STREAM = new ByteArrayOutputStream();
		  final ObjectOutputStream OUTPUT_STREAM = new ObjectOutputStream(STREAM))
	       {
		  OUTPUT_STREAM.writeUTF(THE_FILE_NAME[0].toString());
		  OUTPUT_STREAM.write(Files.readAllBytes(THE_FILE_NAME[0]));
		  OUTPUT_STREAM.flush();
		  return new DatagramPacket(STREAM.toByteArray(), STREAM.toByteArray().length, ADDRESS);
	       }
	     catch (final Exception EXCEPTION)
	       {
		  EXCEPTION.printStackTrace();
	       }
	  }
	return null;
     }
   final private void createAFileIn(final Path THE_CHOSEN_FILE, final String THE_DATA_THAT_IS_SENT_FROM_THE_CLIENT)
     {
	try
	  {
	     Files.write(THE_CHOSEN_FILE, THE_DATA_THAT_IS_SENT_FROM_THE_CLIENT.getBytes(), StandardOpenOption.CREATE);
	  }
	catch (final Exception EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
     }
   
   @Override
   public void run()
       {
	  try (final ObjectInputStream STREAM = new ObjectInputStream(INPUT_STREAM))
	    {
	       can = Load.valueOf(STREAM.readUTF());
	       switch (can)
		 {
		  case DOWNLOAD:
		    FTPServer.serverSocket.send(send(Path.of(STREAM.readUTF())));
		    break;
		  case UPLOAD:
		    createAFileIn(Path.of(STREAM.readUTF()), STREAM.readUTF());
		    break;
		  default:
		    FTPServer.serverSocket.send(send());
		 }
	    }
	  catch (final Exception EXCEPTION)
	    {
	       EXCEPTION.printStackTrace();
	    }
       }
}
