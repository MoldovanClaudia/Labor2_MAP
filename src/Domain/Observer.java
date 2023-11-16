package Domain;

public interface Observer {
    void update(Observable observable, String propertyName, Object value);
}
