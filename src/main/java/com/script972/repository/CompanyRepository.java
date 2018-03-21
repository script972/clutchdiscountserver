package com.script972.repository;

import com.script972.entity.CardItem;
import com.script972.entity.Company;

import java.util.List;

public interface CompanyRepository {

    Company findByID(long id);

    List<Company> findByTitle(String title);

    List<Company> findByAddress(String address);

    List<Company> findAll();
}
