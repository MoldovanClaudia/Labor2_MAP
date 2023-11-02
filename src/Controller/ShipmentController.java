package Controller;

import Domain.Shipment;
import InMemoryRepository.ShipmentRepository;

import java.util.ArrayList;

public class ShipmentController {
    private final ShipmentRepository shipmentRepository;

    public ShipmentController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void addShipment(int shipmentId, int orderId, String company,String place) {
        Shipment newShipment = new Shipment(shipmentId, orderId, company, place);
        shipmentRepository.addItem(newShipment);
    }

    public void deleteShipment(Shipment shipment) {
        shipmentRepository.deleteItem(shipment);
    }

    public void updateShipment(Shipment oldShipment, Shipment newShipment) {
        shipmentRepository.updateItem(oldShipment, newShipment);
    }

    public ArrayList<Shipment> getAllShipments() {
        return shipmentRepository.getAllItems();
    }
}
