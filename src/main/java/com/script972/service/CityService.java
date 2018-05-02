package com.script972.service;

import com.script972.dto.CityDTO;
import com.script972.entity.City;

import java.util.List;

public interface CityService {
    List<CityDTO> getCityList();

    CityDTO addCity(City city);

    CityDTO getCityById(long id);
}
