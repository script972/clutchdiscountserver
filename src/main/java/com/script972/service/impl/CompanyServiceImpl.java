package com.script972.service.impl;

import com.script972.entity.Company;
import com.script972.jto.CompanyJTO;
import com.script972.repository.CardRepository;
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
    public CompanyJTO findById(Long id) {
        return new CompanyJTO(repository.findByID(id));
    }

    @Override
    public CompanyJTO findByTitle(String title) {
        return null;
    }

    @Override
    public CompanyJTO findByAddress(String address) {
        return null;
    }

    @Override
    public List<CompanyJTO> findAll() {
        List<Company> list=repository.findAll();
        List<CompanyJTO> result=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new CompanyJTO(list.get(i)));
        }
        return result;
    }
}
