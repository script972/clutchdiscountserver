package com.script972.dto;

import com.script972.entity.*;
import lombok.Data;

import java.util.List;


@Data
public class CompanyDTO  extends ErrorDTO{

    private long id;

    private String title;

    private String address;

    private String logo;

    private String site;

    private String notice;

    private int scores;

    private String color;

    private List<PhoneNumber> phones;

    /**
     * Just big compnay for build tree
     */
    private Company parent;

}
