package ControllerDB;

import Domain.*;
import RepositoryDB.ShipmentRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class ShipmentControllerDB {
    private ShipmentRepositoryDB shipmentRepository;

    public ShipmentControllerDB(ShipmentRepositoryDB shipmentRepository) {
    }

    public void ShipmentController(ShipmentRepositoryDB shipmentRepository) {
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
        shipmentRepository.add(newShipment);
    }

    public void deleteShipment(ArrayList<String> shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId);
        shipmentRepository.delete(shipment);

    }

    public void updateShipment(ArrayList<String> shipmentId, Map<String, String> shipment_updates) {
        Shipment oldShipment = shipmentRepository.findById(shipmentId);

        if (oldShipment != null) {
            Shipment newShipment = new Shipment(
                    oldShipment.getShipmentId(),
                    oldShipment.getOrderId(),
                    shipment_updates.containsKey("companyName") ? shipment_updates.get("companyName") : oldShipment.getCompany(),
                    shipment_updates.containsKey("place") ? shipment_updates.get("place") : oldShipment.getPlace()
            );


            shipmentRepository.update(oldShipment, newShipment);
            System.out.println("Shipment updated successfully.");
        } else {
            System.out.println("Shipment not found.");
        }
    }


    public ArrayList<Shipment> getAllShipments() {
        return shipmentRepository.readAll();
    }
}
