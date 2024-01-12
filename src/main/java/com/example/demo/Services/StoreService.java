package com.example.demo.Services;

import com.example.demo.Domain.Store;
import com.example.demo.RepositorySpring.StoreRepositorySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepositorySpring storeRepo;

    @Autowired
    public StoreService(StoreRepositorySpring storeRepo) {
        this.storeRepo = storeRepo;
    }

    public Store createStore(Store store) {
        return storeRepo.save(store);
    }

    public Iterable<Store> getAllStores() {
        return storeRepo.findAll();
    }

    public Optional<Store> getStore(Long storeId) {
        return storeRepo.findById(storeId);
    }

    public Store updateStore(Store updatedStore) {
        return storeRepo.findById(updatedStore.getStore_id())
                .map(existingStore -> {
                    existingStore.setStore_name(updatedStore.getStore_name());
                    existingStore.setStore_address(updatedStore.getStore_address());
                    return storeRepo.save(existingStore);
                })
                .orElse(null);
    }


    public String deleteStore(Long id) {
        return storeRepo.findById(id)
                .map(store -> {
                    storeRepo.deleteById(id);
                    return "Store deleted successfully!";
                }).orElse("Store not found!");
    }

}
