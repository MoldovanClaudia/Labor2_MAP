package UI;

import Controller.StoreController;
import Domain.Store;


import java.util.Scanner;
import java.util.ArrayList;

public class StoreUI {
    public void StoreCase(StoreController storeController) {
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
                System.out.print("Enter address: ");
                String address = scanner.next();

                storeController.addStore(storeId, name, address);

                System.out.println("Store added successfully.");
                break;
            case 2:
                System.out.print("Enter store ID to delete: ");
                int storeId2 = scanner.nextInt();

                // Confirmation to delete
                System.out.print("Are you sure you want to delete this store? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    Store store = new Store(storeId2, "", "");
                    storeController.deleteStore(store);
                    System.out.println("Store deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                // Implement functionality for updating
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
