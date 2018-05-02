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

    @Override
    public City getById(long id) {
        List<City> city=(List<City>)this.entityManager.createQuery("from City as ci where ci.id=:idParam")
                .setParameter("idParam", id)
                .getResultList();
        if(city.size()>0) {
            return city.get(0);
        }
        else
            return null;
    }

    @Override
    public void addCity(City city) {
        this.entityManager.persist(city);
    }
}
