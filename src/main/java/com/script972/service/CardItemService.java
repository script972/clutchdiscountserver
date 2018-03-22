package com.script972.service;

import com.script972.entity.CardItem;
import com.script972.dto.CardItemDTO;

import java.util.List;

public interface CardItemService {
    CardItem findById(Long id);

    CardItem findByNumber(String numberCard);

    List<CardItemDTO> findAll();
}
