package com.script972.repository;

import com.script972.dto.CardItemDTO;
import com.script972.entity.CardItem;
import com.script972.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository {

    CardItem findByNumber(String number);

    List<CardItem> findAll();

    void addItemCard(CardItem card);

    CardItem findById(Long id);

    List<CardItem> findByOwner(User byId);
}
