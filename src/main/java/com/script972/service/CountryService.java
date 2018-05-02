package com.script972.service;

import com.script972.dto.CountryWithCityListDTO;
import com.script972.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountryList();

    List<CountryWithCityListDTO> getCountryListWithCityList();

    CountryWithCityListDTO addCountry(Country country);
}
