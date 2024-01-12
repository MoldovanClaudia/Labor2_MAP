package com.example.demo.RepositorySpring;

import com.example.demo.Domain.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepositorySpring extends CrudRepository<Store, Long> {
}
