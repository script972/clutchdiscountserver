package com.script972.rest;

import com.script972.dto.CompanyDTO;
import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;
import com.script972.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;

    @RequestMapping( method = GET, value = "/{userId}" )
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById( @PathVariable Long userId ) {
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @GetMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }


    @PostMapping
    public ResponseEntity registrationUser(@RequestBody RegistrationUserDTO registrationUserDTO){
        UserDTO user=this.userService.persistUser(registrationUserDTO);
        ResponseEntity responseEntity;
        if (user==null) {
            Map<String, String> result = new HashMap<>();
            result.put( "result", "Fail registration" );
           return responseEntity = new ResponseEntity<>(result,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return responseEntity = new ResponseEntity<>(user,
                    HttpStatus.OK);
        }

    }

    @PutMapping
    public ResponseEntity personalInfo(@RequestBody RegistrationUserDTO registrationUserDTO){
        UserDTO userDTO=this.userService.personalInfo(registrationUserDTO);
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
    public List<UserDTO> getByPhoneNumber(@PathVariable String phonenumber){
        return this.userService.getByPhoneNumber(phonenumber);
    }



}
