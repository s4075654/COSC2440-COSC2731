import problem_4.Researcher;
import java.util.List;
import problem4.Project;
import java.util.stream.Collectors;

final class Problem3Extension extends ProjectMemberMapSuchThat
{
   final public List<Project> returnAListOfProjectsThisPersonIsDoingInReversedOrderOfBudget(final Researcher A_RESEARCHER)
     {
	return A_RESEARCHER.listOfProject.parallelStream()
	  .sorted((project1, project2) -> Double.compare(project2.getBudget(), project1.getBudget()))
	    .collect(Collectors.toList());
     }
}
