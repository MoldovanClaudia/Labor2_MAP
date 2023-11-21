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
//        Product product = new Product(123,"phone", "Apple", "smart phones", 1000, 456, 6);
//
//        Customer customer = new Customer(500, "Claudia", "Moldovan", "moldovanc09@yahoo.com", "str 13 Septembrie");
//
//        product.addObserver(customer);
//
//        product.setPrice(2000);
//        product.setQuantity(3);


    }


}
