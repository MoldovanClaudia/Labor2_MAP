package com.example.demo.ControllerSpring;

import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Job;
import com.example.demo.Services.CustomerService;
import com.example.demo.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")

public class JobControllerSpring {
    private final JobService jobService;

    @Autowired
    public JobControllerSpring(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createJob(job));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJob(@PathVariable Long id) {
        Optional<Job> job = jobService.getJob(id);

        if (job.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Job>> updateJob(@PathVariable Long id,
                                                             @RequestBody Job job) {
        if (!job.getJob_id().equals(id))
            return ResponseEntity.notFound().build();
        Optional<Job> updated = Optional.ofNullable(jobService.updateJob(job));
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.deleteJob(id));
    }
}
