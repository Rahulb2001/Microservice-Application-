package com.rahul.Jobms.Job;


import com.rahul.Jobms.Job.DTOS.CompanyWithJob;

import java.util.List;


public interface Jobservice {

    List<CompanyWithJob> getAllJobs();

    boolean addJob(Job job);

    CompanyWithJob getJobById(long jobId);

    boolean deleteJob(long jobId);

    boolean updateJob(Job job, long jobId);


}
