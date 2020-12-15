package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class that is containing the list of the class Project
 */
public class ProjectList implements Serializable {
    private ArrayList<Project> projects;

    /**
     * zero argument constructor that initializes the Arraylist that is holding Project classes
     */
    public ProjectList() {
        this.projects = new ArrayList<>();
    }

    /**
     * Returning how many objects of type Project are stored in the Arraylist
     *
     * @return  number of elements in the Arraylist as an integer
     */
    public int size() {
        return projects.size();
    }

    /**
     * adding a new instance of the class Project to the containing Arraylist
     * @param project the project as an object of type Project
     */
    public void addProject(Project project){
        projects.add(project);
    }

    /**
     * removing an instance of the class Project from the containing Arraylist
     * @param project the project as an object of type Project
     */
    public void removeProject(Project project){
        projects.remove(project);
    }

    /**
     * returing an object of type Project based on the index number
     * @param index the index number of the project as an integer
     * @return the project as an object of type Project
     */
    public Project getProject(int index) {
        return projects.get(index);
    }

    /**
     * will loop trough the containing Arraylist and return the project with matching ID
     * @param id the ID of the project in a form of a string
     * @return will return project as an instance of class Project
     *
     * @exception NullPointerException will be thrown in case there was no project found with matching ID
     */
    public Project getProject(String id){
        for(Project project: projects){
            if(project.getId().equals(id))
                return project;
        }
        throw new NullPointerException("Non-existent project");
    }


    /**
     * will loop trough the containing Arraylist and return the project with matching deadline
     * @param deadline the Project's deadline in a form LocalDate
     * @return project with matching deadline as an instance of class Project
     *
     * @exception NullPointerException will be thrown in case no project deadline matches with the provided deadline
     */
    public Project getProject(LocalDate deadline){
        for(Project project: projects){
            if(project.getDeadline().equals(deadline))
                return project;
        }
        throw new NullPointerException("Non-existent project");
    }
    // TODO: 14/12/2020 by Tomas Brezny  Consult the methods getProject(deadline) and getProjectList, shouldn't the method getProject return a list of all project that are matching that deadline?
    /**
     * will return an ArrayList containing all projects whose status matches with the status provided
     * @param status status of the project as a String
     * @return the Arraylist of all instances of class Project that have a matching date with the date provided
     */
    public ArrayList<Project> getProjectList(String status){
        ArrayList<Project> temp = new ArrayList<>();
        for(Project project: projects){
            if(project.getStatus().equals(status))
                temp.add(project);
        }
        return temp;
    }

    /**
     * will return all the projects that are stored in the containing element
     * @return an ArrayList containing all the instances of class Project
     */
    public ArrayList<Project> getProjectList(){
        return this.projects;
    }


}