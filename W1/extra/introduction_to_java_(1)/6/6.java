import java.util.Scanner;
import java.util.InputMismatchException;

final class ProgramThatPromptsTheUserToEnterTheCenterCoordinatesAndRadiusesOfTwoCirclesAndDeterminesWhetherTheSecondCircleIsInsideTheFirstOrOverlapsWithTheFirst
{
   final private static class Coordinates
     {
	private double xCoordinate;
	private double yCoordinate;
     }
   final private static class Circle
     {
	private Coordinates theCenterCoordinates;
	private double radius;
	
	private Circle()
	  {
	     theCenterCoordinates = new Coordinates();
	  }
     }
   
   final private static Circle promptsTheUserToEnterTheCenterCoordinatesAndRadius()
     {
	System.out.print("Enter the center coordinates: ");
	final Scanner ENTER = new Scanner(System.in);
	Circle circle = new Circle();
	try 
	  {
	     circle.theCenterCoordinates.xCoordinate = ENTER.nextDouble();
	     circle.theCenterCoordinates.yCoordinate = ENTER.nextDouble();
	  }
	catch (InputMismatchException exception)
	  {
	  }
	System.out.print("And radius: ");
	try 
	  {
	     circle.radius = ENTER.nextDouble();
	  }
	catch (InputMismatchException exception)
	  {
	  }
	return circle;
     }
   final private static void determinesWhetherTheSecondCircleIsInsideTheFirstOrOverlapsWithTheFirst(final Circle[] TWO_CIRCLES)
     {
	final double THE_DISTANCE_BETWEEN_TWO_CENTERS = Math.sqrt(Math.pow(TWO_CIRCLES[0].theCenterCoordinates.xCoordinate - TWO_CIRCLES[1].theCenterCoordinates.xCoordinate, 2) + Math.pow(TWO_CIRCLES[0].theCenterCoordinates.yCoordinate - TWO_CIRCLES[1].theCenterCoordinates.yCoordinate, 2));
	switch (THE_DISTANCE_BETWEEN_TWO_CENTERS)
	  {
	   case double theDistanceBetweenTwoCenters when theDistanceBetweenTwoCenters <= Math.abs(TWO_CIRCLES[0].radius - TWO_CIRCLES[1].radius):
	     System.out.println("The second circle is inside the first.");
	     break;
	   case double theDistanceBetweenTwoCenters when (theDistanceBetweenTwoCenters <= TWO_CIRCLES[0].radius + TWO_CIRCLES[1].radius):
	     System.out.println("Overlaps with the first.");
	     break;
	   default:
	     System.out.println("Cover.");
	  }
     }
   
   public static void main(String[] args)
     {
	Circle[] twoCircles = new Circle[2];
	for (byte circle = 0; circle < 2; ++circle)
	  {
	     twoCircles[circle] = promptsTheUserToEnterTheCenterCoordinatesAndRadius();
	  }
	determinesWhetherTheSecondCircleIsInsideTheFirstOrOverlapsWithTheFirst(twoCircles);
     }
}
