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

}
