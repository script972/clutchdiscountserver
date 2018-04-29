package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.Country;
import com.script972.entity.Position;

import javax.persistence.*;

public class CityWithOutCountryDTO {

    private long id;

    private String city;

    private String notice;

    private Position position;

    public CityWithOutCountryDTO() {
    }

    public CityWithOutCountryDTO(long id, String city, String notice, Position position) {
        this.id = id;
        this.city = city;
        this.notice = notice;
        this.position = position;
    }

    public CityWithOutCountryDTO(City next) {
        this.id=next.getId();
        this.city=next.getCity();
        this.notice=next.getNotice();
        this.position=next.getPosition();
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
