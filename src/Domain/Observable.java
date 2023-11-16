package Domain;

public interface Observable {
    void notifyObservers(String propertyName, Object value);

    void addObserver(Observer observer);
    void removeObserver(Observer observer);

}
