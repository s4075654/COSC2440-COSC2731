import java.util.Map;
import java.util.List;
import problem4.Project;
import problem_4.Researcher;
import java.util.LinkedList;
import problem4.Lecturer;

class ProjectMemberMapSuchThat
{
   private Map projectMember;
   
   final public List<Project> returnAListOfProjectsThisPersonIsDoing(final Researcher A_RESEARCHER)
     {
	return switch (A_RESEARCHER)
	  {
	     case FullTimeStudent fullTimeStudent ->
	       {
		  yield switch (fullTimeStudent.FULL_TIME.getOneResearchProject())
		    {
		       case null -> null;
		       default -> new LinkedList<Project>(List.of(fullTimeStudent.FULL_TIME.getOneResearchProject()));
		    };
	       }
	     case Lecturer lecturer ->
	       {
		  yield switch (lecturer.getJoinedProjects().length)
		    {
		       case 0 -> null;
		       default -> new LinkedList<Project>(List.of(lecturer.getJoinedProjects()));
		    };
	       }
	     default -> null;
	  };
     }
   final public void addAProjectToAResearcher(final Project A_PROJECT, final Researcher A_RESEARCHER)
     {
	A_RESEARCHER.listOfProject.add(A_PROJECT);
     }
   final public void removeAProjectFromAAResearcher(final Researcher A_RESEARCHER)
     {
	A_RESEARCHER.listOfProject.remove("a project");
     }
}
