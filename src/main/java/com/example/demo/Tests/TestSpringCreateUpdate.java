//package com.example.demo.Tests;
//
//import com.example.demo.Domain.Customer;
//import com.example.demo.RepositorySpring.CustomerRepositorySpring;
//import com.example.demo.Services.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//
//@SpringBootTest
//public class CustomerServiceTests {
//
//    @Mock
//    private CustomerRepositorySpring customerRepository;
//
//    @InjectMocks
//    private CustomerService customerService;
//
//    @Test
//    public void testCreateCustomer() {
//        // Create a sample customer
//        Customer newCustomer = new Customer();
//        newCustomer.setCustomer_id(1L);
//        newCustomer.setFirstname("John");
//        newCustomer.setLastname("Doe");
//        newCustomer.setContact("1234567890");
//        newCustomer.setBilling_address("123 Main St");
//
//        // Mock the save method of the repository to return the customer
//        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(newCustomer);
//
//        // Call the createCustomer method
//        Customer createdCustomer = customerService.createCustomer(newCustomer);
//
//        // Verify that the save method was called with the correct customer
//        Mockito.verify(customerRepository, Mockito.times(1)).save(any(Customer.class));
//
//        // Verify that the returned customer matches the expected customer
//        assertEquals(newCustomer, createdCustomer);
//    }
//
//    @Test
//    public void testUpdateCustomer() {
//        // Create a sample customer
//        Customer existingCustomer = new Customer();
//        existingCustomer.setCustomer_id(1L);
//        existingCustomer.setFirstname("John");
//        existingCustomer.setLastname("Doe");
//        existingCustomer.setContact("1234567890");
//        existingCustomer.setBilling_address("123 Main St");
//
//        // Mock the findById method of the repository to return the existing customer
//        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(existingCustomer));
//
//        // Create an updated customer
//        Customer updatedCustomer = new Customer();
//        updatedCustomer.setCustomer_id(1L);
//        updatedCustomer.setFirstname("UpdatedJohn");
//        updatedCustomer.setLastname("UpdatedDoe");
//        updatedCustomer.setContact("9876543210");
//        updatedCustomer.setBilling_address("456 New St");
//
//        // Mock the save method of the repository to return the updated customer
//        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);
//
//        // Call the updateCustomer method
//        Customer result = customerService.updateCustomer(updatedCustomer);
//
//        // Verify that the findById method was called with the correct ID
//        Mockito.verify(customerRepository, Mockito.times(1)).findById(1L);
//
//        // Verify that the save method was called with the correct customer
//        Mockito.verify(customerRepository, Mockito.times(1)).save(any(Customer.class));
//
//        // Verify that the returned customer matches the expected updated customer
//        assertEquals(updatedCustomer, result);
//    }
//}
//
