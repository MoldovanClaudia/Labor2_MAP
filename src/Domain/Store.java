package Domain;

public class Store {
    private int storeId;
    private String storeName;
    private String storeAddress;

    public Store(int storeId, String name, String address) {
        this.storeId = storeId;
        this.storeName = name;
        this.storeAddress = address;
    }

    public int getStoreId() { return this.storeId; }
    public void setStoreId(int storeId) { this.storeId = storeId; }
    public String getName() { return this.storeName; }
    public void setName(String name) { this.storeName = name; }
    public String getAddress() { return this.storeAddress; }
    public void setAddress(String address) { this.storeAddress = address; }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", store name=" + storeName +
                ", store address=" + storeAddress +
                "}";
    }


}
