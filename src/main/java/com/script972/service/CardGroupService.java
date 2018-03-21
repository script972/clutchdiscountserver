package com.script972.service;

import com.script972.entity.CardItem;

import java.util.List;

public interface CardGroupService {
    CardItem findById(Long id);

    CardItem findByNumber(String numberCard);

    List<CardItem> findAll ();
}
