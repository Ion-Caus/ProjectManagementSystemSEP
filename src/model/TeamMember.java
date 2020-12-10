package model;

import java.io.Serializable;

public class TeamMember implements Serializable
{
    private String name;

    //TODO divide name to firstName and lastName
    public TeamMember(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
