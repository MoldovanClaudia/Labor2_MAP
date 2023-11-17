//package Tests;
//
//import Domain.Customer;
//import Domain.Product;
//import Domain.Observer;
//import Domain.Observable;
//
//public class ObserverPatternTest {
//    Product product = new Product(123,"phone", "Apple", "smart phones", 1000, 456, 6);
//
//    Customer customer1 = new Customer(500, "Claudia", "Moldovan", "moldovanc09@yahoo.com", "str 13 Septembrie");
//    Customer customer2 = new Customer(501,"Davide", "Pantea", "davide.pantea@yahoo.com", "str random");
//
//
//    product.addObserver(customer1);
//    product.addObserver(customer2);
//
//
//    product.setPrice(15.0f); // This should notify both customers about the price change
//    product.setQuantity(3);
//}
