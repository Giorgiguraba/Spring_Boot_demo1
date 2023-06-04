package com.example.project.demoProject.entities;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name should be min 2 character")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    @Size(min = 3, message = "last name should be min 2 character")
    private String lastName;
    @NotNull(message = "last name cannot be null")
    @Email
    private String email;
    @NotNull(message = "last name cannot be null")
    @Size(min = 5, max = 12, message = "last name should be min 2 character")
    private String password;
    @Id
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
