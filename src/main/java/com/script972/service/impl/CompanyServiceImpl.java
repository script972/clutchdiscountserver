package com.script972.service.impl;

import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;
import com.script972.repository.CompanyRepository;
import com.script972.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;


    @Override
    public CompanyDTO findById(Long id) {
        return new CompanyDTO(repository.findByID(id));
    }

    @Override
    public CompanyDTO findByTitle(String title) {
        return null;
    }

    @Override
    public CompanyDTO findByAddress(String address) {
        return null;
    }

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> list=repository.findAll();
        List<CompanyDTO> result=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CompanyDTO(list.get(i)));
        }
        return result;
    }
}
