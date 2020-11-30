package model;

import java.util.ArrayList;

public class Team {
    private ArrayList<TeamMember>teamMember;

    public Team(){this.teamMember=new ArrayList<>(teamMember);} //constructor, discuss, not yet included in the diagram



    public void addTeamMember(TeamMember teamMember){this.teamMember.add(teamMember); }

    public void removeTeamMember(TeamMember teamMember){
        this.teamMember.remove(teamMember);
    }

    public TeamMember getTeamMember(String name){
       return this.teamMember.get(teamMember.indexOf(name));
    }

}
