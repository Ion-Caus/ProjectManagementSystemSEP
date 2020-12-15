package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

/**
 * A class representing a project
 *
 *
 */
public class Project implements Serializable {
    private String id;
    private String name;
    private String status;
    private LocalDate deadline;
    private LocalDate estimate;
    private int timeSpent;

    private RequirementList requirementList;
    private Team team;

    public static final String STATUS_CREATED = "Created";
    public static final String STATUS_IN_PROCESS = "In process";
    public static final String STATUS_WAITING_FOR_APPROVAL = "Waiting for approval";
    public static final String STATUS_FINISHED = "Finished";


    /**
     * @param name project name
     * @param status  projects status
     * @param deadline date of projects deadline
     * @param estimate estimated date of project completition
     * @param team  team assigned to project
     */
    public Project(String name,String status, LocalDate deadline, LocalDate estimate, Team team) {
        this.id = createProjectID();

        setName(name);
        setStatus(status);
        setDeadline(deadline);
        setEstimate(estimate);
        setTeam(team);
        this.timeSpent = 0;

        this.requirementList = new RequirementList();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * sets projects name, verifies that user input is not empty
     * @param name project name
     */
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    /**
     * @return returns projects status
     */
    public String getStatus() {
        return status;
    }

    /**
     * checks if input is not empty and is valid, sets project status
     * @param status input status
     */
    public void setStatus(String status) {
        if(status == null || !validStatus(status)) {
            throw new IllegalArgumentException("Illegal status given");
        }
        this.status = status;
    }

    /**
     * @return will return the list of all requirements in specific project
     */
    public RequirementList getRequirementList() {
        return requirementList;
    }


    /**
     * @return project deadline
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * @param deadline input dealdine
     * checks if deadline input is not empty, add deadline
     */
    public void setDeadline(LocalDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Null deadline given");
        }
        this.deadline = deadline;
    }

    /**
     * @return will return estimated date of project completion
     */
    public LocalDate getEstimate() {
        return this.estimate;
    }

    /**
     * @param estimate input project deadline
     * will check if the project deadline date is not empty and set it
     */
    public void setEstimate(LocalDate estimate) {
        if (estimate == null) {
            throw new IllegalArgumentException("Null estimate given");
        }
        this.estimate = estimate;
    }

    /**
     * @return will return project's team in a form of Team class
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team will check if input is not empty and will assign team to the project
     */
    public void setTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Null team given");
        }
        this.team = team;
    }

    /**
     * @return will return total time spent on project
     * total time spent on project is calculated as sum of time spent on all tasks in every requirement that the project has
     */
    public int getTimeSpent() {
        return timeSpent;
    }

    /**
     * this method is used to update total time spent on project
     */
    public void updateTimeSpent() {
        int minutes = 0;
        for (int i = 0; i < requirementList.size(); i++) {
            minutes += requirementList.getRequirement(i).getTimeSpent();
        }
        this.timeSpent = minutes;
    }

    //TODO public ProductOwner getProductOwner(){}
    //TODO public ScrumMaster getScrumMaster(){}

    /**
     * creates projects ID by combining letter P, whhich stands for projects, with random number
     * @return  letter P combined with random number
     */
    private static String createProjectID() {
        Random random = new Random(System.currentTimeMillis());
        return  "P" + (10000 + random.nextInt(90000));
    }

    /**
     * method to check if status is valid, will compare input with array of valid statuses and if its contained in it, will return true, otherwise will return false
     * @param status input status
     * @return
     */
    private static boolean validStatus(String status) {
        String[] statuses = {STATUS_CREATED, STATUS_IN_PROCESS, STATUS_WAITING_FOR_APPROVAL, STATUS_FINISHED};
        return Arrays.asList(statuses).contains(status);
    }

    /**
     * @return will return all Project details as a string
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                ", deadline=" + deadline.toString() +
                ", estimate=" + estimate.toString() +
                ", timeSpent=" + timeSpent +
                ", requirementList=" + requirementList +
                ", team=" + team.getTeamMemberNameList() +
                '}';
    }
}