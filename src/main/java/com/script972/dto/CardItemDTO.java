package com.script972.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.script972.entity.CardGroup;
import com.script972.entity.CardItem;
import com.script972.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CardItemDTO {

    private long id;

    private String title;

    private UserDTO auther;

    /**
     * Card Number
     */
    private String number;

    @JsonIgnore
    private CardGroup cardGroup;


    /**
     * count of discount
     */
    private int discount;

    /**
     * currency of discount OR %
     */
    private String currency;

    /**
     * List of access user for this card
     */
    private List<UserDTO> accessUsers;


    public CardItemDTO() {
    }

    public CardItemDTO(CardItem entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.auther=new UserDTO(entity.getAuther());
        this.number=entity.getNumber();
        this.cardGroup=entity.getCardGroup();
        this.discount=entity.getDiscount();
        this.accessUsers=conveterDTOUser(entity.getAccessUsers());
        this.currency=entity.getCurrency();
    }

    private List<UserDTO> conveterDTOUser(List<User> accessUsers) {
        List<UserDTO> users=new ArrayList<>();
        for (int i = 0; i < accessUsers.size(); i++) {
            users.add(new UserDTO(accessUsers.get(i)));
        }
        return users;
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

    public List<UserDTO> getAccessUsers() {
        return accessUsers;
    }

    public void setAccessUsers(List<UserDTO> accessUsers) {
        this.accessUsers = accessUsers;
    }
}
