//package com.example.demo.ControllerSpring;
//
//import com.example.demo.Domain.Order;
//import com.example.demo.Services.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderControllerSpring {
//
//    private final OrderService orderService;
//
//    @Autowired
//    public OrderControllerSpring(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<Order>> getAllOrders() {
//        return ResponseEntity.ok(orderService.getAllOrders());
//    }
//
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Order>> getOrder(@PathVariable Long id) {
//        Optional<Order> order = orderService.getOrder(id);
//
//        if (order.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(order);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Optional<Order>> updateOrder(@PathVariable Long id,
//                                                       @RequestBody Order order) {
//        if (!order.getOrder_id().equals(id))
//            return ResponseEntity.notFound().build();
//        Optional<Order> updated = Optional.ofNullable(orderService.updateOrder(order));
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
//        return ResponseEntity.ok(orderService.deleteOrder(id));
//    }
//}
//
