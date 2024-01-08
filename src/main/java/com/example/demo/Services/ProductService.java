package com.example.demo.Services;

import com.example.demo.Domain.Product;
import com.example.demo.Domain.Supplier;
import com.example.demo.RepositorySpring.ProductRepositorySpring;

import com.example.demo.RepositorySpring.ProductRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public class ProductService {

    private final ProductRepositorySpring productRepo;

    @Autowired
    public ProductService(ProductRepositorySpring productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProduct(Long productId ) {
        return productRepo.findById(productId);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepo.findById((long) updatedProduct.getProduct_id())
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    existingProduct.setCategory(updatedProduct.getCategory());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setSupplier(updatedProduct.getSupplier());
                    existingProduct.setQuantity(updatedProduct.getQuantity());
                    return productRepo.save(existingProduct);
                })
                .orElse(null);
    }

    public String deleteProduct(Long id) {
        return productRepo.findById(id)
                .map(product -> {
                    productRepo.deleteById(id);
                    return "Product deleted successfully!";
                }).orElse("Product not found!");
    }


}
