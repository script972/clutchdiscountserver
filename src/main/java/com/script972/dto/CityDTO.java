package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.Country;
import com.script972.entity.Position;

import javax.persistence.*;

public class CityDTO extends ErrorDTO {

    private long id;

    private String city;

    private String notice;

    private Country country;

    private Position position;

    public CityDTO(long id, String city, String notice, Country country, Position position) {
        this.id = id;
        this.city = city;
        this.notice = notice;
        this.country = country;
        this.position = position;
    }

    public CityDTO(City city) {
        if(city==null){
            super.setCodeError(3);
            super.setDescriptionError("City not found");
        }else {
            //super();
            this.id = city.getId();
            this.city = city.getCity();
            this.notice = city.getNotice();
            this.country = city.getCountry();
            this.position = city.getPosition();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
