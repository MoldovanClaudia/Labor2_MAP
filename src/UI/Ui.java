package UI;

import java.util.Scanner;
import Controller.*;
import Domain.Customer;
import InMemoryRepository.*;




public class Ui {
    static CustomerRepository customerRepository = new CustomerRepository();
    static CustomerController customerController = new CustomerController(customerRepository);

    static EmployeeRepository employeeRepository = new EmployeeRepository();
    static EmployeeController employeeController= new EmployeeController(employeeRepository);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Labor2_MAP");
            System.out.println("1. Customers");
            System.out.println("2. Employees");
            System.out.println("3. Jobs");
            System.out.println("4. Orders");
            System.out.println("5. Products");
            System.out.println("6. Repair Service");
            System.out.println("7. Reviews and Ratings");
            System.out.println("8. Shipments");
            System.out.println("9. Stores");
            System.out.println("10. Suppliers");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CustomerUI customerUI = new CustomerUI();
                    customerUI.CustomerCase(customerRepository, customerController);
                    break;
                case 2:
                    System.out.println("You selected 'Employees.'");
                    // Implement functionality for managing employees
                    break;
                case 3:
                    System.out.println("You selected 'Jobs.'");
                    // Implement functionality for managing jobs
                    break;
                case 4:
                    System.out.println("You selected 'Orders.'");
                    // Implement functionality for managing orders
                    break;
                case 5:
                    System.out.println("You selected 'Products.'");
                    // Implement functionality for managing products
                    break;
                case 6:
                    System.out.println("You selected 'Repair Service.'");
                    // Implement functionality for managing repair services
                    break;
                case 7:
                    System.out.println("You selected 'Reviews and Ratings.'");
                    // Implement functionality for managing reviews and ratings
                    break;
                case 8:
                    System.out.println("You selected 'Shipments.'");
                    // Implement functionality for managing shipments
                    break;
                case 9:
                    System.out.println("You selected 'Stores.'");
                    // Implement functionality for managing stores
                    break;
                case 10:
                    System.out.println("You selected 'Suppliers.'");
                    // Implement functionality for managing suppliers
                    break;
                case 11:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

}
