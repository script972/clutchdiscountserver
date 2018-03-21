package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "CardItem")
public class CardItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "auther_id")
    private User auther;

    /**
     * Card Number
     */
    @Column(name = "numberCard")
    private String number;

    @ManyToOne
    @JoinColumn(name = "card_group")
    private CardGroup cardGroup;


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


    public CardItem() {
    }

    public CardItem(String title, User auther, String number, CardGroup cardGroup) {
        this.title = title;
        this.auther = auther;
        this.number = number;
        this.cardGroup = cardGroup;
    }

    public CardItem(String title, User auther, String number, CardGroup cardGroup, int discount, String currency) {
        this.title = title;
        this.auther = auther;
        this.number = number;
        this.cardGroup = cardGroup;
        this.discount = discount;
        this.currency = currency;
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


}
