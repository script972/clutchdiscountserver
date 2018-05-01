package com.script972.rest;

import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;
import com.script972.enums.TypePhotoPath;
import com.script972.service.CompanyService;
import com.script972.utils.UploadPhotoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping( value = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE )
public class CompanyController {
    @Autowired
    private CompanyService service;


    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> loadAll() {
        return this.service.findAll();
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


    @RequestMapping(method = POST, value = "/uploadphoto", produces = MediaType.TEXT_PLAIN_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException{
        UploadPhotoUtils upload=new UploadPhotoUtils();
        return ResponseEntity.ok(upload.saveUploadedPhoto(file, TypePhotoPath.COMPANY_LOGO));
    }


    @PostMapping
    public CompanyDTO addCompany(@RequestBody Company company){
        return this.service.addComapy(company);
    }



}
