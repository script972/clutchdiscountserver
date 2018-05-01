package com.script972.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.script972.entity.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompanyDTO {

    private long id;

    private String title;

    private Position position;

    private String address;

    private String logo;

    private String site;

    private City city;

    private String notice;

    private int scores;

    private String color;

    private List<PhoneNumber> phones;

    /**
     * Just big compnay for build tree
     */
    private Company parent;

    @JsonIgnore
    private List<CardGroupDTO> cardGroup=new ArrayList<>();

    public CompanyDTO(Company company) {
        this.id=company.getId();
        this.title=company.getTitle();
        this.position=company.getPosition();
        this.address=company.getAddress();
        this.logo=company.getLogo();
        this.site=company.getSite();
        this.city=company.getCity();
        this.color=company.getColor();
        if(company.getCardGroup()!=null)
        for (int i = 0; i < company.getCardGroup().size(); i++) {
            this.cardGroup.add(new CardGroupDTO(company.getCardGroup().get(i)));

        }
        this.notice=company.getNotice();
        this.phones=company.getPhones();
        this.scores=company.getScore();

    }

    public CompanyDTO(long id, String title, Position position, String address, String logo, String site, City city,
                      String notice, int scores, List<PhoneNumber> phones, Company parent, List<CardGroupDTO> cardGroup) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.address = address;
        this.logo = logo;
        this.site = site;
        this.city = city;
        this.notice = notice;
        this.scores = scores;
        this.phones = phones;
        this.parent = parent;
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

    public List<CardGroupDTO> getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(List<CardGroupDTO> cardGroup) {
        this.cardGroup = cardGroup;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", parent=" + parent +
                ", cardGroup=" + cardGroup +
                '}';
    }


}
