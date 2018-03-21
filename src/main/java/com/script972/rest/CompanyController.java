package com.script972.rest;

import com.script972.jto.CardItemJTO;
import com.script972.jto.CompanyJTO;
import com.script972.service.CardItemService;
import com.script972.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class CompanyController {
    @Autowired
    private CompanyService service;


    @RequestMapping( method = GET, value= "/company/all")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyJTO> loadAll() {
        return this.service.findAll();
    }


}
