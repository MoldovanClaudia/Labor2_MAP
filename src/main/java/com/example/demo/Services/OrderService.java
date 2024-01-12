//package com.example.demo.Services;
//
//import com.example.demo.Domain.Order;
//import com.example.demo.RepositorySpring.OrderRepositorySpring;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class OrderService {
//
//    private final OrderRepositorySpring orderRepo;
//
//    @Autowired
//    public OrderService(OrderRepositorySpring orderRepo) {
//        this.orderRepo = orderRepo;
//    }
//
//    public Order createOrder(Order order) {
//        return orderRepo.save(order);
//    }
//
//    public Iterable<Order> getAllOrders() {
//        return orderRepo.findAll();
//    }
//
//    public Optional<Order> getOrder(Long orderId) {
//        return orderRepo.findById(orderId);
//    }
//
//    public Order updateOrder(Order order) {
//        return orderRepo.findById(order.getOrder_id())
//                .map(existingOrder -> {
//                    existingOrder.setCustomer(order.getCustomer());
//                    existingOrder.setOrder_date(order.getOrder_date());
//
//                    return orderRepo.save(existingOrder);
//                }).orElse(null);
//    }
//
//    public String deleteOrder(Long id) {
//        return orderRepo.findById(id)
//                .map(order -> {
//                    orderRepo.deleteById(id);
//                    return "Order deleted successfully!";
//                }).orElse("Order not found!");
//    }
//}
