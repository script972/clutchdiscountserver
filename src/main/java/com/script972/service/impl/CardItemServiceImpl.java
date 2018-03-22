package com.script972.service.impl;

import com.script972.entity.CardItem;
import com.script972.dto.CardItemDTO;
import com.script972.repository.CardRepository;
import com.script972.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardItemServiceImpl implements CardItemService {

    @Autowired
    private CardRepository repository;

    @Override
    public CardItem findById(Long id) {
        return null;
    }

    @Override
    public CardItem findByNumber(String numberCard) {
        return repository.findByNumber(numberCard);
    }

    @Override
    public List<CardItemDTO> findAll() {
        List<CardItem> cardItems = this.repository.findAll();
        List<CardItemDTO> jto=new ArrayList<>();
        for (int i = 0; i < cardItems.size(); i++) {
            jto.add(new CardItemDTO(cardItems.get(i)));
        }
        return jto;
    }
}
