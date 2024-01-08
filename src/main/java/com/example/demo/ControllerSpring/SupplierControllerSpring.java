package com.example.demo.ControllerSpring;

import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Supplier;
import com.example.demo.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierControllerSpring {
    private final SupplierService supplierService;

    @Autowired
    public SupplierControllerSpring(SupplierService supplierService) { this.supplierService = supplierService;}

    @GetMapping
    public ResponseEntity<Iterable<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplier(supplier));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> getSupplier(@PathVariable Long id) {
        Optional<Supplier> supplier = supplierService.getSupplier(id);

        if (supplier.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> updateSupplier(@PathVariable Long id,
                                                             @RequestBody Supplier supplier) {
        if (!supplier.getSupplier_id().equals(id))
            return ResponseEntity.notFound().build();
        Optional<Supplier> updated = Optional.ofNullable(supplierService.updateSupplier(supplier));
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.deleteSupplier(id));
    }
}
