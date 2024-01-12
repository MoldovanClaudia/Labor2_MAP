package com.example.demo.Services;

import com.example.demo.Domain.Employee;
import com.example.demo.RepositorySpring.EmployeeRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepositorySpring employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepositorySpring employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepo.findById(employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.findById(employee.getEmployee_id())
                .map(existingEmployee -> {
                    existingEmployee.setEmployee_firstname(employee.getEmployee_firstname());
                    existingEmployee.setEmployee_lastname(employee.getEmployee_lastname());
                    existingEmployee.setEmployee_contact(employee.getEmployee_contact());

                    // Update associated entities
                    existingEmployee.setStore(employee.getStore());
                    existingEmployee.setJob(employee.getJob());

                    return employeeRepo.save(existingEmployee);
                }).orElse(null);
    }


    public String deleteEmployee(Long id) {
        return employeeRepo.findById(id)
                .map(employee -> {
                    employeeRepo.deleteById(id);
                    return "Employee deleted successfully!";
                }).orElse("Employee not found!");
    }
}
