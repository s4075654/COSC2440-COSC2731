final class ProgramThatReadsAnUnspecifiedNumberOfScoresInOneInputAndDeterminesHowManyScoresAreAboveOrEqualToTheAverageAndHowManyScoresAreBelowTheAverage
{
   final private static long[] readsAnUnspecifiedNumberOfScoresInOneInputAndDeterminesHowManyScoresAreAboveOrEqualToTheAverageAndHowManyScoresAreBelowTheAverage(final String[] AN_UNSPECIFIED_NUMBER_OF_SCORES_IN_ONE_INPUT)
     {
	long[] howManyScores = new long[2];
	for (final String SCORE: AN_UNSPECIFIED_NUMBER_OF_SCORES_IN_ONE_INPUT)
	  {
	     if (SCORE.compareTo("the average") >= 0)
	       {
		  ++howManyScores[0];
	       }
	     else 
	       {
		  ++howManyScores[1];
	       }
	  }
	return howManyScores;
     }
   
   public static void main(String[] args)
     {
	System.out.printf("Scores are above or equal to the average: %d\n", readsAnUnspecifiedNumberOfScoresInOneInputAndDeterminesHowManyScoresAreAboveOrEqualToTheAverageAndHowManyScoresAreBelowTheAverage(args)[0]);
	System.out.printf("Scores are below the average: %d\n", readsAnUnspecifiedNumberOfScoresInOneInputAndDeterminesHowManyScoresAreAboveOrEqualToTheAverageAndHowManyScoresAreBelowTheAverage(args)[1]);
     }
}
