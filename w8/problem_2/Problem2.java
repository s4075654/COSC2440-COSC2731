import java.util.Arrays;

abstract class Animal
{
   abstract void makeSound();
}

final class Dog extends Animal
{
   @Override
     void makeSound()
       {
	  System.out.println("woof");
       }
}
final class Cat extends Animal
{
   @Override
     void makeSound()
       {
	  System.out.println("meow");
       }
}

final public class Problem2
{
   final private static Animal[] PARAMETERS = new Animal[]
     {
	new Dog(),
	new Cat()
     }
   ;
   
   final private static Dog treatMeAsADog(Animal a)
     {
	try
	  {
	     return Dog.class.cast(a);
	  }
	catch (final Exception UNSUCCESSFUL)
	  {
	     System.out.println("Impossible");
	     return null;
	  }
     }
   
   public static void main(String[] args)
     {
	try
	  {
	     Arrays.stream(PARAMETERS)
	       .parallel()
		 .map(parameter -> parameter = treatMeAsADog(parameter))
		   .forEach(animal -> animal.makeSound());
	  }
	catch (final Exception EXCEPTION)
	  {
	     EXCEPTION.printStackTrace();
	  }
     }
}
