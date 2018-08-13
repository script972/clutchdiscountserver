package com.script972.dto;

import com.script972.entity.City;

import java.util.Date;


public class RegistrationUserDTO {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private City city;

    private String phoneNumber;

    private Date birthday;

    private String facePhoto;

    private Boolean googlePlus;

    public RegistrationUserDTO() {
    }

    public RegistrationUserDTO(Long id, String username, String password, String firstName, String lastName, String email,
                               City city, String phoneNumber, Date birthday, String facePhoto) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.facePhoto = facePhoto;
    }

    public RegistrationUserDTO(GoogleOathDTO googleOathDTO) {
        this.setEmail(googleOathDTO.getEmail());
        this.setUsername(googleOathDTO.getEmail());
        this.setFirstName(googleOathDTO.getGivenName());
        this.setLastName(googleOathDTO.getFamilyName());
        this.setFacePhoto(googleOathDTO.getPicture());

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(Boolean googlePlus) {
        this.googlePlus = googlePlus;
    }

    @Override
    public String toString() {
        return "RegistrationUserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city=" + city +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
