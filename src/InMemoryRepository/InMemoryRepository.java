package InMemoryRepository;
import java.util.List;
import Domain.*;

public interface InMemoryRepository<T> {
    void addItem(T newItem);
    void updateItem(T oldItem, T newItem);
    void deleteItem(T itemToBeDeleted);
    List<T> getAllItems();

}
