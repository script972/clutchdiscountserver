package com.script972.repository;

import com.script972.entity.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository {

    CardItem findByNumber(String number);

    List<CardItem> findAll();

}
