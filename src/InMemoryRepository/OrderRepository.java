package InMemoryRepository;
import Domain.Employee;
import Domain.Order;
import java.util.ArrayList;

public class OrderRepository implements InMemoryRepository<Order> {
    private final ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    public void addItem(Order newOrder) {
        orders.add(newOrder);
    }

    @Override
    public void deleteItem(Order orderToBeDeleted) {
        orders.remove(orderToBeDeleted);
    }

    @Override
    public void updateItem(Order oldOrder, Order newOrder) {
        int index = orders.indexOf(oldOrder);
        if (index != -1) {
            orders.set(index,newOrder);
        }
    }

    @Override
    public ArrayList<Order> getAllItems() {
        return orders;
    }

    @Override
    public Order findById(int orderId) {
        for(Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

}
