package Controller;
import Domain.Job;
import InMemoryRepository.JobRepository;
import java.util.ArrayList;

public class JobController {
    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(int jobID, String jobName, String jobDescription) {
        Job newJob = new Job(jobID, jobName, jobDescription);
        jobRepository.addItem(newJob);
    }

    public void deleteJob(Job job) {
        jobRepository.deleteItem(job);
    }

    public void updateJob(Job oldJob, Job newJob) {
        jobRepository.updateItem(oldJob, newJob);
    }

    public ArrayList<Job> getAllJobs() {
        return jobRepository.getAllItems();
    }
}
