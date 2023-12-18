package com.example.demo.ControllerSpring;

import com.example.demo.Domain.Customer;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerControllerSpring {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerSpring(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomer(id);

        if (customer.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@PathVariable Long id,
                                                             @RequestBody Customer customer) {
        if (!customer.getCustomer_id().equals(id))
            return ResponseEntity.notFound().build();
        Optional<Customer> updated = Optional.ofNullable(customerService.updateCustomer(customer));
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}
