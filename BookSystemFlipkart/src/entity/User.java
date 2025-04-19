package entity;


import enums.UserType;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private UserType userType;

    public User(String name, UserType userType) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isOrganizer() {
        return userType == UserType.ORGANIZER;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}


