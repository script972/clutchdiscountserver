package com.script972.service.impl;

import com.script972.entity.City;
import com.script972.repository.CityRepository;
import com.script972.repository.CompanyRepository;
import com.script972.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> getCityList() {
        return this.repository.getAllCity();
    }
}
