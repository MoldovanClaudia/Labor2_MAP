package UiDB;

import ControllerDB.ShipmentControllerDB;
import Domain.Shipment;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class ShipmentUiDB {
    private static ShipmentUiDB instance;

    private ShipmentUiDB() {
    }

    public static synchronized ShipmentUiDB getInstance() {
        if (instance == null) {
            instance = new ShipmentUiDB();
        }
        return instance;
    }
    public void ShipmentCase(ShipmentControllerDB shipmentController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Shipment");
        System.out.println("2. Delete Shipment");
        System.out.println("3. Update Shipment");
        System.out.println("4. Get All Shipments");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter shipment ID: ");
                int shipmentId = scanner.nextInt();
                System.out.print("Enter order ID: ");
                int orderId = scanner.nextInt();
                System.out.print("Enter company: ");
                String company = scanner.next();
                System.out.print("Enter place: ");
                String place = scanner.next();

                shipmentController.addShipment(shipmentId, orderId, company, place);

                System.out.println("Shipment added successfully.");
                break;
            case 2:
                System.out.print("Enter shipment ID to delete: ");
                int shipmentId2 = scanner.nextInt();

                ArrayList<String> shipmentIdsToDelete = new ArrayList<>();
                shipmentIdsToDelete.add(String.valueOf(shipmentId2));

                System.out.print("Are you sure you want to delete this shipment? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    shipmentController.deleteShipment(shipmentIdsToDelete);
                    System.out.println("Shipment deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                System.out.print("Enter shipment ID to update: ");
                int shipmentIdToUpdate = scanner.nextInt();

                ArrayList<String> shipmentIdsToUpdate = new ArrayList<>();
                shipmentIdsToUpdate.add(String.valueOf(shipmentIdToUpdate));

                Map<String, String> shipment_updates = new HashMap<>();

                System.out.print("Enter new order ID (press Enter to skip): ");
                String newOrderID = scanner.nextLine().trim();
                if (!newOrderID.isEmpty()) {
                    shipment_updates.put("orderID", newOrderID);
                }

                System.out.print("Enter new company (press Enter to skip): ");
                String newCompany = scanner.nextLine().trim();
                if (!newCompany.isEmpty()) {
                    shipment_updates.put("company", newCompany);
                }

                System.out.print("Enter new place (press Enter to skip): ");
                String newPlace = scanner.nextLine().trim();
                if (!newPlace.isEmpty()) {
                    shipment_updates.put("place", newPlace);
                }

                shipmentController.updateShipment(shipmentIdsToUpdate, shipment_updates);
                break;
            case 4:
                ArrayList<Shipment> shipments = shipmentController.getAllShipments();

                if (shipments.isEmpty()) {
                    System.out.println("No shipments found.");
                } else {
                    System.out.println("List of Shipments:");
                    for (Shipment shipmentIn : shipments) {
                        System.out.println(shipmentIn);
                    }
                }
                break;
        }
    }
}
