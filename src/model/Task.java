package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Task implements Serializable {
    private String id;
    private String title;
    private String status;
    private String description;
    private LocalDate deadline;
    private LocalDate estimate;

    private TimeContainer timeWorkedList;

    private TeamMember responsibleTeamMember;

    public static final String STATUS_NOT_STARTED = "Not started";
    public static final String STATUS_IN_PROCESS = "In Process";
    public static final String STATUS_COMPLETED = "Completed";

    /**
     * A 6 argument constructor that initializes the class Task
     *
     * @param title the title(name) of the task in a form of String
     * @param status the status of the task in a form of String
     * @param description the description of the task in a form of a String
     * @param deadline the date when task needs to be finished in a form of a LocalDate
     * @param estimate the estimated date of the task completion in a form of a LocalDate
     * @param responsibleTeamMember the TeamMember responsible for the Task, selected from team assigned to Project
     */
    public Task(String title, String status, String description, LocalDate deadline, LocalDate estimate, TeamMember responsibleTeamMember) {
        this.id = createTaskID();

        setTitle(title);
        setStatus(status);
        setDescription(description);
        setDeadline(deadline);
        setEstimate(estimate);
        setResponsibleTeamMember(responsibleTeamMember);

        this.timeWorkedList = new TimeContainer();
    }

    /**
     * will return the id of task
     * @return id of the task in a form of a String
     */
    public String getId() {
        return id;
    }

    /**
     * will return the Title
     * @return Title of task in a form of a String
     */
    public String getTitle() {
        return title;
    }


    /**
     * checking if Title is not empty and setting it
     * @param title the title of the Task in a form of a String
     * @exception IllegalArgumentException will be thrown in case the title is empty
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        this.title = title;
    }
    /**
     * @return the Tasks status in a form a String
     */
    public String getStatus() {
        return status;
    }

    /**
     * checking if status is not empty and is valid, assigning the status
     * @param status the tasks status selected from final variables
     * @exception IllegalArgumentException will be thrown in case the provided status does not match with any of the final variables that are holding the legal statuses
     */

    public void setStatus(String status) {
        if (status == null || !validStatus(status)) {
            throw new IllegalArgumentException("Illegal status given");
        }
        this.status = status;
    }
    /**
     * @return will return the Task description as a String
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
     * @return will return the deadline for selected task in a form of a LocalDate
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

    /** will return the team member responsible for selected task
     * @return the responsible team member as an instance of class TeamMember
     */
    public TeamMember getResponsibleTeamMember() {
        return responsibleTeamMember;
    }


    /**
     * will return the instance of TimeContainer class, which holds info about time worked on the project and people that worked on the project
     * @see Time
     * @see TeamMember
     * @see TimeContainer
     * @return instance of class TimeContainer
     */
    public TimeContainer getTimeWorkedList() {
        return timeWorkedList;
    }

    /**
     * checks if parameter responsibleTeamMember is not empty, sets the responsible team member for selected task
     * @param responsibleTeamMember the team member that should be assigned as a responsible for selected task, in a form of an instance of TeamMember class
     */

    public void setResponsibleTeamMember(TeamMember responsibleTeamMember) {
        if (responsibleTeamMember == null) {
            throw new IllegalArgumentException("Null responsible team member given");
        }
        this.responsibleTeamMember = responsibleTeamMember;
    }
    /**
     * creates task ID by combining letter T, which stands for task, with random number
     * @return letter T combined with random number in a form of a String
     */
    private static String createTaskID() {
        Random random = new Random(System.currentTimeMillis());
        return  "T" + (10000 + random.nextInt(90000));
    }

    /**
     * will check if Task status is valid and returns true if it is, false if it is not valid
     * @param status Task status
     * @return bool
     */

    private static boolean validStatus(String status) {
        String[] statuses = {STATUS_NOT_STARTED,STATUS_IN_PROCESS,STATUS_COMPLETED};
        return Arrays.asList(statuses).contains(status);
    }


    /**
     * @return will return all Task details as a string
     */
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline.toString() +
                ", estimate=" + estimate.toString() +
                ", responsibleTeamMember=" + responsibleTeamMember.getName() +
                ", timeWorkedList= " +timeWorkedList +
                '}';
    }
}
