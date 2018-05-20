package com.script972.dao;

import com.script972.dto.CardItemDTO;
import com.script972.entity.CardItem;
import com.script972.entity.User;
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
        return (List<CardItem>) entityManager.createQuery("from CardItem ci where ci.available=TRUE order by ci.score").getResultList();

    }

    @Override
    public void addItemCard(CardItem card) {
        entityManager.persist(card);
    }

    @Override
    public CardItem findById(Long id) {
        List<CardItem> listDB=(List<CardItem>)entityManager.createQuery("from CardItem ca where ca.id=:paramOne order by ca.score desc")
                .setParameter("paramOne", id)
                .getResultList();
        if(listDB!=null && listDB.size()>0){
            return listDB.get(0);
        }
        else
            return null;
    }

    @Override
    public List<CardItem> findByOwner(User user) {
        return (List<CardItem>) entityManager.createQuery("select distinct ca from CardItem ca where ca.auther = :auther " +
                "order by ca.score desc ")
                .setParameter("auther", user)
                .getResultList();
    }

}
