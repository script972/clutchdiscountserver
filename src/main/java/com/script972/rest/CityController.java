package com.script972.rest;


import com.script972.entity.City;
import com.script972.service.CityService;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "/api/city" )
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<City> getCityList(){
        return this.cityService.getCityList();
    }

}
