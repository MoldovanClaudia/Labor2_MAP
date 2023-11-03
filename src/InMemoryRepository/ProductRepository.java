package InMemoryRepository;
import Domain.Employee;
import Domain.Product;
import java.util.ArrayList;

public class ProductRepository implements InMemoryRepository<Product> {
    private final ArrayList<Product> products = new ArrayList<Product>();

    @Override
    public void addItem(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public void deleteItem(Product productToBeDeleted) {
        products.remove(productToBeDeleted);
    }

    @Override
    public void updateItem(Product oldProduct, Product newProduct) {
        int index = products.indexOf(oldProduct);
        if (index != -1) {
            products.set(index,newProduct);
        }
    }

    @Override
    public ArrayList<Product> getAllItems() {
        return products;
    }

    @Override
    public Product findById(int productId) {
        for(Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

}
