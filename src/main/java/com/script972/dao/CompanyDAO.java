package com.script972.dao;

import com.script972.dto.CompanyDTO;
import com.script972.entity.CardItem;
import com.script972.entity.Company;
import com.script972.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Override
    public Company addCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void addLogoToComapny(String imageStr, String id) {
        String queryString = "update Company set logo = :nameLogo"+
                " where id = :idCode";


        int result = entityManager.createQuery(queryString)
                .setParameter("nameLogo", imageStr)
                .setParameter("idCode", id)
                .executeUpdate();

    }

    @Override
    public List<Company> filterByCountry(Long countryId) {
         List resultList=entityManager.createNativeQuery("SELECT DISTINCT\n" +
                "  company.* \n" +
                "FROM\n" +
                "  company\n" +
                "WHERE\n" +
                "  company.city_id in (SELECT id FROM city WHERE country_id in (SELECT id FROM country WHERE id = ?)) " +
                         "AND company.available=TRUE ORDER BY company.scores",
                 Company.class).setParameter(1, countryId).getResultList();
         List<Company> result=new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            result.add((Company)resultList.get(i));
        }
        return result;
    }

    @Override
    public List<Company> filterByCity(Long cityId) {
        return (List<Company>) entityManager.createQuery("from Company as co where co.city.id = :paramCity")
                .setParameter("paramCity", cityId)
                .getResultList();
      /*  return (List<Company>) entityManager.createNativeQuery("SELECT DISTINCT\n" +
                        "  company.* \n" +
                        "FROM\n" +
                        "  company\n" +
                        "WHERE\n" +
                        "  company.city_id in (SELECT id FROM city WHERE country_id in (SELECT id FROM country WHERE id = ?)) " +
                        "AND company.available=TRUE ORDER BY company.scores",
                Company.class).setParameter(1, cityId).getResultList();*/
    }
}
