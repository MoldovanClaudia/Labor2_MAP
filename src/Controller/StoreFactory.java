package Controller;
import Domain.Store;
import Domain.OnlineStore;
import InMemoryRepository.StoreRepository;

public class StoreFactory {
    public static Store createStore(int storeId, String name, String address){
        return new Store(storeId, name, address);
    }
    public static OnlineStore createOnlineStore(int storeId, String name, String site){
        return new OnlineStore(storeId, name, site);
    }
}
