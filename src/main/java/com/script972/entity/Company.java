package com.script972.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    /**
     * Address of company office
     */
    @Column(name = "address")
    private String address;

    /**
     * Rang of company  in top list
     */
    @Column(name = "scores")
    private int score;

    @Column(name = "available")
    private Boolean available=true;

    @OneToOne
    @JoinColumn(name = "added")
    private User addedBy;

    @OneToOne
    @JoinColumn(name = "agree_by")
    private User agreeBy;

    @Column(name = "added_time")
    private Timestamp addedTime;

    /**
     * Just big compnay for build tree
     */
    @ManyToOne
    @JoinColumn(name = "company_parent")
    private Company parent;

    /**
     * Photo logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * Color company
     */
    @Column(name = "color")
    private String color;

    /**
     * Company site
     */
    @Column(name = "web_site")
    private String site;

    /**
     * Notice about company
     */
    @Column(name = "notice")
    private String notice;

    /**
     * if can add card for comapny
     */
    @Column(name = "access_for_card")
    private Boolean accessForCard=true;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;


    @OneToMany
    @JoinColumn(name = "phones")
    private List<PhoneNumber> phones;

}
