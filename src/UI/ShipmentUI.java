package UI;

import Controller.ShipmentController;
import Domain.Shipment;


import java.util.Scanner;
import java.util.ArrayList;

public class ShipmentUI {
    public void ShipmentCase(ShipmentController shipmentController) {
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

                // Confirmation to delete
                System.out.print("Are you sure you want to delete this shipment? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    Shipment shipment = new Shipment(shipmentId2, 0, "", "");
                    shipmentController.deleteShipment(shipment);
                    System.out.println("Shipment deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                // Implement functionality for updating
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
