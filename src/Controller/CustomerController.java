package Controller;
import Domain.Customer;
import InMemoryRepository.CustomerRepository;
import java.util.Map;

import java.util.ArrayList;

public class CustomerController{
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(int customerId, String firstName, String lastName, String contact, String billingAddress) {
        Customer newCustomer = new Customer(customerId,firstName,lastName,contact,billingAddress);
        customerRepository.addItem(newCustomer);
    }

    public void deleteCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId);
        customerRepository.deleteItem(customer);

    }

    public void updateCustomer(int customerId, Map<String, String> customer_updates) {
        Customer oldCustomer = customerRepository.findById(customerId);

        if (oldCustomer != null) {
            Customer newCustomer = new Customer(
                    oldCustomer.getCustomerIdId(),
                    customer_updates.containsKey("firstName") ? customer_updates.get("firstName") : oldCustomer.getFirstName(),
                    customer_updates.containsKey("lastName") ? customer_updates.get("lastName") : oldCustomer.getLastName(),
                    customer_updates.containsKey("contact") ? customer_updates.get("contact") : oldCustomer.getContact(),
                    customer_updates.containsKey("billingAddress") ? customer_updates.get("billingAddress") : oldCustomer.getBillingAddress()
            );


            customerRepository.updateItem(oldCustomer, newCustomer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }


    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllItems();
    }
}
