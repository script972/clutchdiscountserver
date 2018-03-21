package com.script972.service;

import com.script972.entity.CardItem;
import com.script972.jto.CardItemJTO;
import com.script972.jto.CompanyJTO;

import java.util.List;

public interface CompanyService {

    CompanyJTO findById(Long id);

    CompanyJTO findByTitle(String title);

    CompanyJTO findByAddress(String address);

    List<CompanyJTO> findAll();

}
