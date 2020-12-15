package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that is containing the list of the class Requirement
 */
public class RequirementList implements Serializable {
    private ArrayList<Requirement> requirementList;
    /**
     * zero argument constructor that initializes the Arraylist that is holding Requirement classes
     */

    public RequirementList() {
        this.requirementList = new ArrayList<>();
    }

    /**
     * Returning how many objects of type Requirement are stored in the Arraylist
     *
     * @return  number of elements in the Arraylist as an integer
     */
    public int size() {
        return  requirementList.size();
    }

    /**
     * adding a new instance of the class Requirement to the containing Arraylist
     * @param requirement the requirement as an object of type Project
     */
    public void addRequirement(Requirement requirement) {
        requirementList.add(requirement);
    }

    /**
     * removing an instance of the class Requirement from the containing Arraylist
     * @param requirement the requirement as an object of type Requirement
     */
    public void removeRequirement(Requirement requirement) {
        requirementList.remove(requirement);
    }

    /**
     * returing an object of type Requirement based on the index number
     * @param index the index number of the requirements as an integer
     * @return the requirement as an object of type Requirement
     */

    public Requirement getRequirement(int index) {
        return requirementList.get(index);
    }


    /**
     * will loop trough the containing Arraylist and return the requirement with matching ID
     * @param id the ID of the requirement in a form of a string
     * @return will return requirement as an instance of class Requirement
     */

    public Requirement getRequirement(String id) {
        for (Requirement requirement: requirementList) {
            if (requirement.getId().equals(id)) {
                return requirement;
            }
        }
        return null;
    }

    public ArrayList<Requirement> getRequirementList() {
        return requirementList;
    }

    public double getTimeSpent(){
       double minutes=0;
       for (Requirement requirement:requirementList){
          minutes+=requirement.getTimeSpent();
       }
       return minutes;

    }

}
