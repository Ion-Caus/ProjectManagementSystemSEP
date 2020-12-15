package model;

/**
 * A class representing productOwner
 */
public class ProductOwner extends TeamMember {
    public ProductOwner(String name) {
        super(name);
    }

    /**
     * this is an overridden method from parent class, will return the information of the employee
     * @return will return the information that this employee is a scrum master in a form of a String
     */
    @Override
    public String getRole() {
        return "Product Owner";
    }

    /**
     * checks if the provided obj is instance of the ProductOwner class
     * @param obj object which will be checked
     * @return bool
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductOwner)) {
            return false;
        }

        return super.equals(obj);
    }

    /**
     * will copy the object
     * @return copy of the object ProductOwner
     */
    @Override
    public ProductOwner copy() {
        return new ProductOwner(super.getName());
    }
}
