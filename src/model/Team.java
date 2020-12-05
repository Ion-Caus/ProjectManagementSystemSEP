package model;

import java.util.ArrayList;

public class Team {
    private ArrayList<TeamMember>teamMember;

    public Team(){this.teamMember=new ArrayList<>();} //constructor, discuss, not yet included in the diagram



    public void addTeamMember(TeamMember teamMember){this.teamMember.add(teamMember); }

    public void removeTeamMember(TeamMember teamMember){
        this.teamMember.remove(teamMember);
    }

    public TeamMember getTeamMember(String name){
      for (TeamMember teamMember:teamMember){
          if (teamMember.getName().equals(name)){
              return teamMember;
          }
      }
        return null;
    }



}
