package com.script972.rest;

import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.TokenDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;
import com.script972.entity.UserTokenState;
import com.script972.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.mobile.device.Device;
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

    @PostMapping("/existinguser")
    public ResponseEntity isExistingUser(@RequestBody RegistrationUserDTO user){
        Boolean res=new Boolean(userService.isExistingByUsername(user.getUsername()));
        Map<String, String> result = new HashMap<>();
        result.put( "result", String.valueOf(res));
        return ResponseEntity.accepted().body(result);

    }



    //TODO don`t work
    @PostMapping("/googleplus")
    public ResponseEntity registrationUserViaGoogle(@RequestBody TokenDTO token, Device device){
        UserTokenState resultToken = userService.registrationViaGoogle(token,device);
        return  new ResponseEntity<>(resultToken,
                HttpStatus.OK);

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
