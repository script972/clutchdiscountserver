package com.script972.dto;

import com.script972.entity.CardGroup;
import com.script972.entity.City;
import com.script972.entity.Company;
import com.script972.entity.Position;

import java.util.Collection;

public class CompanyDTO {

    private long id;

    private String title;

    private Position position;

    private String address;

    private City city;



    /**
     * Для больших компаний возможность построение иерархии
     */
    private Company parent;

    private Collection<CardGroup> cardGroup;

    public CompanyDTO(Company company) {
        this.id=company.getId();
        this.title=company.getTitle();
        this.position=company.getPosition();
        this.address=company.getAddress();
        this.parent=company.getParent();
        this.cardGroup=company.getCardGroup();
        this.city=company.getCity();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public Collection<CardGroup> getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(Collection<CardGroup> cardGroup) {
        this.cardGroup = cardGroup;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", address='" + address + '\'' +
                ", parent=" + parent +
                ", cardGroup=" + cardGroup +
                '}';
    }
}
