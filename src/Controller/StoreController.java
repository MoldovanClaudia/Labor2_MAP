package Controller;

import Domain.Customer;
import Domain.Store;
import Domain.Supplier;
import InMemoryRepository.StoreRepository;

import java.util.ArrayList;
import java.util.Map;

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

    public void updateStore(int storeId, Map<String, String> store_updates) {
        Store oldStore = storeRepository.findById(storeId);

        if (oldStore != null) {
            Store newStore = new Store(
                    oldStore.getStoreId(),
                    store_updates.containsKey("storeName") ? store_updates.get("storeName") : oldStore.getName(),
                    store_updates.containsKey("storeAddress") ? store_updates.get("storeAddress") : oldStore.getAddress()

            );


            storeRepository.updateItem(oldStore, newStore);
            System.out.println("Store updated successfully.");
        } else {
            System.out.println("Store not found.");
        }
    }

    public ArrayList<Store> getAllStores() {
        return storeRepository.getAllItems();
    }
}
