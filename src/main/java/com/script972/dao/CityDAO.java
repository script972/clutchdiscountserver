package com.script972.dao;

import com.script972.entity.City;
import com.script972.entity.Company;
import com.script972.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CityDAO implements CityRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<City> getAllCity() {
        return (List<City>) this.entityManager.createQuery("from City").getResultList();
    }
}
