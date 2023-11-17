package InMemoryRepository;
import Domain.Customer;
import Domain.Shipment;
import Domain.ShipmentDecorator;

import java.util.ArrayList;

public class ShipmentRepository implements InMemoryRepository<ShipmentDecorator> {
    private final ArrayList<ShipmentDecorator> shipments = new ArrayList<ShipmentDecorator>();

    @Override
    public void addItem(ShipmentDecorator newShipment) {
        shipments.add(newShipment);
    }

    @Override
    public void deleteItem(ShipmentDecorator shipmentToBeDeleted) {
        shipments.remove(shipmentToBeDeleted);
    }

    @Override
    public void updateItem(ShipmentDecorator oldShipment, ShipmentDecorator newShipment) {
        int index = shipments.indexOf(oldShipment);
        if (index != -1) {
            shipments.set(index,newShipment);
        }
    }

    @Override
    public ArrayList<ShipmentDecorator> getAllItems() {
        return shipments;
    }

    @Override
    public ShipmentDecorator findById(int shipmentId) {
        for(ShipmentDecorator shipment : shipments) {
            if (shipment.getShipmentId() == shipmentId) {
                return shipment;
            }
        }
        return null;
    }
}
