package com.example.demo.RepositorySpring;

import com.example.demo.Domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepositorySpring extends CrudRepository<Product, Long>{
}
