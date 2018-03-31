package com.script972.rest;

import com.script972.dto.CardItemDTO;
import com.script972.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class CardController {

    @Autowired
    private CardItemService service;

   /* @RequestMapping( method = GET, value = "/card/{cardId}" )
*//*    @PreAuthorize("hasRole('USER')")*//*
    public CardItem loadById(@PathVariable Long cardId ) {
        return this.service.findById( cardId );
    }*/

    @RequestMapping( method = GET, value= "/card/all")
    @PreAuthorize("hasRole('USER')")
    public List<CardItemDTO> loadAll() {
        return this.service.findAll();
    }


}
