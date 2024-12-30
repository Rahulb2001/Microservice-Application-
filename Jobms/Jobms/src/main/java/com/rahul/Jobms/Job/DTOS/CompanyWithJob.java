package com.rahul.Jobms.Job.DTOS;

import com.rahul.Jobms.Job.External.Company;
import com.rahul.Jobms.Job.Job;

public class CompanyWithJob {

    Company company;
    Job job;

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }
}
