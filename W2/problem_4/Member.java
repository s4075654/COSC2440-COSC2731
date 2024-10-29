package problem_1;

public interface Member
{
   default public void setProfile(String profile)
     {
     }
   
   default public String getProfile()
     {
	return null;
     }
   
}
