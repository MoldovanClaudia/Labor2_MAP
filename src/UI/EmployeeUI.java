package UI;

import Controller.EmployeeController;
import Domain.Employee;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeUI {
    private static EmployeeUI instance;

    private EmployeeUI() {
    }

    public static synchronized EmployeeUI getInstance() {
        if (instance == null) {
            instance = new EmployeeUI();
        }
        return instance;
    }
    public void EmployeeCase(EmployeeController employeeController) {
        Scanner scanner = new Scanner(System.in);


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

                employeeController.deleteEmployee(employeeId2);

                System.out.println("Employee deleted successfully.");
                break;
            case 3:
                System.out.print("Enter employee ID to update: ");
                int employeeIdToUpdate = scanner.nextInt();

                Map<String, String> employee_updates = new HashMap<>();

                System.out.print("Enter new first name (press Enter to skip): ");
                String newFirstName = scanner.nextLine().trim();
                if (!newFirstName.isEmpty()) {
                    employee_updates.put("firstName", newFirstName);
                }

                System.out.print("Enter new last name (press Enter to skip): ");
                String newLastName = scanner.nextLine().trim();
                if (!newLastName.isEmpty()) {
                    employee_updates.put("lastName", newLastName);
                }

                System.out.print("Enter new contact (press Enter to skip): ");
                String newContact = scanner.nextLine().trim();
                if (!newContact.isEmpty()) {
                    employee_updates.put("contact", newContact);
                }

                employeeController.updateEmployee(employeeIdToUpdate, employee_updates);
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
