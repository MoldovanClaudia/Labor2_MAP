package Domain;

public class Order {
    private int orderId;
    private int customerId;
    private String orderDate;

    public Order(int orderId, int customerId, String orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + orderId +
                "customer id=" + customerId +
                ", order date=" + orderDate +
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
        Order order = (Order) obj;
        return orderId == order.orderId;
    }
}
