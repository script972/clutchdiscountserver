package com.script972.dao;

import com.restfb.Facebook;

/**
 * Created by script972
 */

public class CustomUser {

    @Facebook("id")
    private String id;

    @Facebook("first_name")
    private String firstName;

    @Facebook("last_name")
    private String lastName;

    @Facebook("name")
    private String fullName;

    @Facebook
    private String email;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
