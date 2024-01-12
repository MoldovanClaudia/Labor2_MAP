package com.example.demo.ControllerSpring;

import com.example.demo.Domain.Job;
import com.example.demo.Domain.Store;
import com.example.demo.Services.JobService;
import com.example.demo.Services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/stores")
public class StoreControllerSpring {

    private final StoreService storeService;

    @Autowired
    public StoreControllerSpring(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createStore(store));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Store>> getStore(@PathVariable Long id) {
        Optional<Store> store = storeService.getStore(id);

        if (store.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Store>> updateStore(@PathVariable Long id,
                                                   @RequestBody Store store) {
        if (!store.getStore_id().equals(id))
            return ResponseEntity.notFound().build();
        Optional<Store> updated = Optional.ofNullable(storeService.updateStore(store));
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.deleteStore(id));
    }
}
