package model;

import java.io.Serializable;

/**
 * A class representing a team member
 */
public class TeamMember implements Serializable {
    /**
     * name of the team member
     */
    private String name;

    /**
     * a one argument constructor that will check if the parameter name is not empty and  initialize TeamMember class with provided name
     * @param name name of the team member in a form of a String
     */
    public TeamMember(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        this.name = name;
    }

    /**
     * @return name of team member
     */
    public String getName() {
        return name;
    }

    /**
     * will return the role of the  Team Member, in this class it can only return a fixed String because if a Team Member is assigned as a Scrum Master or a Product Owner, subclass of class TeamMember will be instantiated and saved
     * @see ProductOwner
     * @see ScrumMaster
     * @return role of the Team Member, which in this class can only be "Team Member"
     */
    public String getRole() {
        return "Team Member";
    }

    /**
     * will return true if the provided object is an instance of this class TeamMember
     * @param obj the object that will be compared with class TeamMember
     * @return bool
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) obj;
        return this.name.equals(other.getName());
    }

    /**
     * @return a copy of class TeamMember
     */
    public TeamMember copy() {
        return new TeamMember(name);
    }
}
