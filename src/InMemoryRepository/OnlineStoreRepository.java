package InMemoryRepository;
import Domain.Shipment;
import Domain.OnlineStore;
import java.util.ArrayList;

public class OnlineStoreRepository implements InMemoryRepository<OnlineStore> {
    private final ArrayList<OnlineStore> stores = new ArrayList<OnlineStore>();

    @Override
    public void addItem(OnlineStore newStore) {
        stores.add(newStore);
    }

    @Override
    public void deleteItem(OnlineStore storeToBeDeleted) {
        stores.remove(storeToBeDeleted);
    }

    @Override
    public  void updateItem(OnlineStore oldStore, OnlineStore newStore) {
        int index = stores.indexOf(oldStore);
        if (index != -1) {
            stores.set(index,newStore);
        }
    }

    @Override
    public ArrayList<OnlineStore> getAllItems() {
        return stores;
    }

    @Override
    public OnlineStore findById(int storeId) {
        for(OnlineStore store : stores) {
            if (store.getStoreId() == storeId) {
                return store;
            }
        }
        return null;
    }
}
