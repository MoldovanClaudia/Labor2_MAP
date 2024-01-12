package com.example.demo.Services;

import com.example.demo.Domain.Job;
import com.example.demo.RepositorySpring.JobRepositorySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    private final JobRepositorySpring jobRepo;

    @Autowired
    public JobService(JobRepositorySpring jobRepo) {
        this.jobRepo = jobRepo;
    }

    public Job createJob(Job job) {
        return jobRepo.save(job);
    }

    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJob(Long jobId ) {
        return jobRepo.findById(jobId);
    }

    public Job updateJob(Job updatedJob) {
        return jobRepo.findById(updatedJob.getJob_id())
                .map(existingJob -> {
                    existingJob.setJob_name(updatedJob.getJob_name());
                    existingJob.setJob_description(updatedJob.getJob_description());
                    return jobRepo.save(existingJob);
                })
                .orElse(null);
    }


    public String deleteJob(Long id) {
        return jobRepo.findById(id)
                .map(job -> {
                    jobRepo.deleteById(id);
                    return "Job deleted successfully!";
                }).orElse("Job not found!");
    }


}
