package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing the containing element of class Time
 * @see Time
 */
public class TimeContainer implements Serializable {
    private ArrayList<Time> timeContainer;

    /**
     * a zero argument constructor that initializes the ArrayList that contains instances of Time class
     */
    public TimeContainer() {
        this.timeContainer = new ArrayList<>();
    }


    /**
     * Returning how many objects of type Time are stored in the Arraylist
     *
     * @return   number of elements in the Arraylist as an integer
     */
    public int size() {
        return timeContainer.size();
    }

    /**
     * will return the instance of class Time with the provided instance number
     * @param index the number under which the instance of class is indexed in containing element
     * @return instance of class Time
     */
    public Time get(int index) {
        return timeContainer.get(index);
    }


    /**
     * will turn String input that can have number followed by letter(d-represents day, h-represents hour, m-represents minute) into minutes of type int, for example input 1d 3h 40m will be returned as 1660 minutes
     * @param timeString input in a form of a String that will be turned into
     * @return time spent on project in minutes, as an int
     * @exception IllegalArgumentException will be thrown in case the input is empty
     * @exception  IllegalArgumentException will be thrown in case other character than number and d, h or m is provided
     */
    public int convertToInteger(String timeString) {
        if (timeString == null || timeString.isEmpty()) {
            throw new IllegalArgumentException("Please enter the time.");
        }

        if ( !timeString.toLowerCase().strip().matches("(\\d+[dhmDHM]\\s?)+") ) {
            throw new IllegalArgumentException("Usage: [3d 1h 42m]");
        }

        int minutes = 0;
        for (String part: timeString.split(" ")){
            if (part.toLowerCase().contains("d")) {
                //get just the number
                part = part.replaceAll("\\D+","");
                minutes += Integer.parseInt(part) * 24 * 60;
            }
            if (part.toLowerCase().contains("h")) {
                //get just the number
                part = part.replaceAll("\\D+","");
                minutes += Integer.parseInt(part) * 60;
            }
            if (part.toLowerCase().contains("m")) {
                //get just the number
                part = part.replaceAll("\\D+","");
                minutes += Integer.parseInt(part);
            }
        }
        return minutes;
    }
    // TODO: 16/12/2020 by Tomas Brezny ask Ion if the method bellow works as described
    /**
     * will check if team member is already added, in case yes it will increase his time spent on task by inputted ammount, in case Team Member is not yet added, it will add him and add time the inputted time worked on task 
     * @param teamMember the team member that for whom time spent should be added
     * @param minutes the time spent on task
     */
    public void addTimeWorkedFor(TeamMember teamMember, String minutes) {
        boolean createNew = true;

        for (Time time: timeContainer) {
            if (time.getTeamMember().equals(teamMember)) {
                time.addTime(convertToInteger(minutes));
                createNew = false;
                break;
            }
        }

        if (createNew) {
            timeContainer.add(new Time(convertToInteger(minutes), teamMember));
        }
    }


    /**
     * will return the total time work on task by selected Team Member
     * @param teamMember the team member as an instance of class TeamMember
     * @return time spent by selected Team Member
     */
    public String getTimeWorkedBy(TeamMember teamMember){
        for (Time time: timeContainer) {
            if (time.getTeamMember().equals(teamMember)) {
                return time.getTimeWorked();
            }
        }
        throw new NullPointerException("No such team member in the team.");
    }

    /**
     * @return the total time worked by all team members on selected task
     */
    public int getTotalTimeWorked(){
        int minutes = 0;
        for (Time time : timeContainer) {
            minutes += time.getMinute();
        }
        return minutes;
    }

}