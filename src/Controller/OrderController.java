package Controller;
import Domain.Customer;
import Domain.Job;
import Domain.Order;
import Domain.ProductOrder;
import InMemoryRepository.OrderRepository;
import InMemoryRepository.ProductOrderRepository;

import java.util.ArrayList;
import java.util.Map;

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

    public void updateOrder(int orderId, Map<String, String> order_updates) {
        Order oldOrder = orderRepository.findById(orderId);

        if (oldOrder != null) {
            Order newOrder = new Order(
                    oldOrder.getOrderId(),
                    oldOrder.getCustomerId(),
                    order_updates.containsKey("orderDate") ? order_updates.get("oderDate") : oldOrder.getOrderDate()
            );


            orderRepository.updateItem(oldOrder, newOrder);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAllItems();
    }
}
