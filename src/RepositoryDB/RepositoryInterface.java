package RepositoryDB;

import java.util.ArrayList;

public interface RepositoryInterface<T> {
    void add(T newItem);
    void delete(T itemToBeDeleted);
    void update(T oldItem, T newItem);
    ArrayList<T> readAll();
    T findById(ArrayList<String> id);

}
