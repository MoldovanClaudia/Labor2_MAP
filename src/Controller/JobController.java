package Controller;
import Domain.Customer;
import Domain.Employee;
import Domain.Job;
import InMemoryRepository.JobRepository;
import java.util.ArrayList;
import java.util.Map;

public class JobController {
    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(int jobID, String jobName, String jobDescription) {
        Job newJob = new Job(jobID, jobName, jobDescription);
        jobRepository.addItem(newJob);
    }

    public void deleteJob(int jobId) {
        Job job = jobRepository.findById(jobId);
        jobRepository.deleteItem(job);

    }

    public void updateJob(int jobId, Map<String, String> job_updates) {
        Job oldJob = jobRepository.findById(jobId);

        if (oldJob != null) {
            Job newJob = new Job(
                    oldJob.getJobId(),
                    job_updates.containsKey("jobName") ? job_updates.get("jobName") : oldJob.getJobName(),
                    job_updates.containsKey("jobDescription") ? job_updates.get("jobDescription") : oldJob.getJobDescription()
                     );


            jobRepository.updateItem(oldJob, newJob);
            System.out.println("Job updated successfully.");
        } else {
            System.out.println("Job not found.");
        }
    }

    public void updateJob(Job oldJob, Job newJob) {
        jobRepository.updateItem(oldJob, newJob);
    }

    public ArrayList<Job> getAllJobs() {
        return jobRepository.getAllItems();
    }
}
