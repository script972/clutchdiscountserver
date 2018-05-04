package com.script972.rest;

import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;
import com.script972.enums.TypePhotoPath;
import com.script972.service.CompanyService;
import com.script972.utils.PhotoUtils;
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

    @GetMapping("/filtercity/{cityId}")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> filterByCity(@PathVariable Long cityId) {
        return this.service.filterByCity(cityId);
    }


    @PostMapping
    public CompanyDTO addCompany(@RequestBody Company company){
        return this.service.addComapy(company);
    }


    @RequestMapping(method = POST, value = "/uploadphoto", produces = MediaType.TEXT_PLAIN_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException{
        PhotoUtils upload=new PhotoUtils();
        return ResponseEntity.ok(upload.saveUploadedPhoto(file, TypePhotoPath.COMPANY_LOGO));
    }

    @GetMapping("/getlogophoto/{namephoto}")
    public ResponseEntity getPhoto(@PathVariable String namephoto){
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(this.service.getPhotoByLink(namephoto), headers, HttpStatus.OK);
        } catch (IOException e) {
            responseEntity = new ResponseEntity<>("Current image not found", headers, HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

}
