package com.script972.rest;

import com.script972.components.CloudStorageHepler;
import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;
import com.script972.enums.TypePhotoPath;
import com.script972.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping( value = "/api/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @Autowired
    private CloudStorageHepler cloudStorageHelper;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CompanyDTO> loadAll() {
        return this.service.findAll();
    }

    @GetMapping("/card")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> loadAllForCompany() {
        return this.service.findAllForCardList();
    }

    @GetMapping("/{companyid}")
    @PreAuthorize("hasRole('USER')")
    public CompanyDTO getCompany(@PathVariable long companyid){
        return this.service.findById(companyid);
    }

    @RequestMapping( method = GET, value= "/filtercountry/{countryId}")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> filterByCountry(@PathVariable Long countryId) {
        return this.service.filterByCountry(countryId);
    }

    @RequestMapping( method = GET, value= "/card/filtercountry/{countryId}")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> filterByCountryForCard(@PathVariable Long countryId) {
        return this.service.filterByCountryForCard(countryId);
    }

    @GetMapping("/filtercity/{cityId}")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> filterByCity(@PathVariable Long cityId) {
        return this.service.filterByCity(cityId);
    }

    @GetMapping("/card/filtercity/{cityId}")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> filterByCityForCard(@PathVariable Long cityId) {
        return this.service.filterByCityForCard(cityId);
    }


    @PostMapping
    public CompanyDTO addCompany(@RequestBody Company company){
        return this.service.addComapy(company);
    }


    @RequestMapping(method = POST, value = "/uploadphoto", produces = MediaType.TEXT_PLAIN_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException{
        String url = cloudStorageHelper.uploadFile(file, TypePhotoPath.COMPANY_LOGO);
        return ResponseEntity.ok(url);
    }


}
