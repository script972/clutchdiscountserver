package com.script972.dao;

import com.script972.entity.CardItem;
import com.script972.entity.Company;
import com.script972.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanyDAO implements CompanyRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Company findByID(long id) {
        return (Company) entityManager.createQuery("from Company as company where company.id = "+id).getResultList().get(0);
    }

    @Override
    public List<Company> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Company> findByAddress(String address) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        return (List<Company>) entityManager.createQuery("from Company ").getResultList();
    }
}
