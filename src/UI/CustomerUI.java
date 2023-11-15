package UI;

import Controller.CustomerController;
import Domain.Customer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerUI {
    public void CustomerCase(CustomerController customerController) {
        Scanner scanner = new Scanner(System.in);

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

                customerController.deleteCustomer(customerId2);

                System.out.println("Customer deleted successfully.");
                break;
            case 3:
                System.out.print("Enter customer ID to update: ");
                int customerIdToUpdate = scanner.nextInt();

                Map<String, String> updates = new HashMap<>();

                // Collect the attribute-value pairs to update
                System.out.print("Enter new first name (press Enter to skip): ");
                String newFirstName = scanner.nextLine().trim();
                if (!newFirstName.isEmpty()) {
                    updates.put("firstName", newFirstName);
                }

                System.out.print("Enter new last name (press Enter to skip): ");
                String newLastName = scanner.nextLine().trim();
                if (!newLastName.isEmpty()) {
                    updates.put("lastName", newLastName);
                }

                System.out.print("Enter new contact (press Enter to skip): ");
                String newContact = scanner.nextLine().trim();
                if (!newContact.isEmpty()) {
                    updates.put("contact", newContact);
                }

                System.out.print("Enter new billing address (press Enter to skip): ");
                String newBillingAddress = scanner.nextLine().trim();
                if (!newBillingAddress.isEmpty()) {
                    updates.put("billingAddress", newBillingAddress);
                }

                customerController.updateCustomer(customerIdToUpdate, updates);
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
