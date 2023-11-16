package Domain;

public class SameDayShippment implements ShipmentDecorator {
    private Shipment shipment;

    public SameDayShippment(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public String getAdditionalInfo() {
        return "Your order will be shipped today, the courier will be right with you!";
    }

    @Override
    public String toString() {
        return shipment.toString() + " - " + getAdditionalInfo();
    }
}
