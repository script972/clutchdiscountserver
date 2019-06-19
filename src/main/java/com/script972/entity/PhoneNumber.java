package com.script972.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone_number")
public class PhoneNumber extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    public PhoneNumber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
