package com.script972.dao;

import com.script972.entity.CardItem;
import com.script972.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CardItemDAO implements CardRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public CardItem findByNumber(String number) {
        return null;
    }

    @Override
    public List<CardItem> findAll() {
        return (List<CardItem>) entityManager.createQuery("from CardItem ").getResultList();

    }

}
