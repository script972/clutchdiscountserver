package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import com.script972.dto.CardItemPutDTO;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "CardItem")
public class CardItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    /**
     * Card Number
     */
    @Column(name = "numberCard")
    private String number;

    /**
     * count of discount
     */
    @Column(name = "discount")
    private int discount;

    /**
     * currency of discount OR %
     */
    @Column(name = "currency")
    private String currency;

    /**
     * Notice about card (editable by user which added card)
     */
    @Column(name = "notice")
    private String notice;

    /**
     * Mark card access. The card may be blocked by admin
     */
    @Column(name = "available")
    private Boolean available=true;

    /**
     * Rand of curent card
     */
    private Integer score;

    /**
     * @TIMESTAMP when card added
     */
    @Column(name = "date_added")
    private Timestamp dateAdded = new Timestamp(DateTime.now().getMillis());

    /**
     * Auther of card
     */
    @ManyToOne
    @JoinColumn(name = "auther_id")
    private User auther;

    @ManyToOne
    @JoinColumn(name = "card_group")
    private CardGroup cardGroup;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "face_photo")
    private String facePhoto;

    @Column(name = "back_photo")
    private String backPhoto;

    /**
     * List of access user for this card
     */
    @ManyToMany
    @JoinColumn(name = "access_users")
    private List<User> accessUsers;

    public CardItem() {
    }

    public CardItem(CardItemPutDTO itemCard) {
        this.title=itemCard.getTitle();
        this.number=itemCard.getNumber();
        this.discount=itemCard.getDiscount();
        this.currency=itemCard.getCurrency();
        this.company=itemCard.getCompany();
        this.facePhoto = itemCard.getFacePhoto();
        this.backPhoto =itemCard.getBackPhoto();
    }

    public CardItem(String title, String number, int discount, String currency, String notice, Boolean available,
                    Integer score, Timestamp dateAdded, User auther, CardGroup cardGroup, List<User> accessUsers) {
        this.title = title;
        this.number = number;
        this.discount = discount;
        this.currency = currency;
        this.notice = notice;
        this.available = available;
        this.score = score;
        this.dateAdded = dateAdded;
        this.auther = auther;
        this.cardGroup = cardGroup;
        this.accessUsers = accessUsers;
    }

    public CardItem(String title, String number, int discount, String currency, String notice, Boolean available,
                    Integer score, Timestamp dateAdded, User auther, CardGroup cardGroup, Company company, String facePhoto,
                    String backPhoto, List<User> accessUsers) {
        this.title = title;
        this.number = number;
        this.discount = discount;
        this.currency = currency;
        this.notice = notice;
        this.available = available;
        this.score = score;
        this.dateAdded = dateAdded;
        this.auther = auther;
        this.cardGroup = cardGroup;
        this.company = company;
        this.facePhoto = facePhoto;
        this.backPhoto = backPhoto;
        this.accessUsers = accessUsers;
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

    public User getAuther() {
        return auther;
    }

    public void setAuther(User auther) {
        this.auther = auther;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CardGroup getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(CardGroup cardGroup) {
        this.cardGroup = cardGroup;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<User> getAccessUsers() {
        return accessUsers;
    }

    public void setAccessUsers(List<User> accessUsers) {
        this.accessUsers = accessUsers;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public String getBackPhoto() {
        return backPhoto;
    }

    public void setBackPhoto(String backPhoto) {
        this.backPhoto = backPhoto;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                ", notice='" + notice + '\'' +
                ", available=" + available +
                ", score=" + score +
                ", auther=" + auther +
                ", cardGroup=" + cardGroup +
                ", accessUsers=" + accessUsers +
                '}';
    }
}
