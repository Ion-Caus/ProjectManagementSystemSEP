package model;

public class ScrumMaster extends TeamMember{

    public ScrumMaster(String name) {
        super(name);
    }

    public TeamMember getResponsibleTeamMemberFor(Task task){
        return task.getTeamMember();
    }

    public TeamMember getResponsibleTeamMemberFor(Requirement requirement){
        return requirement.getTeamMember();
    }

    public void addDeadlineTo(Requirement requirement, MyDate deadline){
        requirement.setDeadline(deadline);
    }

    public void addDeadlineTO(Task task, MyDate deadline){
        task.setDeadline(deadline);
    }

    public void addEstimateTo(Requirement requirement, MyDate estimate){
        requirement.setEstimate(estimate);

    }

    public void addEstimateTo(Task task, MyDate estimate){
        task.setEstimate(estimate);
    }

    public void addTeamMemberTo(Task  task, TeamMember teamMember){
        task.setTeamMember(teamMember);
    }

    public void addTeamMemberTo(Requirement requirement, TeamMember teamMember){
        requirement.setTeamMember(teamMember);
    }
}
