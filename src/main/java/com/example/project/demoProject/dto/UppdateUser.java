package com.example.project.demoProject.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UppdateUser {
    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name should be min 2 character")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    @Size(min = 3, message = "last name should be min 2 character")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
