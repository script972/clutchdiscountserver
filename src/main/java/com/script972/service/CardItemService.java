package com.script972.service;

import com.script972.entity.CardItem;
import com.script972.entity.User;
import com.script972.jto.CardItemJTO;

import java.util.List;

public interface CardItemService {
    CardItem findById(Long id);

    CardItem findByNumber(String numberCard);

    List<CardItemJTO> findAll();
}
