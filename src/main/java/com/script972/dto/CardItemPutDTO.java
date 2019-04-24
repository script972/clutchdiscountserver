package com.script972.dto;

import com.script972.entity.Company;
import lombok.Data;

import java.sql.Timestamp;

/**
 * DTO for Add CardITEM
 */
@Data
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


    private String facePhoto;

    private String backPhoto;

    private Timestamp dateAdded;

    private Company company;

}
