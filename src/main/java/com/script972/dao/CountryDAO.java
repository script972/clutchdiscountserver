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

    @Override
    public Country getCountryById(long id) {
        List<Country> list = entityManager.createQuery("from Country as co where co.id=:paramId ")
                .setParameter("paramId", id)
                .getResultList();
        if(list.size()>0){
            return list.get(0);
        }
        else
            return null;
    }

    @Override
    public Country findCountryByTitleCountry(Country country) {
        List<Country> resultList = entityManager.createQuery("from Country as co where co.title=:paramTitle")
                .setParameter("paramTitle", country.getTitle())
                .getResultList();
        if(resultList.size()>0){
            return resultList.get(0);
        }else
            return null;

    }

    @Override
    public Country addCountry( Country country) {
       // this.entityManager.persist(country);
       return this.entityManager.merge(country);
    }

}
