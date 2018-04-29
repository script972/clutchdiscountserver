package com.script972.rest;

import com.script972.dto.CountryWithCityListDTO;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "/api/country" )
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<CountryWithCityListDTO> getListCountry(){
        return this.countryService.getCountryListWithCityList();
    }



}
