package Domain;

public class ProductOrder {

    private int productOrderId;
    private int productId;
    private int orderId;

    public ProductOrder(int productID, int orderID) {
    }
    // mai trebuie completat

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductOrder productOrder = (ProductOrder) obj;
        return productOrderId == productOrder.productOrderId;
    }
}
