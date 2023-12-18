package com.example.demo.Services;

import com.example.demo.Domain.Customer;
import com.example.demo.RepositorySpring.CustomerRepositorySpring;
import com.example.demo.RepositorySpring.OrderRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepositorySpring customerRepo;
    private final OrderRepositorySpring orderRepo;


    @Autowired
    public CustomerService(CustomerRepositorySpring customerRepo, OrderRepositorySpring orderRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomer(Long customerId ) {
        return customerRepo.findById(customerId);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.findById(customer.getCustomer_id())
                .map(existingCustomer -> {
                    existingCustomer.setFirstname(customer.getFirstname());
                    existingCustomer.setLastname(customer.getLastname());
                    existingCustomer.setContact(customer.getContact());
                    existingCustomer.setBilling_address(customer.getBilling_address());

                    return customerRepo.save(existingCustomer);
                }).orElse(null);
    }

    public String deleteCustomer(Long id) {
        return customerRepo.findById(id)
                .map(customer -> {
                    customerRepo.deleteById(id);
                    return "Customer deleted successfully!";
                }).orElse("Customer not found!");
    }

}
