package ControllerDB;

import Domain.*;
import Controller.*;
import RepositoryDB.OnlineStoreRepositoryDB;
import RepositoryDB.StoreRepositoryDB;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class StoreControllerDB {
    private StoreRepositoryDB storeRepository;
    private OnlineStoreRepositoryDB onlineStoreRepository;
    private StoreFactory storeFactory;

    public StoreControllerDB(StoreRepositoryDB storeRepository, OnlineStoreRepositoryDB onlineStoreRepository, StoreFactory storeFactory) {
    }

    public void StoreController(StoreRepositoryDB storeRepository, OnlineStoreRepositoryDB onlineStoreRepository, StoreFactory storeFactory ) {
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
                Store newNormalStore = StoreFactory.createStore(storeId, name, address);
                storeRepository.add(newNormalStore);
                break;
            case "online":
                OnlineStore newOnlineStore= StoreFactory.createOnlineStore(storeId, name, address);
                onlineStoreRepository.add(newOnlineStore);
                break;

        }
    }

    public void deleteStore(ArrayList<String> storeId) {

        String productType = askForStoreType();

        switch (productType.toLowerCase()) {
            case "normal":
                Store store = storeRepository.findById(storeId);
                storeRepository.delete(store);
                break;
            case "online":
                OnlineStore onlineStore = onlineStoreRepository.findById(storeId);
                onlineStoreRepository.delete(onlineStore);
                break;

        }

    }

    public void updateStore(ArrayList<String> storeId, Map<String, String> store_updates) {
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
                    storeRepository.update(oldStore, newStore);
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
                    onlineStoreRepository.update(oldOnlineStore, newOnlineStore);
                    System.out.println("Store updated successfully.");
                } else {
                    System.out.println("Store not found.");
                }
                break;

        }

    }

    public ArrayList<Store> getAllStores() {
        return storeRepository.readAll();
    }
}
