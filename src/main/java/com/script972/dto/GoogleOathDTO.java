package com.script972.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleOathDTO {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("verified_email")
    @Expose
    private boolean verifiedEmail;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("given_name")
    @Expose
    private String givenName;
    @SerializedName("family_name")
    @Expose
    private String familyName;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("locale")
    @Expose
    private String locale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GoogleOathDTO withId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GoogleOathDTO withEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public GoogleOathDTO withVerifiedEmail(boolean verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoogleOathDTO withName(String name) {
        this.name = name;
        return this;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public GoogleOathDTO withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public GoogleOathDTO withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public GoogleOathDTO withLink(String link) {
        this.link = link;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public GoogleOathDTO withPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GoogleOathDTO withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public GoogleOathDTO withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    @Override
    public String toString() {
        return "GoogleOathDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", verifiedEmail=" + verifiedEmail +
                ", name='" + name + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", link='" + link + '\'' +
                ", picture='" + picture + '\'' +
                ", gender='" + gender + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
