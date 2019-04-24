package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.Country;
import com.script972.entity.Position;
import lombok.Data;

import javax.persistence.*;

@Data
public class CityWithOutCountryDTO {

    private long id;

    private String city;

    private String notice;

    private Position position;

}
