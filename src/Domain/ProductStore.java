package Domain;

public class ProductStore {
    private int productId;
    private int storeId;

    public ProductStore(int id, int storeID) {
    }
    // mai trebe adaugat un atribut
    // getteri si setteri
    // metoda de toString

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductStore productStore = (ProductStore) obj;
        return productId == productStore.productId;
    }
}
