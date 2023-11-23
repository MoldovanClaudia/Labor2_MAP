package Controller;

import Domain.*;
import InMemoryRepository.OnlineStoreRepository;
import InMemoryRepository.StoreRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class StoreController {
    private StoreRepository storeRepository;
    private OnlineStoreRepository onlineStoreRepository;
    private StoreFactory storeFactory;

    public StoreController(StoreRepository storeRepository, OnlineStoreRepository onlineStoreRepository, StoreFactory storeFactory ) {
        this.storeRepository = storeRepository;
        this.onlineStoreRepository = onlineStoreRepository;
        this.storeFactory = storeFactory;
    }

    private String askForStoreType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of Store (normal or online): ");
        return scanner.nextLine().trim();
    }

    public void addStore(int storeId, String name, String address) {
        // Ask the client for the type of product
        String productType = askForStoreType();

        switch (productType.toLowerCase()) {
            case "normal":
                Store newNormalStore;
                newNormalStore = new Store(storeId, name, address);
                StoreRepository.addItem(newNormalStore);
                break;
            case "online":
                OnlineStore newOnlineStore;
                newOnlineStore = new OnlineStore(storeId, name, address);
                OnlineStoreRepository.addItem(newOnlineStore);
                break;

        }
    }

    public void deleteStore(int storeId) {

        String productType = askForStoreType();

        switch (productType.toLowerCase()) {
            case "normal":
                Store store = storeRepository.findById(storeId);
                storeRepository.deleteItem(store);
                break;
            case "online":
                OnlineStore onlineStore = onlineStoreRepository.findById(storeId);
                onlineStoreRepository.deleteItem(onlineStore);
                break;

        }

    }

    public void updateStore(int storeId, Map<String, String> store_updates) {
        String productType = askForStoreType();
        switch (productType.toLowerCase()) {
            case "normal":
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
            case "online":
                OnlineStore oldOnlineStore = onlineStoreRepository.findById(storeId);

                if (oldOnlineStore != null) {
                    OnlineStore newOnlineStore = new OnlineStore(
                            oldOnlineStore.getStoreId(),
                            store_updates.containsKey("storeName") ? store_updates.get("storeName") : oldOnlineStore.getName(),
                            store_updates.containsKey("storeAddress") ? store_updates.get("storeAddress") : oldOnlineStore.getAddress()

                    );
                    OnlineStoreRepository.updateItem(oldOnlineStore, newOnlineStore);
                    System.out.println("Store updated successfully.");
                } else {
                    System.out.println("Store not found.");
                }
                break;

        }

    }

    public ArrayList<Store> getAllStores() {
        return storeRepository.getAllItems();
    }
}
