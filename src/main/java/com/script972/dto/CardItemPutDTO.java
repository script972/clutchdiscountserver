package com.script972.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.script972.entity.CardGroup;
import com.script972.entity.Company;

import java.sql.Timestamp;

/**
 * DTO for Add CardITEM
 */
public class CardItemPutDTO {

    private long id;

    private String title;

    private Long auther;

    /**
     * Card Number
     */
    private String number;

    private Long cardGroup;

    /**
     * count of discount
     */
    private int discount;

    /**
     * currency of discount OR %
     */
    private String currency;

    private Timestamp dateAdded;

    private Company company;


    public CardItemPutDTO() {
    }

    public CardItemPutDTO(long id, String title, Long auther, String number, Long cardGroup, int discount, String currency,
                          Timestamp dateAdded, Company company) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.number = number;
        this.cardGroup = cardGroup;
        this.discount = discount;
        this.currency = currency;
        this.dateAdded = dateAdded;
        this.company = company;
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

    public Long getAuther() {
        return auther;
    }

    public void setAuther(Long auther) {
        this.auther = auther;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(Long cardGroup) {
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

    @Override
    public String toString() {
        return "CardItemPutDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autherId=" + auther +
                ", number='" + number + '\'' +
                ", cardGroup=" + cardGroup +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
