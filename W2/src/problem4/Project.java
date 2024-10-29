package problem4;

import problem_1.Member;

/**
 * @author COSC2440 Teaching Team
 * @version 1.0
 */

public class Project {
    private String name;
    private double budget;
    private Lecturer leader;
    private Member[] members;
    private final long MAX_MEMBERS = Long.MAX_VALUE;
    private int memberCount = 0;

    public Project() {
        this.name = "Default";
        this.budget = 0;
        members = new Lecturer[(int)MAX_MEMBERS];
    }
    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
        members = new Lecturer[(int)MAX_MEMBERS];
    }
   
   final public String getName()
     {
	return name;
     }
   
   final public void setName(String name)
     {
	this.name = name;
     }
   
   final public double getBudget()
     {
	return budget;
     }
   
   final public void setBudget(double budget)
     {
	this.budget = budget;
     }
   

    /**
     * get the current leader of this project
     * @return the Lecturer who is the leader,
     * or null if there is no leader for this project
     */
    public Lecturer getLeader() {
        return leader;
    }
   
   final public void setLeader(Lecturer leader)
     {
	this.leader = leader;
     }
   
   final public Member[] getMembers()
     {
	return members;
     }
   
   final public void setMembers(Member[] members)
     {
	this.members = members;
     }
   
   final public long getMaxMembers()
     {
	return MAX_MEMBERS;
     }
   
   final public int getMemberCount()
     {
	return memberCount;
     }
   
   final public void setMemberCount(int memberCount)
     {
	this.memberCount = memberCount;
     }
   

    /**
     * assign a new leader for this project
     * <p>
     * Assign the given Lecturer as the new leader for this project.
     * It's the job of the Lecturer class to ensure this assignment
     * is valid. This class just does the assignment
     * </p>
     * @param leader the new leader for this project
     */
    public void assignLeader(Lecturer leader) {
        this.leader = leader;
    }

    /**
     * add a new member to this project
     * <p>
     * Add a new member to this project. At this point, there
     * is no checking at all
     * </p>
     * @param newMember a Lecturer who want to join this project
     */
    public boolean addMember(Lecturer newMember) {
        if (memberCount == MAX_MEMBERS)
            return false;
        /*
           Assume duplication has been handled when adding a new member
           so we do not have to check it
         */
        members[memberCount++] = newMember;
        return true;
    }


    /**
     * display all members in this project (including leader and regular member)
     */
    public void displayMembers() {
        // display leader
        System.out.println("Leader: " + leader);

        // display regular members
        for(int i = 0; i < memberCount; i++) {
            System.out.printf("Member #%d: " + members[i] + "\n", i + 1);
        }
    }
   
   final public String toString()
     {
	return "name: " + name + "\tbudget: " + budget + "\tleader: " + leader + "\tmembers: " + members + "\tMAX_MEMBERS: " + MAX_MEMBERS + "\tmemberCount: " + memberCount;
     }
   
}
