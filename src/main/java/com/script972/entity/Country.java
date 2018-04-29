package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    /**
     * Prefix of phone number
     */
    @Column(name = "code_number")
    private String codeNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Position position;

    @Column(name = "notice")
    private String notice;


    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private Collection<City> citys;

    public Collection<City> getCitys() {
        return citys;
    }

    public void setCitys(Collection<City> citys) {
        this.citys = citys;
    }

    public Country(String title, String codeNumber, Position position, String notice, Collection<City> citys) {
        this.title = title;
        this.codeNumber = codeNumber;
        this.position = position;
        this.notice = notice;
        this.citys = citys;
    }

    public Country() {
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

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
}
