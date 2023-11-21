package Controller;

import Domain.*;
import InMemoryRepository.ShipmentRepository;

import java.util.ArrayList;
import java.util.Map;

public class ShipmentController {
    private final ShipmentRepository shipmentRepository;

    public ShipmentController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(int shipmentId, int orderId, String company, String place) {
        return Shipment.builder()
                .setShipmentId(shipmentId)
                .setOrderId(orderId)
                .setCompany(company)
                .setPlace(place)
                .build();
    }

    // !!!!! am schimbat
    public void addShipment(int shipmentId, int orderId, String company,String place) {
        Shipment newShipment = createShipment(shipmentId, orderId, company, place);
        shipmentRepository.addItem(newShipment);
    }

    public void deleteShipment(int shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId);
        shipmentRepository.deleteItem(shipment);

    }

    public void updateShipment(int shipmentId, Map<String, String> shipment_updates) {
        Shipment oldShipment = shipmentRepository.findById(shipmentId);

        if (oldShipment != null) {
            Shipment newShipment = new Shipment(
                    oldShipment.getShipmentId(),
                    oldShipment.getOrderId(),
                    shipment_updates.containsKey("companyName") ? shipment_updates.get("companyName") : oldShipment.getCompany(),
                    shipment_updates.containsKey("place") ? shipment_updates.get("place") : oldShipment.getPlace()
            );


            shipmentRepository.updateItem(oldShipment, newShipment);
            System.out.println("Shipment updated successfully.");
        } else {
            System.out.println("Shipment not found.");
        }
    }


    public ArrayList<Shipment> getAllShipments() {
        return shipmentRepository.getAllItems();
    }
}
