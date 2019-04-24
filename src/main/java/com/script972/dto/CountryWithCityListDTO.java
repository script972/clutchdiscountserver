package com.script972.dto;

import com.script972.entity.Position;
import lombok.Data;

import java.util.*;

@Data
public class CountryWithCityListDTO extends ErrorDTO {

    private long id;

    private String title;

    /**
     * Prefix of phone number
     */
    private String codeNumber;

    private Position position;

    private String notice;

    private Collection<CityWithOutCountryDTO> citys;

}
