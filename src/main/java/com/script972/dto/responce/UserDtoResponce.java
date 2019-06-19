package com.script972.dto.responce;

import com.script972.dto.ErrorDTO;
import lombok.Data;

import java.util.Date;


@Data
public class UserDtoResponce extends ErrorDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date birthday;

    private String facePhoto;

    private int score;

}
