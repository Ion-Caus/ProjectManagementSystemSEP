package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

/**
 * A class representing a projects requirement
 */
public class Requirement implements Serializable {
    private String id;
    private String title;
    private String status;
    private String type;
    private String description;
    private LocalDate deadline;
    private LocalDate estimate;

    private int timeSpent;

    private TaskList taskList;
    private TeamMember responsibleTeamMember;

    public static final String STATUS_NOT_STARTED = "Not Started";
    public static final String STATUS_IN_PROCESS = "In Process";
    public static final String STATUS_WAITING_FOR_APPROVAL = "Waiting For Approval";
    public static final String STATUS_APPROVED = "Approved";
    public static final String STATUS_REJECTED = "Rejected";

    public static final String TYPE_FUNCTIONAL = "Functional";
    public static final String TYPE_NON_FUNCTIONAL = "Non-functional";
    public static final String TYPE_PROJECT_RELATED = "Project Related";


    /**
     * a 7 argument constructor that initializes the class Requirement
     *
     * @param title the title(name) of the requirement in a form of String
     * @param status the status of the requirement in a form of String
     * @param type  the type of the requirement(functional, non functional, project-related) in a form of String
     * @param description  the description of the requirement in a form of a String
     * @param deadline the date when requirement needs to be finished in a form of a LocalDate
     * @param estimate the estimated date of the requirement completion in a form of a LocalDate
     * @param responsibleTeamMember the TeamMember responsible for the Requirement, selected from team assigned to Project
     * @see TeamMember
     * @see Team
     * @see Project
     */
    public Requirement(String title, String status, String type, String description, LocalDate deadline, LocalDate estimate, TeamMember responsibleTeamMember) {
        this.id = createReqID();

        setTitle(title);
        setStatus(status);
        setType(type);
        setDescription(description);
        setDeadline(deadline);
        setEstimate(estimate);
        setResponsibleTeamMember(responsibleTeamMember);
        this.timeSpent = 0;

        this.taskList = new TaskList();
    }

    /**
     * will return the id of requirement
     * @return id of the requirement in a form of a String
     */
    public String getId() {
        return id;
    }

    /**
     * will return the Title
     * @return Title of requirement in a form of a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * checking if Title is not empty and setting it
     * @param title the title of the Requirement in a form of a String
     * @exception IllegalArgumentException will be thrown in case the title is empty
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        this.title = title;
    }

    /**
     * @return the Requirement status in a form a String
     */
    public String getStatus() {
        return status;
    }

    /**
     * checking if status is not empty and is valid, assigning the status
     * @param status the requirement status selected from final variables
     * @exception IllegalArgumentException will be thrown in case the provided status does not match with any of the final variables that are holding the legal statuses
     */
    public void setStatus(String status) {
        if (status == null || !validStatus(status)) {
            throw new IllegalArgumentException("Illegal status given");
        }
        this.status = status;
    }

    /**
     * @return Requirement's type(Functional, Non-functional, Project Related)
     */
    public String getType() {
        return type;
    }

    /**
     * will check if the project is of type
     * @param type
     */
    public void setType(String type) {
        if (type == null || !validType(type)) {
            throw new IllegalArgumentException("Illegal type given");
        }
        this.type = type;
    }

    /**
     * @return will return the Requirement description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * checks if the description is not empty, assigns description
     * @param description inputted description in a form of a String
     */
    public void setDescription(String description) {
        this.description = (description == null) ? "" : description;
    }

    /**
     * @return will return the list of all tasks for this specific requirement
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * @return will return the deadline for selected requirement in a form of a LocalDate
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * checks if the deadline is not empty, assigns deadline
     * @param deadline deadline in the form of a LocalDate
     */
    public void setDeadline(LocalDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Null deadline given");
        }
        this.deadline = deadline;
    }

    /**
     * @return will return estimated date of completion in the form of a LocalDate
     */
    public LocalDate getEstimate() {
        return estimate;
    }

    /**checks if the provided estimate is not empty, sets estimate
     * @param estimate the estimated time of completion in a form of a LocalDate
     */
    public void setEstimate(LocalDate estimate) {
        if (estimate == null) {
            throw new IllegalArgumentException("Null estimate given");
        }
        this.estimate = estimate;
    }

    /** will return the team member responsible for selected requirement
     * @return the responsible team member as an instance of class TeamMember
     */
    public TeamMember getResponsibleTeamMember() {
        return responsibleTeamMember;
    }

    /**
     * checks if parameter responsibleTeamMember is not empty, sets the responsible team member for selected requirement
     * @param responsibleTeamMember the team member that should be assigned as a responsible for selected requirement, in a form of an instance of TeamMember class
     */
    public void setResponsibleTeamMember(TeamMember responsibleTeamMember) {
        if (responsibleTeamMember == null) {
            throw new IllegalArgumentException("Null responsible team member given");
        }
        this.responsibleTeamMember = responsibleTeamMember;
    }

    /**
     * will return total time spent on selected requirement, total time spent on requirement is calculated as a sum of times for every task that this requirement has
     * @return total time spent on requirement as an int
     */
    public int getTimeSpent() {
        return timeSpent;
    }


    /**
     * will update the total time spent on requirement-recalculate and sum all time spent on all tasks
     */
    public void updateTimeSpent() {
        int minutes = 0;
        for (int i = 0; i < taskList.size(); i++) {
            minutes += taskList.getTask(i).getTimeWorkedList().getTotalTimeWorked();
        }
        this.timeSpent = minutes;
    }

    /**
     * creates requirement ID by combining letter R, which stands for requirement, with random number
     * @return letter R combined with random number in a form of a String
     */
    private static String createReqID() {
        Random random = new Random(System.currentTimeMillis());
        return  "R" + (10000 + random.nextInt(90000));
    }

    /**
     * method to check if status is valid, will compare input with array of valid statuses and if its contained in it, will return true, otherwise will return false
     * @param status input status
     * @return
     */
    private static boolean validStatus(String status) {
        String[] statuses = {STATUS_NOT_STARTED, STATUS_IN_PROCESS, STATUS_WAITING_FOR_APPROVAL, STATUS_APPROVED, STATUS_REJECTED};
        return Arrays.asList(statuses).contains(status);
    }

    /**
     * will check if Requirement type is valid and returns true if it is, false if it is not valid
     * @param type Requirement type
     * @return bool
     */
    private static boolean validType(String type) {
        String[] types = {TYPE_FUNCTIONAL, TYPE_NON_FUNCTIONAL, TYPE_PROJECT_RELATED};
        return Arrays.asList(types).contains(type);
    }

    /**
     * @return will return all Requirement details as a string
     */
    @Override
    public String toString() {
        return "Requirement{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline.toString() +
                ", estimate=" + estimate.toString() +
                ", responsibleTeamMember=" + responsibleTeamMember.getName() +
                ", timeSpent=" + timeSpent +
                ", taskList=" + taskList +
                '}';
    }
}
