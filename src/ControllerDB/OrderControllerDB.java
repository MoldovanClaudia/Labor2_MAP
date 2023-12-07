package ControllerDB;
import Domain.Order;
import Domain.ProductOrder;
import RepositoryDB.OrderRepositoryDB;
import InMemoryRepository.ProductOrderRepository;

import java.util.ArrayList;
import java.util.Map;

public class OrderControllerDB {
    private OrderRepositoryDB orderRepository;
    private ProductOrderRepository productOrderRepository;

    private void OrderController(OrderRepositoryDB orderRepository, ProductOrderRepository productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public OrderControllerDB(OrderRepositoryDB orderRepository, ProductOrderRepository productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public static OrderControllerDB createOrderControllerDB(OrderRepositoryDB orderRepository, ProductOrderRepository productOrderRepository) {
        return new OrderControllerDB(orderRepository, productOrderRepository);
    }

    public void addOrder(int orderID, int customerID, String orderDate, int productID) {
        Order newOrder = new Order(orderID, customerID, orderDate);
        orderRepository.add(newOrder);
        ProductOrder newProductOrder = new ProductOrder(productID, orderID);
        productOrderRepository.addItem(newProductOrder);
    }


    public void deleteOrder(ArrayList<String> orderId) {
        Order order = orderRepository.findById(orderId);
        orderRepository.delete(order);

    }

    public void updateOrder(Order oldOrder, Order newOrder, ProductOrder oldProductOrder, ProductOrder newProductOrder) {
        orderRepository.update(oldOrder, newOrder);
        productOrderRepository.updateItem(oldProductOrder,newProductOrder);
    }

    public void updateOrder(ArrayList<String> orderId, Map<String, String> order_updates) {
        Order oldOrder = orderRepository.findById(orderId);

        if (oldOrder != null) {
            Order newOrder = new Order(
                    oldOrder.getOrderId(),
                    oldOrder.getCustomerId(),
                    order_updates.containsKey("orderDate") ? order_updates.get("oderDate") : oldOrder.getOrderDate()
            );


            orderRepository.update(oldOrder, newOrder);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    public ArrayList<Order> getAllOrders() {
        return orderRepository.readAll();
    }
}
