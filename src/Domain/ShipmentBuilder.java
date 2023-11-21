package Domain;

public interface ShipmentBuilder {
    ShipmentBuilder setShipmentId(int shipmentId);
    ShipmentBuilder setOrderId(int orderId);
    ShipmentBuilder setCompany(String company);
    ShipmentBuilder setPlace(String place);
    Shipment build();

}
