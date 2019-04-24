package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    /**
     * Prefix of phone number
     */
    @Column(name = "code_number")
    private String codeNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Position position;

    @Column(name = "notice")
    private String notice;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private Collection<City> citys;

}
