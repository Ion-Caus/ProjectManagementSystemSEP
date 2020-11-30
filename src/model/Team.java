package model;

import java.util.ArrayList;

public class Team {
    private ArrayList<TeamMember> teamMember=new ArrayList<TeamMember>();

    public void addTeamMember(TeamMember teamMember){
       try {
           this.teamMember.add(teamMember);
       }
       catch (Exception e){
           System.out.println(e);

       }
    }

    public void removeTeamMember(TeamMember teamMember){
        this.teamMember.remove(teamMember);
    }

    public TeamMember getTeamMember(String name){
       return this.teamMember.get(teamMember.indexOf(name));
    }

}
