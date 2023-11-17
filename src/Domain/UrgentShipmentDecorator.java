package Domain;

public class UrgentShipmentDecorator implements ShipmentDecorator {
    private Shipment shipment;
    private int priorityLevel;
    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public UrgentShipmentDecorator(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public String getAdditionalInfo() {
        return "Your order will be shipped in 1-2 working days. Thank you for your patience.";
    }

    @Override
    public String toString() {
        return shipment.toString() + " - " + getAdditionalInfo();
    }
}
