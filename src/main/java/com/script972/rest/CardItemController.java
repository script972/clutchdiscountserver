package com.script972.rest;

import com.script972.dto.CardItemDTO;
import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;
import com.script972.entity.User;
import com.script972.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class CardItemController {

    @Autowired
    private CardItemService service;

   /* @RequestMapping( method = GET, value = "/card/{cardId}" )
*//*    @PreAuthorize("hasRole('USER')")*//*
    public CardItem loadById(@PathVariable Long cardId ) {
        return this.service.findById( cardId );
    }*/

    @RequestMapping( method = GET, value= "/card/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CardItemDTO> loadAll() {
        return this.service.findAll();
    }

    @GetMapping( value= "/card/{cardid}")
    @PreAuthorize("hasRole('ADMIN')")
    public CardItemDTO loadById(@PathVariable("cardid") Long cardid) {
        return this.service.findById(cardid);
    }

    @GetMapping( value= "/card/mycard")
    @PreAuthorize("hasRole('USER')")
    public List<CardItemDTO> loadUserCard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user=(User)authentication.getPrincipal();
            return this.service.findByOwnerId(user.getId());
        }
        return null;
    }



    @PostMapping(value= "/card/")
    @PreAuthorize("hasRole('USER')")
    public void addItemCard(@RequestBody CardItemPutDTO itemCard) {
        this.service.addItemCard(itemCard);
    }



}
