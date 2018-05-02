package com.script972.dto;

import com.script972.entity.City;
import com.script972.entity.Country;
import com.script972.entity.Position;

import java.util.*;

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


    public CountryWithCityListDTO() {
    }

    public CountryWithCityListDTO(long id, String title, String codeNumber, Position position, String notice, Collection<CityWithOutCountryDTO> citys) {
        this.id = id;
        this.title = title;
        this.codeNumber = codeNumber;
        this.position = position;
        this.notice = notice;
        this.citys = citys;
    }

    public CountryWithCityListDTO(Country country) {
        this.id=country.getId();
        this.title=country.getTitle();
        this.codeNumber=country.getCodeNumber();
        this.position=country.getPosition();
        this.notice=country.getNotice();

        Collection<City> cities=country.getCitys();
        if(cities!=null) {
            List<CityWithOutCountryDTO> resultList = new ArrayList<>();
            Iterator<City> iterator = cities.iterator();
            while (iterator.hasNext()) {
                resultList.add(new CityWithOutCountryDTO(iterator.next()));
            }
            this.citys = resultList;
        }

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Collection<CityWithOutCountryDTO> getCitys() {
        return citys;
    }

    public void setCitys(Collection<CityWithOutCountryDTO> citys) {
        this.citys = citys;
    }
}
