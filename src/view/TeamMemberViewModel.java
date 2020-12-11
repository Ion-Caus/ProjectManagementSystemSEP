package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TeamMember;

public class TeamMemberViewModel {
    private StringProperty nameProperty;
    private StringProperty roleProperty;

    public TeamMemberViewModel(TeamMember teamMember) {
        this.nameProperty = new SimpleStringProperty(teamMember.getName());
        this.roleProperty = new SimpleStringProperty(teamMember.getRole());
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public StringProperty getRoleProperty() {
        return roleProperty;
    }
}
