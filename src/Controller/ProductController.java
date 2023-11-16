package Controller;

import Domain.Customer;
import Domain.Product;
import Domain.ProductOrder;
import Domain.ProductStore;
import InMemoryRepository.ProductOrderRepository;
import InMemoryRepository.ProductRepository;
import InMemoryRepository.ProductStoreRepository;
import InMemoryRepository.CustomerRepository;

import java.util.ArrayList;
import java.util.Map;

public class ProductController {
    private final ProductRepository productRepository;
    private final ProductStoreRepository productStoreRepository;
    private final CustomerRepository customerRepository;

    public ProductController(ProductRepository productRepository, ProductStoreRepository productStoreRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.productStoreRepository= productStoreRepository;
        this.customerRepository = customerRepository;
    }

    public void addProduct(int id, String name, String description, String category, float price, int supplierId, int quantity, int storeID) {
        Product newProduct = new Product(id, name, description, category, price, supplierId, quantity);
        productRepository.addItem(newProduct);
        ProductStore newProductStore = new ProductStore(id, storeID);
        productStoreRepository.addItem(newProductStore);

        // adding the new custoer also as a new observer
        for (Customer customer : customerRepository.getAllItems()) {
            newProduct.addObserver(customer);
        }
    }

    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId);
        productRepository.deleteItem(product);

    }

    public void updateProduct(int productId, Map<String, String> product_updates) {
        Product oldProduct = productRepository.findById(productId);

        if (oldProduct != null) {
            Product newProduct = new Product(
                    oldProduct.getProductId(),
                    product_updates.containsKey("productName") ? product_updates.get("productName") : oldProduct.getName(),
                    product_updates.containsKey("productDescription") ? product_updates.get("productDescription") : oldProduct.getDescription(),
                    product_updates.containsKey("category") ? product_updates.get("category") : oldProduct.getCategory(),
                    oldProduct.getPrice(),
                    oldProduct.getSupplierId(),
                    oldProduct.getQuantity()
            );


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
