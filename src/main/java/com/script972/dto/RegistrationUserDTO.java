package com.script972.dto;

import com.script972.entity.City;
import lombok.Data;

import java.util.Date;

@Data
public class RegistrationUserDTO {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private City city;

    private String phoneNumber;

    private Date birthday;

    private String facePhoto;

    private Boolean googlePlus;

}
