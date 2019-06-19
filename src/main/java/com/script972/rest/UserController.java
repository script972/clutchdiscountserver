package com.script972.rest;

import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.User;
import com.script972.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by script972
 */

@RestController
@RequestMapping( value = "/api/user" )
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping( method = GET, value = "/{userId}" )
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById( @PathVariable Long userId ) {
        logger.info("load User By Id");
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


    /*
     *  We are not using userService.findByEmail here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @GetMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        return this.userService.findByEmail(user.getName());
    }


    @PutMapping
    public ResponseEntity personalInfo(@RequestBody RegistrationStepOneUserDtoRequest registrationUserDTO){
        UserDtoResponce userDTO=this.userService.personalInfo(registrationUserDTO);
        if(userDTO==null){
            Map<String, String> result = new HashMap<>();
            result.put( "result", "Fail update info" );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }else {
            return ResponseEntity.ok(userDTO);
        }
    }

    @GetMapping("/getbyphonenumber/{phonenumber}")
    @PreAuthorize("hasRole('USER')")
    public List<UserDtoResponce> getByPhoneNumber(@PathVariable String phonenumber){
        return this.userService.getByPhoneNumber(phonenumber);
    }

    @PostMapping("/uploadface")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity photoFront(@RequestParam("file") MultipartFile file){
        try {
            String str = this.userService.uploadPhotoFace(file);
            if(str==null){
                return ResponseEntity.badRequest().body("Photo face not upload");
            }
            return ResponseEntity.ok(str);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Photo face not upload");
        }
    }



}
