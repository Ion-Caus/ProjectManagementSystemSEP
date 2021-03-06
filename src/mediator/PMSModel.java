package mediator;

import model.Project;
import model.Requirement;
import model.Task;
import model.TeamMember;

import java.util.ArrayList;

public interface PMSModel {

    boolean isAdding();
    void setAdding(boolean status);

    //----Employee----
    int employeeListSize();

    void addEmployee(TeamMember teamMember);
    void removeEmployee(TeamMember teamMember);

    TeamMember getEmployee(String name);
    TeamMember getEmployee(int index);

    ArrayList<TeamMember> getEmployeeList();
    ArrayList<String> getEmployeeNameList();

    //----Team----
    boolean isPresent(String role) throws ClassNotFoundException;

    TeamMember getTeamMember(String name);
    TeamMember getTeamMember(int index);


    ArrayList<String> getTeamMemberNameList();

    //----Project----
    int projectListSize();

    void addProject(Project project);
    void removeProject(Project project);

    Project getProject(String id);
    Project getProject(int index);

    ArrayList<Project> getProjectList();
    ArrayList<String> getProjectNameList();

    void setFocusProject(Project project);
    Project getFocusProject();

    //----Requirement----
    int requirementListSize();

    void addRequirement(Requirement requirement);
    void removeRequirement(Requirement requirement);

    Requirement getRequirement(String id);
    Requirement getRequirement(int index);

    ArrayList<Requirement> getRequirementList();
    ArrayList<String> getRequirementTitleList();

    void setFocusRequirement(Requirement requirement);
    Requirement getFocusRequirement();

    //----Task----
    int taskListSize();

    void addTask(Task task);
    void removeTask(Task task);

    Task getTask(String id);
    Task getTask(int index);

    ArrayList<Task> getTaskList();
    ArrayList<String> getTaskTitleList();

    void setFocusTask(Task task);
    Task getFocusTask();

    //----FileSaver----
    void saveData();
    void loadData();
}
