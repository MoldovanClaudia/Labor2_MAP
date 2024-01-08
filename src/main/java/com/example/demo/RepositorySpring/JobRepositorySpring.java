package com.example.demo.RepositorySpring;

import com.example.demo.Domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepositorySpring extends CrudRepository<Job, Long> {
}
