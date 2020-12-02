package model;

import java.util.ArrayList;

public class TeamMember {
    private String name;
    private ArrayList<Task> taskForTeamMember;
    private ArrayList<Requirement> requirementsForTeamMember;

    public TeamMember(String name) {
        this.taskForTeamMember = new ArrayList<>();
        this.taskForTeamMember = new ArrayList<>();
        setName(name);
    }

    public void addTask(Task task) {
        if (this instanceof ScrumMaster) {
            throw  new IllegalArgumentException("You can't assign a task to a Scrum master");
        }
        else if(this instanceof ProductOwner){
            throw new IllegalArgumentException("You can't assign a task to a Product owner");
        }
        taskForTeamMember.add(task);
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

    public void addTimeSpentOnTask(Task task, int timeSpent){
        task.setTimeSpent(timeSpent);
    }

    public void  addTimeSpentOnRequirement(Requirement requirement, int timeSpent){
        requirement.setTimeSpent(timeSpent);
    }

    public ArrayList<Task> getTaskList(Project project){
        return taskForTeamMember;
    }

    public ArrayList<Requirement> getRequirementList(Project project){
        return requirementsForTeamMember;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null||name.isEmpty()) throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
    }





}
