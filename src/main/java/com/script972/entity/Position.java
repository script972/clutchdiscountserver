package com.script972.entity;

import javax.persistence.*;

@Entity
@Table(name = "POSITION")
public class Position {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "description")
    private String description;

    public Position(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Position(String description, double lat, double lng) {
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    public Position() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
