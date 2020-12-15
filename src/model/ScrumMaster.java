package model;

/**
 * A class representing scrumMaster
 */
public class ScrumMaster extends TeamMember {
    public ScrumMaster(String name) {
        super(name);
    }

    /**
     * this is an overridden method from parent class, will return the role of the employee
     * @return will return the information that this employee is a Scrum Master in a form of a String
     */
    @Override
    public String getRole() {
        return "Scrum Master";
    }

    /**
     * checks if the provided obj is instance of the ScrumMaster class
     * @param obj object which will be checked
     * @return bool
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ScrumMaster)) {
            return false;
        }

        return super.equals(obj);
    }

    /**
     * will copy the object
     * @return copy of the object ScrumMaster
     */
    @Override
    public ScrumMaster copy() {
        return new ScrumMaster(super.getName());
    }
}
