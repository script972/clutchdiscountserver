package com.script972.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "position")
    private Position position;

    @Column(name = "address")
    private String address;

    /**
     * Для больших компаний возможность построение иерархии
     */
    @ManyToOne
    @JoinColumn(name = "company_parent")
    private Company parent;


    @OneToMany(mappedBy = "company")
    private Collection<CardGroup> cardGroup;

    public Company() {
    }

    public Company(String title, Position position, Company parent, Collection<CardGroup> cardGroup) {
        this.title = title;
        this.position = position;
        this.parent = parent;
        this.cardGroup = cardGroup;
    }



    public Collection<CardGroup> getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(Collection<CardGroup> cardGroup) {
        this.cardGroup = cardGroup;
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

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}