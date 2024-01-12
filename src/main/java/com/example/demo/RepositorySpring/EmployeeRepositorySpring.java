package com.example.demo.RepositorySpring;

import com.example.demo.Domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositorySpring extends CrudRepository<Employee, Long> {
}
