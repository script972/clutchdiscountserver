package com.script972.service;

import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;

import java.util.List;

public interface CompanyService {

    CompanyDTO findById(Long id);

    CompanyDTO findByTitle(String title);

    CompanyDTO findByAddress(String address);

    List<CompanyDTO> findAll();

    CompanyDTO addComapy(Company company);

    void addLogoToCompany(String imageStr, String id);

    List<CompanyDTO> filterByCountry(Long countryId);
}
