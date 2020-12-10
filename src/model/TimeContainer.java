package model;

import java.util.ArrayList;

public class TimeContainer {

    private ArrayList<Time> timeContainer;

    public TimeContainer() {
        this.timeContainer = new ArrayList<>();
    }


    public double getTimeWorked(TeamMember teamMember){
           for(Time time:timeContainer){
               if (time.getTeamMember().equals(teamMember)){
                   return time.getMinute();
               }

           }
           return 0;
    }

    public double getTimeWorked(){
        int minutes=0;
        for (Time time : timeContainer) {
            minutes += time.getMinute();

        }
        return minutes;
    }

    public void setTimeWorked(TeamMember teamMember, int minutes){
        for (Time time : timeContainer) {
            if (time.getTeamMember().equals(teamMember)) {
                time.setTime(minutes);
            }
        }
    }




}