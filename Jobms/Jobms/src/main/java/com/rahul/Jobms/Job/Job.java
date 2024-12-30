package com.rahul.Jobms.Job;


//import com.rahul.JobPortal.Company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobId;
    private String jobTitle;
    private String jobDescription;
    private int minsalary;
    private int maxsalary;
    private String jobLocation;
    private long companyId;

//
//    @ManyToOne
//    Company company;

    public Job(long jobId, String jobTitle, String jobDescription, int minsalary, int maxsalary, String jobLocation) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.jobLocation = jobLocation;

    }


    public Job() {
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }


    public int getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(int minsalary) {
        this.minsalary = minsalary;
    }

    public int getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(int maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", minsalary=" + minsalary +
                ", maxsalary=" + maxsalary +
                ", jobLocation='" + jobLocation + '\'' +
                '}';
    }
}

//Create a Json for this class
//
