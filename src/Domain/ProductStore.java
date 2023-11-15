package Domain;

public class ProductStore {
    private int productId;
    private int storeId;

    public ProductStore(int id, int storeID) {
    }

    public int getproductStoreIdId() {return productId;}

    public int getProductStoreStoreId() {return storeId;}

    public void setProductStoreProductId(int productId) {
        this.productId = productId;
    }

    public void setProductStoreStoreId(int storeId) {this.storeId = storeId; }
    // mai trebe adaugat un atribut
    // getteri si setteri

    @Override
    public String toString() {
        return "Product Store" +
                "product id=" + productId +
                "store id=" + storeId +
                "}";
    }
}
