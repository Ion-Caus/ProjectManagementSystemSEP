package model;

import java.util.ArrayList;

public class TimeContainer {

    private ArrayList<Time> timeContainer;

    public TimeContainer() {
        this.timeContainer = new ArrayList<>();
    }


    public double getTimeWorked(TeamMember teamMember){
           return timeContainer.get(timeContainer.indexOf(this)).getTimeWorked();


    }

    public double getTimeWorked(){
        int minutes=0;
        for (Time time : timeContainer) {
            minutes += time.getTimeWorked();

        }
        return minutes;
    }


}