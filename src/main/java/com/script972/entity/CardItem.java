package com.script972.entity;

import com.script972.dto.CardItemDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
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


    /**
     * Method for updating item card
     *
     * @param itemCard
     */
    public void updateCardItem(CardItemDTO itemCard) {
        if(itemCard.getTitle()!=null)
            this.title = itemCard.getTitle();
        //сan not update auther
        if(itemCard.getNumber()!=null && !itemCard.getNumber().isEmpty()){
            this.number = itemCard.getNumber();
        }
        //pass card group
        if(itemCard.getDiscount()!=0){
            this.discount = itemCard.getDiscount();
        }
        if(itemCard.getCurrency()!=null && !itemCard.getCurrency().isEmpty()){
            this.currency = itemCard.getCurrency();
        }
        //access user pass
        //company user pass
        //date added pass
        if(itemCard.getFacePhoto()!=null && !itemCard.getFacePhoto().isEmpty()) {
            this.facePhoto = itemCard.getFacePhoto();
        }
        if(itemCard.getBackPhoto()!=null && !itemCard.getFacePhoto().isEmpty()){
            this.backPhoto = itemCard.getBackPhoto();
        }
    }
}
