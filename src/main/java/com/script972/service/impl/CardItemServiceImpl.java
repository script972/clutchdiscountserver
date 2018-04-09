package com.script972.service.impl;

import com.script972.dto.CardItemPutDTO;
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

    @Autowired
    private UserServiceImpl userRepository;

    @Override
    public CardItemDTO findById(Long id) {
        CardItem card = repository.findById(id);
        return new CardItemDTO(card);
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

    @Override
    public void addItemCard(CardItemPutDTO itemCard) {
        CardItem card=new CardItem(itemCard);
        card.setAuther(userRepository.findById(itemCard.getAuther()));
        repository.addItemCard(card);
    }

    @Override
    public List<CardItemDTO> findByOwnerId(Long ownerid) {
        List<CardItem> list=repository.findByOwner(userRepository.findById(ownerid));
        List<CardItemDTO> result=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CardItemDTO(list.get(i)));
        }
        return result;
    }
}
