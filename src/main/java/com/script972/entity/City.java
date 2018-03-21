package com.script972.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
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

}
