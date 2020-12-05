package model;

import java.util.Arrays;
import java.util.Random;

public class Requirement {
    private String id;
    private String title;
    private String status;
    private String type;
    private String description;
    private MyDate deadline;
    private MyDate estimate;
    //private int timeSpent;
    private Time time;
    private TeamMember teamMember;

    public TeamMember getTeamMember() {
        return teamMember;
    }



    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    private TaskList taskList;
    //TODO private TeamMember teamMember;

    public static final String STATUS_UNASSIGNED = "Unassigned";
    public static final String STATUS_IN_PROCESS = "In Process";
    public static final String STATUS_WAITING_FOR_APPROVAL = "Waiting For Approval";
    public static final String STATUS_APPROVED = "Approved";
    public static final String STATUS_REJECTED = "Rejected";

    public static final String TYPE_FUNCTIONAL = "Functional";
    public static final String TYPE_NON_FUNCTIONAL = "Non-functional";
    public static final String TYPE_PROJECT_RELATED = "Project Related";


    //TODO implement MyDate estimate
    public Requirement(String title, String status, String type, String description, MyDate deadline) {//, MyDate estimate) {
        this.id = createReqID();

        setTitle(title);
        setStatus(status);
        setType(type);
        setDescription(description);
        setDeadline(deadline);
        //setEstimate(estimate);



        this.taskList = new TaskList();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || !validStatus(status)) {
            throw new IllegalArgumentException("Illegal status given");
        }
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || !validType(type)) {
            throw new IllegalArgumentException("Illegal type given");
        }
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public MyDate getDeadline() {
        return deadline.copy();
    }

    public void setDeadline(MyDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Null deadline given");
        }
        this.deadline = deadline.copy();
    }

    public MyDate getEstimate() {
        return estimate.copy();
    }

    public void setEstimate(MyDate estimate) {
        if (estimate == null) {
            throw new IllegalArgumentException("Null estimate given");
        }
        this.estimate = estimate.copy();
    }

    /*public int getTimeSpent() {
        return this.time.getTimeWorked();
            }*/
    // TODO: discuss wit Ion, the double value for that is supposed to be here will fuck some things up in the gui

    public void setTimeSpent(int minutes, int hours) {
        this.time.setTime(minutes, hours);
    }

    private static String createReqID() {
        Random random = new Random(System.currentTimeMillis());
        return  "R" + (10000 + random.nextInt(100000));
    }

    private static boolean validStatus(String status) {
        String[] statuses = {STATUS_UNASSIGNED, STATUS_IN_PROCESS, STATUS_WAITING_FOR_APPROVAL, STATUS_APPROVED, STATUS_REJECTED};
        return Arrays.asList(statuses).contains(status);
    }

    private static boolean validType(String type) {
        String[] types = {TYPE_FUNCTIONAL, TYPE_NON_FUNCTIONAL, TYPE_PROJECT_RELATED};
        return Arrays.asList(types).contains(type);
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", estimate=" + estimate +
                ", timeSpent=" +    this.getTimeSpent() +
                ", taskList=" + taskList +
                '}';
    }

    public double getTimeSpent(){
       return this.taskList.getTimeSpent();
    }


}
