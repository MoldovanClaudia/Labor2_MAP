package UI;

import Controller.SupplierController;
import Domain.Supplier;

import java.util.Scanner;
import java.util.ArrayList;

public class SupplierUI {
    public void SupplierCase(SupplierController supplierController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Supplier");
        System.out.println("2. Delete Supplier");
        System.out.println("3. Update Supplier");
        System.out.println("4. Get All Suppliers");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter supplier ID: ");
                int id = scanner.nextInt();
                System.out.print("Enter supplier name: ");
                String name = scanner.next();
                System.out.print("Enter contact: ");
                String contact = scanner.next();

                supplierController.addSupplier(id, name, contact);

                System.out.println("Supplier added successfully.");
                break;
            case 2:
                System.out.print("Enter supplier ID to delete: ");
                int supplierId2 = scanner.nextInt();

                // Confirmation to delete
                System.out.print("Are you sure you want to delete this supplier? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    //Supplier supplier = new Supplier(supplierId2, "", "");
                    supplierController.deleteSupplier(supplierId2);
                    System.out.println("Supplier deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<Supplier> suppliers = supplierController.getAllSuppliers();

                if (suppliers.isEmpty()) {
                    System.out.println("No suppliers found.");
                } else {
                    System.out.println("List of Suppliers:");
                    for (Supplier supplierIn : suppliers) {
                        System.out.println(supplierIn);
                    }
                }
                break;
        }
    }
}
