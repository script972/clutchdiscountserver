package com.script972.repository;

import com.script972.entity.Company;

import java.util.List;

public interface CompanyRepository {

    Company findByID(long id);

    List<Company> findByTitle(String title);

    List<Company> findByAddress(String address);

    List<Company> findAll();

    List<Company> findAllForCardList();

    List<Company> filterByCountryForCard(Long countryId);

    Company addCompany(Company company);

    void addLogoToComapny(String imageStr, String id);

    List filterByCountry(Long countryId);

    List<Company> filterByCity(Long cityId);

    List<Company> filterByCityForCard(Long cityId);
}
