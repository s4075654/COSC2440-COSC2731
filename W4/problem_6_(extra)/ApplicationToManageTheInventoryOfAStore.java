import java.util.ArrayList;

abstract class SomePeople
{
   abstract void getNotifications();
}

final class InventoryOfAStore
{
   final class ProductType
     {
	private double in, aThreshold, anotherThreshold;
	final private ArrayList<SomePeople> THOSE_PEOPLE = new ArrayList<SomePeople>();
	
	final private void getNotificationsAsSoonAsTheAmountIsBelowAThresholdOrAboveAnotherThreshold()
	  {
	     THOSE_PEOPLE.parallelStream()
	       .forEach(person -> person.getNotifications());
	  }
     }
   final private ArrayList<ProductType> THE_INVENTORY_OF_A_STORE = new ArrayList<ProductType>();
   final private void isBelowAThresholdOrAboveAnotherThreshold()
     {
	THE_INVENTORY_OF_A_STORE.parallelStream()
	  .forEach(aSpecificProductType -> 
		   {
		      switch (aSpecificProductType)
			{
			 case final ProductType A_SPECIFIC_PRODUCT_TYPE when (A_SPECIFIC_PRODUCT_TYPE.in < A_SPECIFIC_PRODUCT_TYPE.aThreshold || A_SPECIFIC_PRODUCT_TYPE.in > A_SPECIFIC_PRODUCT_TYPE.anotherThreshold):
			   A_SPECIFIC_PRODUCT_TYPE.getNotificationsAsSoonAsTheAmountIsBelowAThresholdOrAboveAnotherThreshold();
			 default:
			}
		   }
		   );
     }
}