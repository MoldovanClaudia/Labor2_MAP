package ControllerDB;
import Domain.Employee;
import RepositoryDB.EmployeeRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeControllerDB {
    private EmployeeRepositoryDB employeeRepository;

    public void EmployeeController(EmployeeRepositoryDB employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeControllerDB(EmployeeRepositoryDB employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(int employeeId, String employeeFirstName, String employeeLastName, String employeeContact) {
        Employee newEmployee = new Employee(employeeId, employeeFirstName,employeeLastName, employeeContact);
        employeeRepository.add(newEmployee);
    }

    public void deleteEmployee(ArrayList<String> employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        employeeRepository.delete(employee);

    }

    public void updateEmployee(ArrayList<String> employeeId, Map<String, String> employee_updates) {
        Employee oldEmployee = employeeRepository.findById(employeeId);

        if (oldEmployee != null) {
            Employee newEmployee = new Employee(
                    oldEmployee.getEmployeeId(),
                    employee_updates.containsKey("employeeFirstName") ? employee_updates.get("employeeFirstName") : oldEmployee.getEmployeeFirstName(),
                    employee_updates.containsKey("employeeLastName") ? employee_updates.get("employeeLastName") : oldEmployee.getEmployeeLastName(),
                    employee_updates.containsKey("employeeContact") ? employee_updates.get("employeeContact") : oldEmployee.getEmployeeContact(),
                    oldEmployee.getJobId(),
                    oldEmployee.getStoreId()

            );


            employeeRepository.update(oldEmployee, newEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }


    public void updateEmployee(Employee oldEmployee, Employee newEmployee) {
        employeeRepository.update(oldEmployee, newEmployee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeRepository.readAll();
    }
}
