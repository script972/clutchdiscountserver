package com.script972.entity;


import javax.persistence.*;
import java.sql.Timestamp;

public class Stoke {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Position position;

    @Column(name = "notice")
    private String notice;

    @Column(name = "date_start")
    private Timestamp dateStart;

    @Column(name = "date_stop")
    private Timestamp dateStop;

    @ManyToOne
    @JoinColumn(name = "phones")
    private PhoneNumber phoneNumber;

    @Column
    private String description;

    @Column
    private String logo;

    public Stoke(String title, Position position, String notice, Timestamp dateStart, Timestamp dateStop, PhoneNumber phoneNumber,
                 String description, String logo) {
        this.title = title;
        this.position = position;
        this.notice = notice;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateStop() {
        return dateStop;
    }

    public void setDateStop(Timestamp dateStop) {
        this.dateStop = dateStop;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
