package model;

public class Time {
    private int minute;
    private TeamMember teamMember;

    public Time(int hour){
       setTime(hour);
    }



    public int getMinute() {
        return minute;
    }

    public void setTime(int minute){

        this.minute=minute;
    }

    public void addTime(int minute){
        this.minute+=minute;
    }

    public void incrementTime(int minute){
        this.minute+=minute;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }




}
