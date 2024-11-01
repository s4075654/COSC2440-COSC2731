import java.util.Set;
import problem4.Lecturer;

final class LeaderSet
{
   private Set<Lecturer> aSetOfLeaders;
   
   final public boolean checkWhetherALecturerIsLeadingAProjectOrNot(final Lecturer A_LECTURER)
     {
	return aSetOfLeaders.contains(A_LECTURER);
     }
   final public void addALecturerToTheSet(final Lecturer A_LECTURER)
     {
	aSetOfLeaders.add(A_LECTURER);
     }
   final public void removeALecturerFromTheSet(final Lecturer A_LECTURER)
     {
	aSetOfLeaders.remove(A_LECTURER);
     }
}
