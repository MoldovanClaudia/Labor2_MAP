package InMemoryRepository;
import Domain.Shipment;
import Domain.Store;
import java.util.ArrayList;

public class StoreRepository implements InMemoryRepository<Store> {
    private final ArrayList<Store> stores = new ArrayList<Store>();

    @Override
    public void addItem(Store newStore) {
        stores.add(newStore);
    }

    @Override
    public void deleteItem(Store storeToBeDeleted) {
        stores.remove(storeToBeDeleted);
    }

    @Override
    public void updateItem(Store oldStore, Store newStore) {
        int index = stores.indexOf(oldStore);
        if (index != -1) {
            stores.set(index,newStore);
        }
    }

    @Override
    public ArrayList<Store> getAllItems() {
        return stores;
    }

    @Override
    public Store findById(int storeId) {
        for(Store store : stores) {
            if (store.getStoreId() == storeId) {
                return store;
            }
        }
        return null;
    }
}
