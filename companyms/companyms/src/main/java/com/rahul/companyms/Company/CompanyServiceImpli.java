package com.rahul.companyms.Company;

import java.util.List;

public interface CompanyServiceImpli {
    // Get all jobs
    List<Company> getAllCompany();

    // Add a new job
    void addCompany(Company company);

    // Get a job by its ID
    Company getCompany(long companyId);

    // Delete a job by its ID
    boolean deleteCompany(long companyId);

    // Update an existing job
    boolean updateCompany(Company company, long Id);

    boolean findcompany(long companyId);

    Company getcompanybyid(long id);
}
