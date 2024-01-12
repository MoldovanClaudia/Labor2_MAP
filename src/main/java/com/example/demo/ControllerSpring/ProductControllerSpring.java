//package com.example.demo.ControllerSpring;
//
//import com.example.demo.Domain.Product;
//import com.example.demo.Services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductControllerSpring {
//    private final ProductService productService;
//
//    @Autowired
//    public ProductControllerSpring(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<Product>> getAllProducts() {
//        return ResponseEntity.ok(productService.getAllProducts());
//    }
//
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id) {
//        Optional<Product> product = productService.getProduct(id);
//
//        if (product.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(product);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Optional<Product>> updateProduct(@PathVariable Long id,
//                                                             @RequestBody Product product) {
//        if (!product.getProduct_id().equals(id))
//            return ResponseEntity.notFound().build();
//        Optional<Product> updated = Optional.ofNullable(productService.updateProduct(product));
//        return ResponseEntity.ok(updated);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
//        return ResponseEntity.ok(productService.deleteProduct(id));
//    }
//}
