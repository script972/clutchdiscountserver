package com.script972.dto;

import com.script972.entity.CardGroup;
import com.script972.entity.CardItem;
import com.script972.entity.Company;

import javax.persistence.*;
import java.util.Collection;

public class CardGroupDTO {
    private long id;

    private String title;

    private Company company;

    public CardGroupDTO(long id, String title, Company company) {
        this.id = id;
        this.title = title;
        this.company = company;
    }

    public CardGroupDTO(CardGroup cardGroup) {
        this.id=cardGroup.getId();
        this.title=cardGroup.getTitle();
        this.company=cardGroup.getCompany();
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
