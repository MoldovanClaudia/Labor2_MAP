package Domain;

public class ConcreteShipmentBuilder implements ShipmentBuilder {
    private int shipmentId;
    private int orderId;
    private String company;
    private String place;

    @Override
    public ShipmentBuilder setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
        return this;
    }

    @Override
    public ShipmentBuilder setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override
    public ShipmentBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public ShipmentBuilder setPlace(String place) {
        this.place = place;
        return this;
    }

    @Override
    public Shipment build() {
        return new Shipment(shipmentId, orderId, company, place);
    }
}
