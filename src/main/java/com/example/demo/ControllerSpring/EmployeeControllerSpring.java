package com.example.demo.ControllerSpring;

import com.example.demo.Domain.Employee;
import com.example.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerSpring {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeControllerSpring(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);

        if (employee.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable Long id,
                                                             @RequestBody Employee employee) {
        if (!employee.getEmployee_id().equals(id))
            return ResponseEntity.notFound().build();
        Optional<Employee> updated = Optional.ofNullable(employeeService.updateEmployee(employee));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
