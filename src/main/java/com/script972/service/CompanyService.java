package com.script972.service;

import com.script972.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO findById(Long id);

    CompanyDTO findByTitle(String title);

    CompanyDTO findByAddress(String address);

    List<CompanyDTO> findAll();

}
