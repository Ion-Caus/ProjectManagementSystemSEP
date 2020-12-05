package model;

public class ProductOwner extends TeamMember {

    public ProductOwner(String name) {
        super(name);
    }

    public void approveRequirement(Requirement requirement){
        requirement.setStatus(Requirement.STATUS_APPROVED);

    }

    public void rejectRequirement(Requirement requirement){
        requirement.setStatus(Requirement.STATUS_REJECTED);
    }

    public void addRequirement(Requirement requirement, Project project){
        project.getRequirementList().addRequirement(requirement);
    }

    public void removeRequirement(Requirement requirement, Project project){
        project.getRequirementList().removeRequirement(requirement);
    }

    // TODO: 05/12/2020 add method sort requirement
    // TODO: 05/12/2020  add method prioritize requirement
}
