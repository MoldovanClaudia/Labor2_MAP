package Controller;
import Domain.Order;
import InMemoryRepository.OrderRepository;
import java.util.ArrayList;

public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(int orderID, int customerID, String orderDate) {
        Order newOrder = new Order(orderID, customerID, orderDate);
        orderRepository.addItem(newOrder);
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteItem(order);
    }

    public void updateOrder(Order oldOrder, Order newOrder) {
        orderRepository.updateItem(oldOrder, newOrder);
    }

    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAllItems();
    }
}
