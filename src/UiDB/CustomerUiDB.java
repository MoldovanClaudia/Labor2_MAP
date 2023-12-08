package UiDB;

import ControllerDB.CustomerControllerDB;
import Domain.Customer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerUI {
    private static CustomerUI instance;

    private CustomerUI() {
    }

    public static synchronized CustomerUI getInstance() {
        if (instance == null) {
            instance = new CustomerUI();
        }
        return instance;
    }
    public void CustomerCase(CustomerControllerDB customerController) {
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
                String customerId2 = scanner.next();

                try {
                    int customerID = Integer.parseInt(customerId2);

                    ArrayList<String> customerIdList = new ArrayList<>();
                    customerIdList.add(Integer.toString(customerID));

                    customerController.deleteCustomer(customerIdList);

                    System.out.println("Customer deleted successfully.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer for customer ID.");
                }
                break;

            case 3:
                System.out.print("Enter customer ID to update: ");
                String customerIdToUpdate = scanner.next();

                ArrayList<String> customerIdList = new ArrayList<>();
                customerIdList.add(customerIdToUpdate);

                Map<String, String> customer_updates = new HashMap<>();

                System.out.print("Enter new first name (press Enter to skip): ");
                String newFirstName = scanner.nextLine().trim();
                if (!newFirstName.isEmpty()) {
                    customer_updates.put("firstName", newFirstName);
                }

                System.out.print("Enter new last name (press Enter to skip): ");
                String newLastName = scanner.nextLine().trim();
                if (!newLastName.isEmpty()) {
                    customer_updates.put("lastName", newLastName);
                }

                System.out.print("Enter new contact (press Enter to skip): ");
                String newContact = scanner.nextLine().trim();
                if (!newContact.isEmpty()) {
                    customer_updates.put("contact", newContact);
                }

                System.out.print("Enter new billing address (press Enter to skip): ");
                String newBillingAddress = scanner.nextLine().trim();
                if (!newBillingAddress.isEmpty()) {
                    customer_updates.put("billingAddress", newBillingAddress);
                }

                customerController.update(customerIdList, customer_updates);
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
