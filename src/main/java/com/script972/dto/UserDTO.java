package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.User;
import lombok.Data;

import java.util.Date;


@Data
public class UserDTO extends ErrorDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private City city;

    private String phoneNumber;

    private Date birthday;

    private String facePhoto;

    private int score;

}
