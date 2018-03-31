package com.script972.rest;

import com.script972.dto.CompanyDTO;
import com.script972.enums.TypePhotoPath;
import com.script972.service.CompanyService;
import com.script972.utils.UploadPhotoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class CompanyController {
    @Autowired
    private CompanyService service;


    @RequestMapping( method = GET, value= "/company/all")
    @PreAuthorize("hasRole('USER')")
    public List<CompanyDTO> loadAll() {
        return this.service.findAll();
    }

    @RequestMapping("/company/uploadphoto")
    @PreAuthorize("hasRole('USER')")
    public void uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException{
        //TODO //saveUploadedPhoto(file);
        UploadPhotoUtils upload=new UploadPhotoUtils();
        upload.saveUploadedPhoto(file, TypePhotoPath.COMPANY_LOGO);
    }



}
