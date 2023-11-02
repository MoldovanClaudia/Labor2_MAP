package Controller;

import Domain.Product;
import InMemoryRepository.ProductRepository;

import java.util.ArrayList;

public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id, String name, String description, String category, float price, int supplierId, int quantity) {
        Product newProduct = new Product(id, name, description, category, price, supplierId, quantity);
        productRepository.addItem(newProduct);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteItem(product);
    }

    public void updateProduct(Product oldProduct, Product newProduct) {
        productRepository.updateItem(oldProduct, newProduct);
    }

    public ArrayList<Product> getAllProducts() {
        return productRepository.getAllItems();
    }
}
