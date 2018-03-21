package com.script972.jto;

import com.script972.entity.CardGroup;
import com.script972.entity.Company;
import com.script972.entity.Position;

import javax.persistence.*;
import java.util.Collection;

public class CompanyJTO {

    private long id;

    private String title;

    private Position position;

    private String address;

    /**
     * Для больших компаний возможность построение иерархии
     */
    private Company parent;

    private Collection<CardGroup> cardGroup;

    public CompanyJTO(Company company) {
        this.id=company.getId();
        this.title=company.getTitle();
        this.position=company.getPosition();
        this.address=company.getAddress();
        this.parent=company.getParent();
        this.cardGroup=company.getCardGroup();
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

    @Override
    public String toString() {
        return "CompanyJTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", address='" + address + '\'' +
                ", parent=" + parent +
                ", cardGroup=" + cardGroup +
                '}';
    }
}
