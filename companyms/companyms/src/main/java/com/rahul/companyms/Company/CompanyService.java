package com.rahul.companyms.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceImpli {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
        System.out.println(company);
    }

    @Override
    public Company getCompany(long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public boolean deleteCompany(long companyId) {
        companyRepository.deleteById(companyId);
        return true;
    }

    @Override
    public boolean updateCompany(Company company, long Id) {
        Optional<Company> existingCompany = companyRepository.findById(Id);
        if (existingCompany.isPresent()) {
            Company updatedCompany = existingCompany.get();
            updatedCompany.setCompanyDescription(company.getCompanyDescription());
            updatedCompany.setCompanyName(company.getCompanyName());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean findcompany(long companyId) {
        return companyRepository.findById(companyId).isPresent();
    }

    @Override
    public Company getcompanybyid(long id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company;
    }
}
