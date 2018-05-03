package com.script972.rest;

import com.script972.dto.CardItemDTO;
import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;
import com.script972.entity.User;
import com.script972.enums.TypePhotoPath;
import com.script972.service.CardItemService;
import com.script972.utils.UploadPhotoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping( value = "/api/card")
public class CardItemController {

    @Autowired
    private CardItemService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CardItemDTO> loadAll() {
        return this.service.findAll();
    }

    @GetMapping( value= "/{cardid}")
    @PreAuthorize("hasRole('ADMIN')")
    public CardItemDTO loadById(@PathVariable("cardid") Long cardid) {
        return this.service.findById(cardid);
    }

    @GetMapping( value= "/mycard")
    @PreAuthorize("hasRole('USER')")
    public List<CardItemDTO> loadUserCard() {
        return this.service.findMyCard();

    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public CardItemDTO addItemCard(@RequestBody CardItemPutDTO itemCard) {
        return this.service.addItemCard(itemCard);
    }

    @PostMapping("/frontPhoto")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity photoFront(@RequestParam("file") MultipartFile file) throws IOException{
        String str = this.service.uploadPhotoFront(file);
        //UploadPhotoUtils upload=new UploadPhotoUtils();
        return ResponseEntity.ok(str);

    }

}
