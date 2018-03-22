package com.script972.dto;

import com.script972.entity.CardGroup;
import com.script972.entity.CardItem;

public class CardItemDTO {

    private long id;

    private String title;

    private UserDTO auther;

    /**
     * Card Number
     */
    private String number;

    private CardGroup cardGroup;


    /**
     * count of discount
     */
    private int discount;

    /**
     * currency of discount OR %
     */
    private String currency;


    public CardItemDTO() {
    }

    public CardItemDTO(CardItem entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.auther=new UserDTO(entity.getAuther());
        this.number=entity.getNumber();
        this.cardGroup=entity.getCardGroup();
        this.discount=entity.getDiscount();
        this.currency=entity.getCurrency();
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther=" + auther +
                ", number='" + number + '\'' +
                ", cardGroup=" + cardGroup +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                '}';
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

    public UserDTO getAuther() {
        return auther;
    }

    public void setAuther(UserDTO auther) {
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
