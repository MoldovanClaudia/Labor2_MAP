package Domain;

public class ProductOrder {

    private int productId;
    private int orderId;

    private int quantity;

    public ProductOrder( int productID, int orderID) {
        this.productId = productID;
        this.orderId = orderID;
    }

    public int getproductOrderId() {return  productId;}

    @Override
    public String toString() {
        return "Product Store" +
                "product id=" + productId +
                "order id=" + orderId +
                "}";
    }
}
