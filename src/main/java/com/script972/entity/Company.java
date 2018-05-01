package com.script972.entity;

import com.script972.dto.CompanyDTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    /**
     * Address of company office
     */
    @Column(name = "address")
    private String address;

    /**
     * Rang of company  in top list
     */
    @Column(name = "scores")
    private int score;

    @Column(name = "available")
    private Boolean available=true;

    @OneToOne
    @JoinColumn(name = "added")
    private User addedBy;

    @OneToOne
    @JoinColumn(name = "agree_by")
    private User agreeBy;

    @Column(name = "added_time")
    private Timestamp addedTime;

    /**
     * Just big compnay for build tree
     */
    @ManyToOne
    @JoinColumn(name = "company_parent")
    private Company parent;

    /**
     * Photo logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * Color company
     */
    @Column(name = "color")
    private String color;

    /**
     * Company site
     */
    @Column(name = "web_site")
    private String site;

    /**
     * Notice about company
     */
    @Column(name = "notice")
    private String notice;


    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

 /*   @OneToMany
    @JoinColumn(name = "cardGroup")
    private Collection<CardGroup> cardGroup;*/

    @OneToMany(mappedBy = "company")
    private List<CardGroup> cardGroup;


    @OneToMany
    @JoinColumn(name = "phones")
    private List<PhoneNumber> phones;


    public Company(String title, Position position, String address, int score, Boolean available,
                   User addedBy, User agreeBy, Timestamp addedTime, Company parent, String logo,
                   String color, String site, String notice, City city, List<CardGroup> cardGroup,
                   List<PhoneNumber> phones) {
        this.title = title;
        this.position = position;
        this.address = address;
        this.score = score;
        this.available = available;
        this.addedBy = addedBy;
        this.agreeBy = agreeBy;
        this.addedTime = addedTime;
        this.parent = parent;
        this.logo = logo;
        this.color = color;
        this.site = site;
        this.notice = notice;
        this.city = city;
        this.cardGroup = cardGroup;
        this.phones = phones;
    }

    public Company() {
    }



    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<CardGroup> getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(List<CardGroup> cardGroup) {
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


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public User getAgreeBy() {
        return agreeBy;
    }

    public void setAgreeBy(User agreeBy) {
        this.agreeBy = agreeBy;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", available=" + available +
                ", addedBy=" + addedBy +
                ", agreeBy=" + agreeBy +
                ", addedTime=" + addedTime +
                ", parent=" + parent +
                ", logo='" + logo + '\'' +
                ", color='" + color + '\'' +
                ", site='" + site + '\'' +
                ", notice='" + notice + '\'' +
                ", city=" + city +
                ", cardGroup=" + cardGroup +
                ", phones=" + phones +
                '}';
    }
}
