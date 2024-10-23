final class MethodThatTakesAStringAndReturnsItsReverse
{
   final private static String takesAStringAndReturnsItsReverse(final String A_STRING)
     {
	return new StringBuilder(A_STRING).reverse().toString();
     }
   
   public static void main(String[] args)
     {
	System.out.println(takesAStringAndReturnsItsReverse("a string"));
     }
}
