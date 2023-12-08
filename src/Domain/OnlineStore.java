package Domain;

public class OnlineStore implements StoreInterface{
    int storeId;
    String storeName;
    String storeSite;

    public OnlineStore(int storeId, String storeName, String storeSite) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeSite = storeSite;
    }

    public int getStoreId() { return this.storeId; }
    public void setStoreId(int storeId) { this.storeId = storeId; }
    public String getName() { return this.storeName; }
    public void setName(String name) { this.storeName = name; }
    public String getAddress() { return this.storeSite; }
    public void setAddress(String storeSite) { this.storeSite = storeSite; }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", store name=" + storeName +
                ", store address=" + storeSite +
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
        OnlineStore onlineStore = (OnlineStore) obj;
        return storeId == onlineStore.storeId;
    }


    public String getSite() { return this.storeSite;
    }
}
