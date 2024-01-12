//package com.example.demo.Tests;
//
//import com.example.demo.Domain.Customer;
//import com.example.demo.RepositorySpring.CustomerRepositorySpring;
//import com.example.demo.Services.CustomerService;
//import org.testng.annotations.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
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
//        // Arrange
//        Customer mockCustomer = new Customer();
//        mockCustomer.setCustomer_id(1L);
//        mockCustomer.setFirstname("John");
//        mockCustomer.setLastname("Doe");
//        mockCustomer.setContact("1234567890");
//        mockCustomer.setBilling_address("123 Main Street");
//
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(mockCustomer);
//
//        // Act
//        Customer createdCustomer = customerService.createCustomer(mockCustomer);
//
//        // Assert
//        assertEquals(mockCustomer, createdCustomer);
//    }
//
//    @Test
//    public void testUpdateCustomer() {
//        // Arrange
//        Long customerId = 1L;
//        Customer existingCustomer = new Customer();
//        existingCustomer.setCustomer_id(customerId);
//        existingCustomer.setFirstname("John");
//        existingCustomer.setLastname("Doe");
//        existingCustomer.setContact("1234567890");
//        existingCustomer.setBilling_address("123 Main Street");
//
//        Customer updatedCustomer = new Customer();
//        updatedCustomer.setCustomer_id(customerId);
//        updatedCustomer.setFirstname("UpdatedJohn");
//        updatedCustomer.setLastname("UpdatedDoe");
//        updatedCustomer.setContact("9876543210");
//        updatedCustomer.setBilling_address("456 Updated Street");
//
//        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(updatedCustomer);
//
//        // Act
//        Optional<Customer> result = Optional.ofNullable(customerService.updateCustomer(updatedCustomer));
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(updatedCustomer.getFirstname(), result.get().getFirstname());
//        assertEquals(updatedCustomer.getLastname(), result.get().getLastname());
//        assertEquals(updatedCustomer.getContact(), result.get().getContact());
//        assertEquals(updatedCustomer.getBilling_address(), result.get().getBilling_address());
//    }
//}
