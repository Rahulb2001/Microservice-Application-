package com.rahul.Jobms.Job;


import com.rahul.Jobms.Job.DTOS.CompanyWithJob;
import com.rahul.Jobms.Job.External.Company;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplimentation implements Jobservice {

    JobRepository jobRepository;

    //    CompanyServiceImpli companyService;
    @Autowired
    RestTemplate restTemplate;

    public JobServiceImplimentation(JobRepository jobRepository) {

        this.jobRepository = jobRepository;
    }

    @Override
    public List<CompanyWithJob> getAllJobs() {


//          For one Entity
//        RestTemplate restTemplate = new RestTemplate();
//        Company company = restTemplate.getForObject("http://localhost:8081/companies/getcompanybyid/1", Company.class);
//        System.out.println(company);

        //RestTemplate restTemplate = new RestTemplate();
        List<Job> jobList = jobRepository.findAll();
        List<CompanyWithJob> companyWithJobs = new ArrayList<>();

        for (int i = 0; i < jobList.size(); i++) {

            CompanyWithJob companyWithJob = new CompanyWithJob();
            companyWithJob.setJob(jobList.get(i));
            //    Company company = restTemplate.getForObject("http://localhost:8081/companies/getcompanybyid/"+jobList.get(i).getCompanyId(), Company.class);
            Company company = restTemplate.getForObject("http://COMPANYMS:8081/companies/getcompanybyid/" + jobList.get(i).getCompanyId(), Company.class);
            companyWithJob.setCompany(company);
            companyWithJobs.add(companyWithJob);
        }


        return companyWithJobs;
    }

    @Override
    public boolean addJob(Job job) {

        if (job == null) {
            return false;
        } else {
            jobRepository.save(job);
            return true;
        }
    }

    @Override
    public CompanyWithJob getJobById(long jobId) {

        Job job = jobRepository.findById(jobId).orElse(null);
        Company company = restTemplate.getForObject("http://COMPANYMS:8081/companies/getcompanybyid/" + job.getCompanyId(), Company.class);
        CompanyWithJob companyWithJob = new CompanyWithJob();
        companyWithJob.setJob(job);
        companyWithJob.setCompany(company);
        return companyWithJob;
    }

    @Override
    public boolean deleteJob(long jobId) {
        try {
            jobRepository.deleteById(jobId);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public boolean updateJob(Job job, long jobId) {
        Optional<Job> existingJob = jobRepository.findById(jobId);
        if (existingJob.isPresent()) {
            Job updatedJob = existingJob.get();
            updatedJob.setJobTitle(job.getJobTitle());
            updatedJob.setJobDescription(job.getJobDescription());
            updatedJob.setMinsalary(job.getMinsalary());
            updatedJob.setMaxsalary(job.getMaxsalary());
            updatedJob.setJobLocation(job.getJobLocation());
            jobRepository.save(updatedJob);
            return true;
        }
        return false;
    }
}
