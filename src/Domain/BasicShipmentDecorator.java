package Domain;

public class BasicShipmentDecorator implements ShipmentDecorator {
    private Shipment shipment;
    private String freeShipment;

    public String getFreeShipment() {
        return this.freeShipment;
    }

    public void setFreeShipment(String freeShipment) {
        this.freeShipment = freeShipment;
    }

    public BasicShipmentDecorator(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public String getAdditionalInfo() {
        return "Your order will be shipped in 7-10n working days. Thank you for your patience.";
    }

    @Override
    public String toString() {
        return shipment.toString() + " - " + getAdditionalInfo();
    }
}
