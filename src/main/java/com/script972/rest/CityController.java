package com.script972.rest;


import com.script972.dto.CityDTO;
import com.script972.entity.City;
import com.script972.service.CityService;
import com.script972.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api/city" )
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{cityid}")
    @PreAuthorize("hasRole('USER')")
    public CityDTO getCityById(@PathVariable("cityid") Long cityid){
        return this.cityService.getCityById(cityid);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<CityDTO> getCityList(){
        return this.cityService.getCityList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CityDTO addCity(@RequestBody City city){
        return this.cityService.addCity(city);
    }


}
