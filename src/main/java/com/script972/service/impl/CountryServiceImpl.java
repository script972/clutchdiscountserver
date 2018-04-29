package com.script972.service.impl;

import com.script972.dto.CountryWithCityListDTO;
import com.script972.entity.Country;
import com.script972.repository.CompanyRepository;
import com.script972.repository.CountryRepository;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> getCountryList() {
        return this.repository.getListCountry();
    }

    @Override
    public List<CountryWithCityListDTO> getCountryListWithCityList() {
        List<CountryWithCityListDTO> returnList=new ArrayList<>();
        List<Country> list = this.repository.getListCountry();
        for (int i = 0; i < list.size(); i++) {
            returnList.add(new CountryWithCityListDTO(list.get(i)));
        }
        return returnList;
    }
}
