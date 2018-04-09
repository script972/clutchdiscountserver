package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String city;

    @Column
    private String notice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Position position;

    public City(String city, String notice, Country country, Position position) {
        this.city = city;
        this.notice = notice;
        this.country = country;
        this.position = position;
    }

    public City() {
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", notice='" + notice + '\'' +
                ", country=" + country +
                ", position=" + position +
                '}';
    }
}
