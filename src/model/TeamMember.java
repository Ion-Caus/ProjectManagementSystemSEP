package model;

import java.util.ArrayList;

public class TeamMember {
    private String name;


    public TeamMember(String name) {
        setName(name);
    }

    public void addTask(Task task, Requirement requirement) {
        if (this instanceof ScrumMaster) {
            throw  new IllegalArgumentException("You can't assign a task to a Scrum master");
        }
        else if(this instanceof ProductOwner){
            throw new IllegalArgumentException("You can't assign a task to a Product owner");
        }
       requirement.getTaskList().addTask(task);
    }

    public void removeTask(Task task, Requirement requirement){
        requirement.getTaskList().removeTask(task);
    }



    public void completeTask(Task task){
        task.setStatus(Task.STATUS_COMPLETED);
    }

    public void startWorkingOnTask(Task task){
        task.setStatus(Task.STATUS_IN_PROCESS);
    }

    public void startWorkingOnRequirement(Requirement requirement){
        requirement.setStatus(Requirement.STATUS_IN_PROCESS);
    }

    public void stopWorkingOnTask(Task task){
        task.setStatus(Task.STATUS_COMPLETED);
    }

    public void stopWorkingOnRequirement(Requirement requirement){
        requirement.setStatus(Requirement.STATUS_WAITING_FOR_APPROVAL);
    }

   /* public void addTimeSpentOnTask(Task task, int hours, int minutes){
        task.setTimeSpent(timeSpent);
    }*/

    public void  addTimeSpentOnRequirement(Requirement requirement, int minutes, int hours){
        requirement.setTimeSpent(minutes, hours);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null||name.isEmpty()) throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
    }





}
