import Controller.ProductController;
import Domain.Customer;
import Domain.Product;
import Domain.Shipment;
import InMemoryRepository.CustomerRepository;
import InMemoryRepository.ProductRepository;
import InMemoryRepository.ProductStoreRepository;
import UI.Ui;


public class Main {
    public static void main(String[] args) {
        Ui ui = Ui.getInstance(); // Retrieve the singleton instance (optional)
        ui.main(); // Call the main method of the Ui class
    }


}
