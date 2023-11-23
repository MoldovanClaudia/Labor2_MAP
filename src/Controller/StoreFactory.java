package Controller;
import Domain.Store;
import Domain.OnlineStore;
import InMemoryRepository.StoreRepository;

public class StoreFactory {
    public Store createStore(int storeId, String name, String address){
        return new Store(storeId, name, address);
    }
    public Store createOnlineStore(int storeId, String name, String site){
        return new Store(storeId, name, site);
    }
}
