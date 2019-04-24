package com.script972.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CardItemDTO extends ErrorDTO {

    private long id;

    private String title;

    private UserDTO auther;

    /**
     * Card Number
     */
    private String number;

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

    private CompanyDTO company;

    private Timestamp dateAdded;

    private String facePhoto;

    private String backPhoto;

}
