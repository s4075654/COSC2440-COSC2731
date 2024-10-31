import problem_4.Researcher;
import problem3.Student;
import problem_4.Member;
import problem4.Project;

final public class FullTimeStudent implements Researcher
{
   final public class FullTime extends Student implements Member
     {
	private Project oneResearchProject;
	
	final public Project getOneResearchProject()
	  {
	     return oneResearchProject;
	  }
	
	final public void setOneResearchProject(final Project ONE_RESEARCH_PROJECT)
	  {
	     this.oneResearchProject = ONE_RESEARCH_PROJECT;
	  }
   
	final public void optionallyJoinOneResearchProject(final Project ONE_RESEARCH_PROJECT)
	  {
	     this.oneResearchProject = ONE_RESEARCH_PROJECT;
	  }
     }
   
   final public FullTime FULL_TIME = new FullTime();
}
