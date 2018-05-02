package com.script972.repository;

import com.script972.dto.CityDTO;
import com.script972.entity.City;

import java.util.List;

public interface CityRepository {
    List getAllCity();

    City getById(long id);

    void addCity(City city);

    City getCityByTitle(String title);
}
