package Controller;

import Domain.Store;
import Domain.Supplier;
import InMemoryRepository.StoreRepository;

import java.util.ArrayList;

public class StoreController {
    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void addStore(int storeId, String name, String address) {
        Store newStore = new Store(storeId, name, address);
        storeRepository.addItem(newStore);
    }

    public void deleteStore(int storeId) {
        Store store = storeRepository.findById(storeId);
        storeRepository.deleteItem(store);

    }

    public void updateStore(Store oldStore, Store newStore) {
        storeRepository.updateItem(oldStore, newStore);
    }

    public ArrayList<Store> getAllStores() {
        return storeRepository.getAllItems();
    }
}
