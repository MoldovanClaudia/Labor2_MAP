package Controller;

import Domain.Customer;
import Domain.Product;
import Domain.ProductLaptop;
import Domain.ProductPhone;
import Domain.ProductStore;
import InMemoryRepository.ProductRepository;
import InMemoryRepository.ProductStoreRepository;
import InMemoryRepository.CustomerRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ProductController {
    private final ProductRepository productRepository;
    private final ProductStoreRepository productStoreRepository;
    private final CustomerRepository customerRepository;

    public ProductController(ProductRepository productRepository, ProductStoreRepository productStoreRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.productStoreRepository = productStoreRepository;
        this.customerRepository = customerRepository;
    }

    public void addProduct(int id, String name, String description, String category, float price, int supplierId, int quantity, int storeID) {
        // Ask the client for the type of product
        String productType = askForProductType();

        Product newProduct;

        switch (productType.toLowerCase()) {
            case "laptop":
                newProduct = new ProductLaptop(id, name, description, category, price, supplierId, quantity, "Mechanical", "Trackpad", "Windows");
                break;
            case "phone":
                newProduct = new ProductPhone(id, name, description, category, price, supplierId, quantity, "Touchscreen", "High Resolution", "Android");
                break;
            default:
                newProduct = new Product(id, name, description, category, price, supplierId, quantity);
                break;
        }

        // Add the new product
        productRepository.addItem(newProduct);

        // Add the new product store
        ProductStore newProductStore = new ProductStore(id, storeID);
        productStoreRepository.addItem(newProductStore);

        // Add the new customer also as a new observer
        for (Customer customer : customerRepository.getAllItems()) {
            newProduct.addObserver(customer);
        }
    }

    private String askForProductType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of product (e.g., Laptop, Phone, etc.): ");
        return scanner.nextLine().trim();
    }

    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId);
        productRepository.deleteItem(product);
    }

    public void updateProduct(int productId, Map<String, String> product_updates) {
        Product oldProduct = productRepository.findById(productId);

        if (oldProduct != null) {
            // Update the product based on its type
            Product newProduct;
            if (oldProduct instanceof ProductLaptop) {
                newProduct = new ProductLaptop(
                        oldProduct.getProductId(),
                        product_updates.containsKey("productName") ? product_updates.get("productName") : oldProduct.getName(),
                        product_updates.containsKey("productDescription") ? product_updates.get("productDescription") : oldProduct.getDescription(),
                        product_updates.containsKey("category") ? product_updates.get("category") : oldProduct.getCategory(),
                        oldProduct.getPrice(),
                        oldProduct.getSupplierId(),
                        oldProduct.getQuantity(),
                        "Mechanical",
                        "Trackpad",
                        "Windows"
                );
            } else if (oldProduct instanceof ProductPhone) {
                newProduct = new ProductPhone(
                        oldProduct.getProductId(),
                        product_updates.containsKey("productName") ? product_updates.get("productName") : oldProduct.getName(),
                        product_updates.containsKey("productDescription") ? product_updates.get("productDescription") : oldProduct.getDescription(),
                        product_updates.containsKey("category") ? product_updates.get("category") : oldProduct.getCategory(),
                        oldProduct.getPrice(),
                        oldProduct.getSupplierId(),
                        oldProduct.getQuantity(),
                        "Touchscreen",
                        "High Resolution",
                        "Android"
                );
            } else {
                newProduct = new Product(
                        oldProduct.getProductId(),
                        product_updates.containsKey("productName") ? product_updates.get("productName") : oldProduct.getName(),
                        product_updates.containsKey("productDescription") ? product_updates.get("productDescription") : oldProduct.getDescription(),
                        product_updates.containsKey("category") ? product_updates.get("category") : oldProduct.getCategory(),
                        oldProduct.getPrice(),
                        oldProduct.getSupplierId(),
                        oldProduct.getQuantity()
                );
            }

            // Update the repository with the new product
            productRepository.updateItem(oldProduct, newProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public ArrayList<Product> getAllProducts() {
        return productRepository.getAllItems();
    }
}
