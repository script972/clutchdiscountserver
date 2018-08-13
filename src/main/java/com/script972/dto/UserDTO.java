package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.User;

import java.util.Date;


public class UserDTO extends ErrorDTO{

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private City city;

    private String phoneNumber;

    private Date birthday;

    private String facePhoto;

    private int score;

    public UserDTO(User entity){
        this.id=entity.getId();
        this.username=entity.getUsername();
        this.firstName=entity.getFirstName();
        this.lastName=entity.getLastName();
        this.email=entity.getEmail();
        this.city=entity.getCity();
        this.phoneNumber=entity.getPhoneNumber();
        this.birthday=entity.getBirthday();
        this.facePhoto=entity.getFacePhoto();
    }

    public UserDTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }
}
