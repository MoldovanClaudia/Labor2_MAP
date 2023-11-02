package UI;

import Controller.CustomerController;
import Domain.Customer;
import InMemoryRepository.CustomerRepository;

import java.util.Scanner;
import java.util.ArrayList;

public class CustomerUI {
    public void CustomerCase(CustomerRepository customerRepository, CustomerController customerController) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Get All");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter customer ID: ");
                int customerId = scanner.nextInt();
                System.out.print("Enter first name: ");
                String firstName = scanner.next();
                System.out.print("Enter last name: ");
                String lastName = scanner.next();
                System.out.print("Enter contact: ");
                String contact = scanner.next();
                System.out.print("Enter billing address: ");
                String billingAddress = scanner.next();

                customerController.addCustomer(customerId, firstName, lastName, contact, billingAddress);

                System.out.println("Customer added successfully.");
                break;
            case 2:
                System.out.print("Enter customer ID: ");
                int customerId2 = scanner.nextInt();
                System.out.print("Enter first name: ");
                String firstName2 = scanner.next();
                System.out.print("Enter last name: ");
                String lastName2 = scanner.next();
                System.out.print("Enter contact: ");
                String contact2 = scanner.next();
                System.out.print("Enter billing address: ");
                String billingAddress2 = scanner.next();

                Customer customer = new Customer(customerId2, firstName2, lastName2, contact2, billingAddress2);
                customerController.deleteCustomer(customer);

                System.out.println("Customer deleted successfully.");
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<Customer> customers = customerController.getAllCustomers();

                if (customers.isEmpty()) {
                    System.out.println("No customers found.");
                } else {
                    System.out.println("List of Customers:");
                    for (Customer customerIn : customers) {
                        System.out.println(customerIn);
                    }
                }
                break;
        }
    }
}
