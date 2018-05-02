package com.script972.service.impl;

import com.script972.dto.CityDTO;
import com.script972.entity.City;
import com.script972.repository.CityRepository;
import com.script972.repository.CompanyRepository;
import com.script972.repository.CountryRepository;
import com.script972.service.CityService;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;
    @Autowired
    private CountryService countryService;


    @Override
    public CityDTO getCityById(long id) {
        return new CityDTO(repository.getById(id));
    }

    @Override
    public List<CityDTO> getCityList() {
        List<City> cityList = this.repository.getAllCity();
        List<CityDTO> resultCity=new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            resultCity.add(new CityDTO(cityList.get(0)));
        }
        return resultCity;
    }

    @Override
    public CityDTO addCity(City city) {
        if(this.repository.getCityByTitle(city.getCity())!=null){
            CityDTO cityDTO=new CityDTO(city);
            cityDTO.setCodeError(1);
            cityDTO.setDescriptionError("City with this title already added");
            return cityDTO;
        }

        if(city.getCountry()!=null) {
            city.setCountry(this.countryService.getCountryByID(city.getCountry().getId()));

        }

        this.repository.addCity(city);

        City addedCity=this.repository.getById(city.getId());
        if(addedCity==null){
            CityDTO cityDTO=new CityDTO(city);
            cityDTO.setCodeError(2);
            cityDTO.setDescriptionError("The City was not added");
            return cityDTO;
        }else{
            return new CityDTO(addedCity);
        }

    }





}
