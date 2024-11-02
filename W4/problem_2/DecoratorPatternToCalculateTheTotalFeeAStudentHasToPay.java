import java.util.ArrayList;

abstract class Student
{
   private String id;
   private String name;
   final private String GPA = new String();
   private ArrayList<String> courses = new ArrayList<String>();
   
   final protected ArrayList<String> getCourses()
     {
	return courses;
     }
   
   abstract double calcFee();
}

abstract class RegularStudent extends Student
{
   private double theFee;
   private RegularStudent(double courseUnitFee)
     {
	theFee = getCourses().size() * courseUnitFee;
     }
   final double getTheFee()
     {
	return theFee;
     }
}

class DecoratorPattern extends Student
{
   RegularStudent aStudent;
   
   double calcFee()
     {
	return aStudent.getTheFee();
     }
}

final class FeesAreHigherBecauseOfLatePayments extends DecoratorPattern
{
   double calcFee()
     {
	return super.calcFee() + (super.calcFee() * 10 / 100);
     }
}

final class FeesAreDecreasedByAFixedAmount extends DecoratorPattern
{
   double calcFee()
     {
	return (1000 <= super.calcFee()) ? super.calcFee() - 1000 : super.calcFee();
     }
}
