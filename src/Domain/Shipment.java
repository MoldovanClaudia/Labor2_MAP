package Domain;

public class Shipment  {
    private int shipmentId;
    private int orderId;
    private String company;
    private String place;

    public Shipment(int shipmentId, int orderId, String company, String place) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.company = company;
        this.place = place;
    }

    public static ShipmentBuilder builder() {
        return new ConcreteShipmentBuilder();
    }

    public int getShipmentId() {
        return this.shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipment id=" + shipmentId +
                "order id=" + orderId +
                "company=" + company +
                ", place=" + place +
                "}";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Shipment shipment = (Shipment) obj;
        return shipmentId == shipment.shipmentId;
    }

}
