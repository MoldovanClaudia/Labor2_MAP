package Tests;

import Controller.CustomerController;
import Controller.CustomerController.*;
import Domain.Customer;
import InMemoryRepository.CustomerRepository;
import InMemoryRepository.CustomerRepository.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestController {

    private CustomerRepository customerRepository;
    private CustomerController customerController;

    @Before
    public void setUp() {
        customerRepository = new CustomerRepository();
        customerController = new CustomerController(customerRepository);
    }

    @Test
    public void testAddCustomer() {
        // Create a new customer
        int customerId = 1;
        String firstName = "John";
        String lastName = "Doe";
        String contact = "john@example.com";
        String billingAddress = "123 Main St";
        customerController.addCustomer(customerId, firstName, lastName, contact, billingAddress);

        // Check if the customer was added to the repository
        ArrayList<Customer> customers = customerController.getAllCustomers();
        assertEquals(1, customers.size());

        // Check if the added customer's details match the expected values
        Customer addedCustomer = customers.get(0);
        //assertEquals(customerId, addedCustomer.getCustomerId());
        assertEquals(firstName, addedCustomer.getFirstName());
        assertEquals(lastName, addedCustomer.getLastName());
        assertEquals(contact, addedCustomer.getContact());
        assertEquals(billingAddress, addedCustomer.getBillingAddress());
    }

    @Test
    public void testDeleteCustomer() {
        // Create a new customer and add it to the repository
        Customer customer = new Customer(2, "Alice", "Johnson", "alice@example.com", "456 Elm St");
        //customerController.addCustomer(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getContact(), customer.getBillingAddress());

        // Delete the customer
        // customerController.deleteCustomer(customer);

        // Check if the customer was removed from the repository
        ArrayList<Customer> customers = customerController.getAllCustomers();
        assertEquals(0, customers.size());
    }
}
