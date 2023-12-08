package ControllerDB;
import Domain.Order;
import Domain.ProductOrder;
import RepositoryDB.OrderRepositoryDB;
import RepositryDB.ProductOrderRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class OrderControllerDB {
    private OrderRepositoryDB orderRepository;
    private ProductOrderRepositoryDB productOrderRepository;

    private void OrderController(OrderRepositoryDB orderRepository, ProductOrderRepositoryDB productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public OrderControllerDB(OrderRepositoryDB orderRepository, ProductOrderRepositoryDB productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public static OrderControllerDB createOrderControllerDB(OrderRepositoryDB orderRepository, ProductOrderRepositoryDB productOrderRepository) {
        return new OrderControllerDB(orderRepository, productOrderRepository);
    }

    public void addOrder(int orderID, int customerID, String orderDate, int productID) {
        Order newOrder = new Order(orderID, customerID, orderDate);
        orderRepository.add(newOrder);
        ProductOrder newProductOrder = new ProductOrder(productID, orderID);
        productOrderRepository.add(newProductOrder);
    }


    public void deleteOrder(ArrayList<String> orderId) {
        Order order = orderRepository.findById(orderId);
        orderRepository.delete(order);

    }

    public void updateOrder(Order oldOrder, Order newOrder, ProductOrder oldProductOrder, ProductOrder newProductOrder) {
        orderRepository.update(oldOrder, newOrder);
        productOrderRepository.update(oldProductOrder,newProductOrder);
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