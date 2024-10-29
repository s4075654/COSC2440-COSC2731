package problem4;

import problem_1.Member;
import problem_4.Researcher;

/**
 * @author COSC2440 Teaching Team
 * @version 1.0
 */

public class Lecturer implements Member, Researcher {
    private String employeeId;
    private String fullName;
    private String rank;
    private Project projectLed;
    // assume the maximum number of projects a lecturer can join at one time is 10
    private final long MAX_PROJECTS = Long.MAX_VALUE;
    private Project[] joinedProjects;
    private int projectCount = 0;

    public Lecturer()  {
        this.employeeId = "Default";
        this.fullName = "Default";
        this.rank = "Default";
        joinedProjects = new Project[(int)MAX_PROJECTS];
    }
    public Lecturer(String employeeId, String fullName, String rank) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.rank = rank;
        joinedProjects = new Project[(int)MAX_PROJECTS];
    }

    /**
     * assign the current lecturer as the leader of a project
     * <p>
     * Given a project, assign the current lecturer as its leader.
     * If the assignment is successful, return true,
     * otherwise, return false
     * </p>
     * @param p the project to lead
     * @return true if the assignment is successful, otherwise, return false
     */
    public boolean leadProject(Project p) {
        /*
          two conditions below must satisfy
          the lecturer has no project to lead
          the assigned project has no leader
         */
        if (!isLeading() && p.getLeader() == null) {
            projectLed = p;
            p.assignLeader(this);
            return true;
        }
        return false;
    }

    /**
     * assign the current lecturer as a member of a project
     * <p>
     * Join a project as a member. It's the job of the Project class
     * to check for validity of this action or to check if
     * this Lecturer member exists in the project already
     * </p>
     * @param p the project to join
     * @return true if the assignment is successful, otherwise, return false
     */
    public boolean joinProject(Project p) {
        // Short-circuit evaluation, if the first condition is false
        // the second condition will not be evaluated
        if (projectCount < 10 && p.addMember(this)) {
            this.joinedProjects[projectCount++] = p;
            return true;
        }
        return false;
    }

    /**
     * check if the current lecturer is leading any project
     * @return true if the current lecturer is leading any project, false if not
     */
    public boolean isLeading() {
        return projectLed != null;
    }

    public String getEmployeeId() {
        return employeeId;
    }
   
   final public void setEmployeeId(String employeeId)
     {
	this.employeeId = employeeId;
     }
   

    public String getFullName() {
        return fullName;
    }
   
   final public void setFullName(String fullName)
     {
	this.fullName = fullName;
     }
   

    public String getRank() {
        return rank;
    }
   
   final public Project getProjectLed()
     {
	return projectLed;
     }
   
   final public void setProjectLed(Project projectLed)
     {
	this.projectLed = projectLed;
     }
   
   final public long getMaxProjects()
     {
	return MAX_PROJECTS;
     }
   

    public Project[] getJoinedProjects() {
        return joinedProjects;
    }
   
   final public void setJoinedProjects(Project[] joinedProjects)
     {
	this.joinedProjects = joinedProjects;
     }
   
   final public int getProjectCount()
     {
	return projectCount;
     }
   
   final public void setProjectCount(int projectCount)
     {
	this.projectCount = projectCount;
     }
   

    /**
     * set the rank of a lecturer
     * <p>
     * Given a rank, assign the rank for the current lecturer
     * If the assignment is successful, return true,
     * otherwise, return false
     * </p>
     * @param rank the rank to set for the lecturer
     * @return true if the assignment is successful, otherwise, return false
     */
    public boolean setRank(String rank) {
        String [] rankList = {"Assoc Lecturer" , "Lecturer", "Senior Lecturer"};
        boolean checked = false;
        for (String availableRank: rankList){
            if (availableRank.equals(rank))
                checked = true;
        }
        if (checked){
            this.rank = rank;
            return true;
        }
        return false;
    }

    /**
     * String representation of this lecturer
     * <p>
     * This method is called automatically when you use a Lecturer object
     * in places where a String value is required.
     * </p>
     */
    @Override
    public String toString() {
        // String.format() is similar to printf, but it return instead of display
        return String.format("Id: %s, Name: %s, Rank: %s",
                employeeId, fullName, rank);
    }
}
