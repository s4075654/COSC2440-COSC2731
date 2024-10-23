import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

final class ProgramThatGenerates100RandomIntegersBetween0And9ThenDisplaysTheCountForEachNumber
{
   final private static Map<Integer, Byte> generates100RandomIntegersBetween0And9()
     {
	Map<Integer, Byte> randomIntegersBetween0And9 = new HashMap<>(10);
	for (byte count = 0; count < 100; ++count)
	  {
	     final Integer randomInteger = ThreadLocalRandom.current().nextInt(0, 9 + 1);
	     randomIntegersBetween0And9.put(randomInteger, (byte)(randomIntegersBetween0And9.getOrDefault(randomInteger, (byte)0) + 1));
	  }
	return randomIntegersBetween0And9;
     }
   final private static void displaysTheCountForEachNumber(final Map<Integer, Byte> INTEGERS_BETWEEN_0_AND_9)
     {
	INTEGERS_BETWEEN_0_AND_9.values().stream()
	  .forEach(countForEachNumber -> System.out.printf("%d ", countForEachNumber));
	System.out.println();
     }
   
   public static void main(String[] args)
     {
	displaysTheCountForEachNumber(generates100RandomIntegersBetween0And9());
     }
}
