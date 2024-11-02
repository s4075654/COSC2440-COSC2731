/** @see java.lang */
final public class Lecturer implements Member
{
   /** @see java.lang */
   private String employeeId, fullName, rank;
   /** @see java.lang */
   private boolean research_project;
   
   /** @see java.lang
    * @param p the project specified in the parameter
    * @return whether the current Lecturer object can lead the project specified in the parameter */
   final private boolean leadProject(Project p)
     {
	/** @see java.lang */
	switch (research_project)
	  {
	     /** @see java.lang */
	   case true:
	     /** @see java.lang */
	     return false;
	     /** @see java.lang */
	   case false:
	     /** @see java.lang */
	     p.oneLeader = this;
	     /** @see java.lang */
	     research_project = true;
	     /** @see java.lang */
	     return research_project;
	  }
     }
   /** @see java.lang
    * @param p a project
    * @return always possible for a lecturer to join a project */
   final public boolean joinProject(Project p)
     {
	/** @see java.lang */
	p.oneMember = this;
	/** @see java.lang */
	return true;
     }
}
