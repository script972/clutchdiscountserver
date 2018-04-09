package com.script972.service;

import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;
import com.script972.dto.CardItemDTO;

import java.util.List;

public interface CardItemService {
    CardItemDTO findById(Long id);

    CardItem findByNumber(String numberCard);

    List<CardItemDTO> findAll();

    void addItemCard(CardItemPutDTO itemCard);

    List<CardItemDTO> findByOwnerId(Long ownerid);
}
