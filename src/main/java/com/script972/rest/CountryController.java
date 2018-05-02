package com.script972.rest;

import com.script972.dto.CountryWithCityListDTO;
import com.script972.entity.Country;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public CountryWithCityListDTO addCountry(@RequestBody Country country){
        return this.countryService.addCountry(country);
    }


}
