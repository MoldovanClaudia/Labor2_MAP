package UI;

import Controller.JobController;
import Domain.Job;
import InMemoryRepository.JobRepository;

import java.util.Scanner;
import java.util.ArrayList;

public class JobUI {
    public void JobCase(JobRepository jobRepository, JobController jobController) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("1. Add Job");
        System.out.println("2. Delete Job");
        System.out.println("3. Update Job");
        System.out.println("4. Get All Jobs");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter job ID: ");
                int jobId = scanner.nextInt();
                System.out.print("Enter job name: ");
                String jobName = scanner.next();
                System.out.print("Enter job description: ");
                String jobDescription = scanner.next();

                jobController.addJob(jobId, jobName, jobDescription);

                System.out.println("Job added successfully.");
                break;
            case 2:
                System.out.print("Enter job ID to delete: ");
                int jobId2 = scanner.nextInt();

                Job job = new Job(jobId2, "", "");
                jobController.deleteJob(job);

                System.out.println("Job deleted successfully.");
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<Job> jobs = jobController.getAllJobs();

                if (jobs.isEmpty()) {
                    System.out.println("No jobs found.");
                } else {
                    System.out.println("List of Jobs:");
                    for (Job jobIn : jobs) {
                        System.out.println(jobIn);
                    }
                }
                break;
        }
    }
}
