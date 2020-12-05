package model;

public class Time {
    private int hour;
    private int minute;
    private TeamMember teamMember;

    public Time(int hour, int minute){
       setTime(hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setTime(int hour, int minute){
        this.hour=hour;
        this.minute=minute;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public double getTimeWorked(){
       return (this.hour*60)+this.minute;
    }


}
