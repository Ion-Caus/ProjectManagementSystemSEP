package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TeamMember;

public class TeamMemberViewModel {
    private StringProperty nameProperty;

    public TeamMemberViewModel(TeamMember teamMember) {
        this.nameProperty = new SimpleStringProperty(teamMember.getName());
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }
}
