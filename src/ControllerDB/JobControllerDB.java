package ControllerDB;

import Domain.Job;
import RepositoryDB.JobRepositoryDB;
import java.util.ArrayList;
import java.util.Map;

public class JobControllerDB {
    private JobRepositoryDB jobRepository;

    public void JobController(JobRepositoryDB jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobControllerDB(JobRepositoryDB jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(int jobID, String jobName, String jobDescription) {
        Job newJob = new Job(jobID, jobName, jobDescription);
        jobRepository.add(newJob);
    }

    public void deleteJob(ArrayList<String> jobId) {
        Job job = jobRepository.findById(jobId);
        jobRepository.delete(job);

    }

    public void updateJob(ArrayList<String> jobId, Map<String, String> job_updates) {
        Job oldJob = jobRepository.findById(jobId);

        if (oldJob != null) {
            Job newJob = new Job(
                    oldJob.getJobId(),
                    job_updates.containsKey("jobName") ? job_updates.get("jobName") : oldJob.getJobName(),
                    job_updates.containsKey("jobDescription") ? job_updates.get("jobDescription") : oldJob.getJobDescription()
            );


            jobRepository.update(oldJob, newJob);
            System.out.println("Job updated successfully.");
        } else {
            System.out.println("Job not found.");
        }
    }

    public void updateJob(Job oldJob, Job newJob) {
        jobRepository.update(oldJob, newJob);
    }

    public ArrayList<Job> getAllJobs() {
        return jobRepository.readAll();
    }
}
