package com.script972.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "country")
public class Country {

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


    @OneToMany(mappedBy = "country")
    private Collection<City> citys;

    public Collection<City> getCitys() {
        return citys;
    }

    public void setCitys(Collection<City> citys) {
        this.citys = citys;
    }
}
