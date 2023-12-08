package UiDB;

import ControllerDB.StoreControllerDB;
import Domain.Store;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class StoreUiDB {
    private static StoreUiDB instance;

    private StoreUiDB() {
    }

    public static synchronized StoreUiDB getInstance() {
        if (instance == null) {
            instance = new StoreUiDB();
        }
        return instance;
    }
    public void StoreCase(StoreControllerDB storeController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Store");
        System.out.println("2. Delete Store");
        System.out.println("3. Update Store");
        System.out.println("4. Get All Stores");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter store ID: ");
                int storeId = scanner.nextInt();
                System.out.print("Enter store name: ");
                String name = scanner.next();
                System.out.print("Enter address or Site (if Online): ");
                String address = scanner.next();

                storeController.addStore(storeId, name, address);

                System.out.println("Store added successfully.");
                break;
            case 2:
                System.out.print("Enter store ID to delete: ");
                int storeId2 = scanner.nextInt();

                ArrayList<String> storeIdsToDelete = new ArrayList<>();
                storeIdsToDelete.add(String.valueOf(storeId2));

                System.out.print("Are you sure you want to delete this store? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    storeController.deleteStore(storeIdsToDelete);
                    System.out.println("Store deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                System.out.print("Enter store ID to update: ");
                int storeIdToUpdate = scanner.nextInt();

                ArrayList<String> storeIdsToUpdate = new ArrayList<>();
                storeIdsToUpdate.add(String.valueOf(storeIdToUpdate));

                Map<String, String> store_updates = new HashMap<>();

                System.out.print("Enter new store name (press Enter to skip): ");
                String newStoreName = scanner.nextLine().trim();
                if (!newStoreName.isEmpty()) {
                    store_updates.put("storeName", newStoreName);
                }

                System.out.print("Enter new store address (press Enter to skip): ");
                String newStoreAddress = scanner.nextLine().trim();
                if (!newStoreAddress.isEmpty()) {
                    store_updates.put("storeAddress", newStoreAddress);
                }

                storeController.updateStore(storeIdsToUpdate, store_updates);
                break;
            case 4:
                ArrayList<Store> stores = storeController.getAllStores();

                if (stores.isEmpty()) {
                    System.out.println("No stores found.");
                } else {
                    System.out.println("List of Stores:");
                    for (Store storeIn : stores) {
                        System.out.println(storeIn);
                    }
                }
                break;
        }
    }
}
