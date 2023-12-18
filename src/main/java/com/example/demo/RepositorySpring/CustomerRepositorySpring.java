package com.example.demo.RepositorySpring;

import com.example.demo.Domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositorySpring extends CrudRepository<Customer, Long> {
//    Customer findByContact(String contact);
}
