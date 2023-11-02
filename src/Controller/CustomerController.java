package Controller;
import Domain.Customer;
import InMemoryRepository.CustomerRepository;

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

    public void deleteCustomer(Customer customer) {
        customerRepository.deleteItem(customer);
    }

    public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
        customerRepository.updateItem(oldCustomer, newCustomer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllItems();
    }
}
