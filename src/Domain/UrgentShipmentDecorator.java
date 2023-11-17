package Domain;

public class UrgentShipmentDecorator implements ShipmentDecorator {
    private Shipment shipment;

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
