package Controller;
import Domain.Customer;
import Domain.Employee;
import InMemoryRepository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(int employeeId, String employeeFirstName, String employeeLastName, String employeeContact) {
        Employee newEmployee = new Employee(employeeId, employeeFirstName,employeeLastName, employeeContact);
        employeeRepository.addItem(newEmployee);
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        employeeRepository.deleteItem(employee);

    }

    public void updateEmployee(int employeeId, Map<String, String> employee_updates) {
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


            employeeRepository.updateItem(oldEmployee, newEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }


    public void updateEmployee(Employee oldEmployee, Employee newEmployee) {
        employeeRepository.updateItem(oldEmployee, newEmployee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeRepository.getAllItems();
    }
}
