package Controller;
import Domain.Employee;
import InMemoryRepository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(int employeeId, String employeeFirstName, String employeeLastName, String employeeContact) {
        Employee newEmployee = new Employee(employeeId, employeeFirstName,employeeLastName, employeeContact);
        employeeRepository.addItem(newEmployee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteItem(employee);
    }

    public void updateEmployee(Employee oldEmployee, Employee newEmployee) {
        employeeRepository.updateItem(oldEmployee, newEmployee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeRepository.getAllItems();
    }
}
