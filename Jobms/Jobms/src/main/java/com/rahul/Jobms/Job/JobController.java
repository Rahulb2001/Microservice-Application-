package com.rahul.Jobms.Job;

import com.rahul.Jobms.Job.DTOS.CompanyWithJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    JobServiceImplimentation jobServiceImplimentation;

    public JobController(JobServiceImplimentation jobServiceImplimentation) {
        this.jobServiceImplimentation = jobServiceImplimentation;
    }

    @PostMapping("/addjob")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        System.out.println(job);
        boolean result = jobServiceImplimentation.addJob(job);
        if (result) {
            return new ResponseEntity<>("Job added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company doesn't exist", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getalljobs")
    public ResponseEntity<List<CompanyWithJob>> getAllJobs() {
        return new ResponseEntity<>(jobServiceImplimentation.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/getjobbyid/{jobId}")
    public ResponseEntity<CompanyWithJob> getJobById(@PathVariable long jobId) {
        CompanyWithJob job = jobServiceImplimentation.getJobById(jobId);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(jobServiceImplimentation.getJobById(jobId), HttpStatus.OK);
        }
    }

    @PutMapping("/updatejob/{jobId}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable long jobId) {
        jobServiceImplimentation.updateJob(job, jobId);
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deletejob/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable long jobId) {
        jobServiceImplimentation.deleteJob(jobId);
        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }

}
