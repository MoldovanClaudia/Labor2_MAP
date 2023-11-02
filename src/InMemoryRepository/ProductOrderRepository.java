package InMemoryRepository;
import Domain.ProductOrder;
import java.util.ArrayList;

public class ProductOrderRepository implements InMemoryRepository<ProductOrder> {
    private final ArrayList<ProductOrder> productOrders = new ArrayList<ProductOrder>();

    @Override
    public void addItem(ProductOrder newProductOrder) {
        productOrders.add(newProductOrder);
    }

    @Override
    public void deleteItem(ProductOrder productOrderToBeDeleted) {
        productOrders.remove(productOrderToBeDeleted);
    }

    @Override
    public void updateItem(ProductOrder oldProductOrder, ProductOrder newProductOrder) {
        int index = productOrders.indexOf(oldProductOrder);
        if (index != -1) {
            productOrders.set(index,newProductOrder);
        }
    }

    @Override
    public ArrayList<ProductOrder> getAllItems() {
        return productOrders;
    }
}
