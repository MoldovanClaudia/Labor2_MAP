package InMemoryRepository;
import Domain.Customer;
import Domain.ProductStore;
import java.util.ArrayList;

public class ProductStoreRepository implements InMemoryRepository<ProductStore> {
    private final ArrayList<ProductStore> productStores = new ArrayList<ProductStore>();

    @Override
    public void addItem(ProductStore newProductStore) {
        productStores.add(newProductStore);
    }

    @Override
    public void deleteItem(ProductStore productStoreToBeDeleted) {
        productStores.remove(productStoreToBeDeleted);
    }

    @Override
    public void updateItem(ProductStore oldProductStore, ProductStore newProductStore) {
        int index = productStores.indexOf(oldProductStore);
        if (index != -1) {
            productStores.set(index,newProductStore);
        }
    }

    @Override
    public ArrayList<ProductStore> getAllItems() {
        return productStores;
    }

    @Override
    public ProductStore findById(int productStoreId) {
        for(ProductStore customer : productStores) {
            if (customer.getproductStoreIdId() == productStoreId) {
                return customer;
            }
        }
        return null;
    }

}
