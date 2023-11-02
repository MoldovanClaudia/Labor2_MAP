package Controller;

import Domain.Product;
import Domain.ProductOrder;
import Domain.ProductStore;
import InMemoryRepository.ProductOrderRepository;
import InMemoryRepository.ProductRepository;
import InMemoryRepository.ProductStoreRepository;

import java.util.ArrayList;

public class ProductController {
    private final ProductRepository productRepository;
    private final ProductStoreRepository productStoreRepository;

    public ProductController(ProductRepository productRepository, ProductStoreRepository productStoreRepository) {
        this.productRepository = productRepository;
        this.productStoreRepository= productStoreRepository;
    }

    public void addProduct(int id, String name, String description, String category, float price, int supplierId, int quantity, int storeID) {
        Product newProduct = new Product(id, name, description, category, price, supplierId, quantity);
        productRepository.addItem(newProduct);
        ProductStore newProductStore = new ProductStore(id, storeID);
        productStoreRepository.addItem(newProductStore);
    }

    public void deleteProduct(Product product, ProductStore productStore) {
        productRepository.deleteItem(product);
        productStoreRepository.deleteItem(productStore);
    }

    public void updateProduct(Product oldProduct, Product newProduct, ProductStore oldProductStore, ProductStore newProductStore) {
        productRepository.updateItem(oldProduct, newProduct);
        productStoreRepository.updateItem(oldProductStore, newProductStore);
    }

    public ArrayList<Product> getAllProducts() {
        return productRepository.getAllItems();
    }
}
