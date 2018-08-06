package com.script972.rest;

import com.script972.dto.CardItemDTO;
import com.script972.dto.CardItemPutDTO;
import com.script972.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
        System.out.println(itemCard.getFacePhoto());
        return this.service.addItemCard(itemCard);
    }

    @PostMapping("/frontphoto")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity photoFront(@RequestParam("file") MultipartFile file){
        try {
            String str = this.service.uploadPhotoFront(file);
            return ResponseEntity.ok(str);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Image front side not upload");
        }
    }

    @PostMapping("/backphoto")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity photoBack(@RequestParam("file") MultipartFile file){
        try {
            String str = this.service.uploadPhotoBack(file);
            return ResponseEntity.ok(str);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Image back side not upload");
        }
    }

}
