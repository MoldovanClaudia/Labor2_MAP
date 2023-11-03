package InMemoryRepository;
import Domain.Customer;
import Domain.Shipment;
import java.util.ArrayList;

public class ShipmentRepository implements InMemoryRepository<Shipment> {
    private final ArrayList<Shipment> shipments = new ArrayList<Shipment>();

    @Override
    public void addItem(Shipment newShipment) {
        shipments.add(newShipment);
    }

    @Override
    public void deleteItem(Shipment shipmentToBeDeleted) {
        shipments.remove(shipmentToBeDeleted);
    }

    @Override
    public void updateItem(Shipment oldShipment, Shipment newShipment) {
        int index = shipments.indexOf(oldShipment);
        if (index != -1) {
            shipments.set(index,newShipment);
        }
    }

    @Override
    public ArrayList<Shipment> getAllItems() {
        return shipments;
    }

    @Override
    public Shipment findById(int shipmentId) {
        for(Shipment shipment : shipments) {
            if (shipment.getShipmentId() == shipmentId) {
                return shipment;
            }
        }
        return null;
    }
}
