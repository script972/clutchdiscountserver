package com.script972.dao;

import com.script972.entity.Country;
import com.script972.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CountryDAO implements CountryRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Country> getListCountry() {
        return entityManager.createQuery("from Country").getResultList();
    }
}
