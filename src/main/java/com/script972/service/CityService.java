package com.script972.service;

import com.script972.entity.City;

import java.util.List;

public interface CityService {
    List<City> getCityList();

    City addCity(City city);
}
