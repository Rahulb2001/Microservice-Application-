package com.rahul.companyms.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getallcompanies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PostMapping("/addcompany")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        if (company != null) {
            companyService.addCompany(company);
            return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatecompany/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Company company) {
        company.setCompanyId(id);  // Ensure we are updating the correct job by ID
        if (companyService.updateCompany(company, id)) {
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletecompany/{Id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long Id) {
        if (companyService.deleteCompany(Id)) {
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comapny not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getcompanybyid/{Id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long Id) {
        Company company = companyService.getCompany(Id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(company, HttpStatus.NOT_FOUND);
        }
    }


}
