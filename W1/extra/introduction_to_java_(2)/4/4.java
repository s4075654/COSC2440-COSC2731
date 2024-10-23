final class MethodThatChecksIfAGivenStringIsAPalindromeOrNot
{
   final private static boolean checksIfAGivenStringIsAPalindromeOrNot(final String A_GIVEN_STRING)
     {
	String ignoring = A_GIVEN_STRING.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
	String aPalindrome = new StringBuilder(ignoring).reverse().toString();
	
	return ignoring.equalsIgnoreCase(aPalindrome);
     }
   
   public static void main(String[] args)
     {
	System.out.println(checksIfAGivenStringIsAPalindromeOrNot("a given string"));
     }
}
