package InMemoryRepository;
import java.util.List;

public interface InMemoryRepository<T> {
    void addItem(T newItem);
    void updateItem(T oldItem, T newItem);
    void deleteItem(T itemToBeDeleted);
    List<T> getAllItems();

    T findById(int id);

}
