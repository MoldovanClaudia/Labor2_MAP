package Domain;

public class Job {
    private int jobId;
    private String jobName;
    private String jobDescription;

    public Job(int jobId, String jobName, String jobDescription) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
    }

    public int getJobId() { return this.jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    public String getJobName() { return this.jobName; }
    public void setJobName(String jobName) { this.jobName = jobName; }
    public String getJobDescription() { return this.jobDescription; }
    public void setJobDescription(String jobDescription) { this.jobDescription = jobDescription; }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + jobId +
                ", job name=" + jobName +
                ", job description=" + jobDescription +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Job job = (Job) obj;
        return jobId == job.jobId;
    }


}
