package InMemoryRepository;
import Domain.Employee;
import Domain.Job;
import java.util.ArrayList;

public class JobRepository implements InMemoryRepository<Job> {
    private final ArrayList<Job> jobs = new ArrayList<Job>();

    @Override
    public void addItem(Job newJob) {
        jobs.add(newJob);
    }

    @Override
    public void deleteItem(Job jobToBeDeleted) {
        jobs.remove(jobToBeDeleted);
    }

    @Override
    public void updateItem(Job oldJob, Job newJob) {
        int index = jobs.indexOf(oldJob);
        if (index != -1) {
            jobs.set(index,newJob);
        }
    }

    @Override
    public ArrayList<Job> getAllItems() {
        return jobs;
    }

    @Override
    public Job findById(int jobId) {
        for(Job job : jobs) {
            if (job.getJobId() == jobId) {
                return job;
            }
        }
        return null;
    }

}
