package com.script972.service.impl;

import com.script972.dto.CompanyDTO;
import com.script972.entity.Company;
import com.script972.entity.User;
import com.script972.mappers.CompanyMappers;
import com.script972.repository.CompanyRepository;
import com.script972.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;


    @Override
    public CompanyDTO findById(Long id) {
        return CompanyMappers.companyEntityToDto(repository.findByID(id));
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
        List<Company> list = repository.findAll();

        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }

    @Override
    public List<CompanyDTO> findAllForCardList() {
        List<Company> list = repository.findAllForCardList();
        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }

    @Override
    public CompanyDTO addComapy(Company company) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            // TODO может быть проблема
            user.setCardItems(null);
            // //TODO
            company.setAddedBy(user);
        }
       /* System.out.println("<<<<<"+company.getPosition().getLat());
        System.out.println("<<"+(positionService.getPosition(company.getPosition())));
        if(positionService.getPosition(company.getPosition())==null){
            positionService.addPosition(company.getPosition());
            company.setPosition(positionService.getPosition(company.getPosition()));
        }*/
        repository.addCompany(company);
        return this.findById(company.getId());

    }

    @Override
    public void addLogoToCompany(String imageStr, String id) {
        repository.addLogoToComapny(imageStr, id);
    }

    @Override
    public List<CompanyDTO> filterByCountry(Long countryId) {
        List<Company> list = this.repository.filterByCountry(countryId);
        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }

    @Override
    public List<CompanyDTO> filterByCountryForCard(Long countryId) {
        List<Company> list = this.repository.filterByCountryForCard(countryId);
        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }

    @Override
    public List<CompanyDTO> filterByCity(Long cityId) {
        List<Company> list = this.repository.filterByCity(cityId);
        if (list == null) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setCodeError(3);
            companyDTO.setDescriptionError("Company not found");
            List<CompanyDTO> result = new ArrayList<>();
            result.add(companyDTO);
            return result;
        }
        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }

    @Override
    public List<CompanyDTO> filterByCityForCard(Long cityId) {
        List<Company> list = this.repository.filterByCityForCard(cityId);
        if (list == null) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setCodeError(3);
            companyDTO.setDescriptionError("Company not found");
            List<CompanyDTO> result = new ArrayList<>();
            result.add(companyDTO);
            return result;
        }
        List<CompanyDTO> result = new ArrayList<>();
        for (Company item : list) {
            result.add(CompanyMappers.companyEntityToDto(item));
        }
        return result;
    }


}
