package Controller;
import Domain.Job;
import Domain.Order;
import Domain.ProductOrder;
import InMemoryRepository.OrderRepository;
import InMemoryRepository.ProductOrderRepository;

import java.util.ArrayList;

public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;

    public OrderController(OrderRepository orderRepository, ProductOrderRepository productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public void addOrder(int orderID, int customerID, String orderDate, int productID) {
        Order newOrder = new Order(orderID, customerID, orderDate);
        orderRepository.addItem(newOrder);
        ProductOrder newProductOrder = new ProductOrder(productID, orderID);
        productOrderRepository.addItem(newProductOrder);
    }


    public void deleteOrder(int orderId) {
        Order order = orderRepository.findById(orderId);
        orderRepository.deleteItem(order);

    }

    public void updateOrder(Order oldOrder, Order newOrder, ProductOrder oldProductOrder, ProductOrder newProductOrder) {
        orderRepository.updateItem(oldOrder, newOrder);
        productOrderRepository.updateItem(oldProductOrder,newProductOrder);
    }
    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAllItems();
    }
}
