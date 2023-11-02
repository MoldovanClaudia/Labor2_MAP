package UI;

import Controller.EmployeeController;
import Domain.Employee;
import InMemoryRepository.EmployeeRepository;

import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeUI {
    public void EmployeeCase(EmployeeRepository employeeRepository, EmployeeController employeeController) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("1. Add ");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Get All");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter employee ID: ");
                int employeeId = scanner.nextInt();
                System.out.print("Enter first name: ");
                String firstName = scanner.next();
                System.out.print("Enter last name: ");
                String lastName = scanner.next();
                System.out.print("Enter contact: ");
                String contact = scanner.next();

                employeeController.addEmployee(employeeId, firstName, lastName, contact);

                System.out.println("Employee added successfully.");
                break;
            case 2:
                System.out.print("Enter employee ID: ");
                int employeeId2 = scanner.nextInt();
                System.out.print("Enter first name: ");
                String firstName2 = scanner.next();
                System.out.print("Enter last name: ");
                String lastName2 = scanner.next();
                System.out.print("Enter contact: ");
                String contact2 = scanner.next();

                Employee employee = new Employee(employeeId2, firstName2, lastName2, contact2);
                employeeController.deleteEmployee(employee);

                System.out.println("Employee deleted successfully.");
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<Employee> employees = employeeController.getAllEmployees();

                if (employees.isEmpty()) {
                    System.out.println("No employees found.");
                } else {
                    System.out.println("List of Employees:");
                    for (Employee employeeIn : employees) {
                        System.out.println(employeeIn);
                    }
                }
                break;
        }
    }
}
