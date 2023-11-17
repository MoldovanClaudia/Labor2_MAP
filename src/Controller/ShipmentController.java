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

    public void addShipment(int shipmentId, int orderId, String company,String place) {
        Shipment newShipment = new Shipment(shipmentId, orderId, company, place);
        shipmentRepository.addItem(newShipment);
    }

//    public void addBasicShipment(int shipmentId, int orderId, String company, String place) {
//        Shipment basicShipment = new Shipment(shipmentId, orderId, company, place);
//        BasicShipmentDecorator basicDecorator = new BasicShipmentDecorator(basicShipment);
//        shipmentRepository.addItem(basicDecorator);
//    }
//
//    public void addUrgentShipment(int shipmentId, int orderId, String company, String place) {
//        Shipment urgentShipment = new Shipment(shipmentId, orderId, company, place);
//        UrgentShipmentDecorator urgentDecorator = new UrgentShipmentDecorator(urgentShipment);
//        shipmentRepository.addItem(urgentDecorator);
//    }
//
//    public void addSameDayShipment(int shipmentId, int orderId, String company, String place) {
//        Shipment sameDayShipment = new Shipment(shipmentId, orderId, company, place);
//        SameDayShipmentDecorator sameDayDecorator = new SameDayShipmentDecorator(sameDayShipment);
//        shipmentRepository.addItem(sameDayDecorator);
//    }

    public void deleteShipment(int shipmentId) {
        Shipment shipment = (Shipment) shipmentRepository.findById(shipmentId);
        shipmentRepository.deleteItem(shipment);

    }

    public void updateShipment(int shipmentId, Map<String, String> shipment_updates) {
        Shipment oldShipment = (Shipment) shipmentRepository.findById(shipmentId);

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

//    public void updateShipment(int shipmentId, Map<String, String> shipment_updates) {
//        Shipment oldShipment = (Shipment) shipmentRepository.findById(shipmentId);
//
//        if(oldShipment != null) {
//            Shipment updatedShipment = applyUpdates(oldShipment, shipment_updates);
//            System.out.println("Shipment updated succesfully.");
//        } else {
//            System.out.println("Shipment was not found.");
//        }
//    }

//    private Shipment applyUpdates(Shipment shipment, Map<String, String> updates) {
//        Shipment updateShipment = new Shipment(
//                shipment.getShipmentId(),
//                shipment.getOrderId(),
//                updates.containsKey("companyName") ? updates.get("companyName") : shipment.getCompany(),
//                updates.containsKey("place") ? updates.get("place") : shipment.getPlace()
//        );
//
//        if(shipment instanceof ShipmentDecorator) {
//
//            if(shipment instanceof BasicShipmentDecorator) {
//                BasicShipmentDecorator basicDecorator = (BasicShipmentDecorator) shipment;
//                String updatedFreeShipment = updates.containsKey("freeShipment") ? updates.get("freeShipment") : basicDecorator.getFreeShipment();
//                updatedShipment = new BasicShipmentDecorator(updateShipment, updatedFreeShipment);
//            }
//
//            if(shipment instanceof UrgentShipmentDecorator) {
//                UrgentShipmentDecorator urgentDecorator = (UrgentShipmentDecorator) shipment;
//                int updatedPriorityLevel = updates.containsKey("priorityLevel") ? Integer.parseInt(updates.get("priorityLevel")) : urgentDecorator.getPriorityLevel();
//                updatedShipment = new UrgentShipmentDecorator(updateShipment, updatedPriorityLevel);
//            }
//
//            if(shipment instanceof SameDayShipmentDecorator) {
//                SameDayShipmentDecorator sameDayDecorator = (SameDayShipmentDecorator) shipment;
//                int updatedExtraCost = updates.containsKey("extraCost") ? Integer.parseInt(updates.get("extraCost")) : sameDayDecorator.getExtraCost();
//                updatedShipment = new SameDayShipmentDecorator(updateShipment, updatedExtraCost);
//            }
//        }
//
//        return updateShipment;
//    }

    public ArrayList<Shipment> getAllShipments() {
        return shipmentRepository.getAllItems();
    }
}
