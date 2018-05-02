package com.script972.repository;

import com.script972.entity.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> getListCountry();

    Country addCountry(Country country);

    Country getCountryById(long id);

    Country findCountryByTitleCountry(Country country);
}
