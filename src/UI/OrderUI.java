package UI;

import Controller.OrderController;
import Domain.Order;
import Domain.ProductOrder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderUI {
    private static OrderUI instance;

    private OrderUI() {
    }

    public static synchronized OrderUI getInstance() {
        if (instance == null) {
            instance = new OrderUI();
        }
        return instance;
    }
    public void OrderCase(OrderController orderController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Order");
        System.out.println("2. Delete Order");
        System.out.println("3. Update Order");
        System.out.println("4. Get All Orders");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter order ID: ");
                int orderID = scanner.nextInt();
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                System.out.print("Enter order date: ");
                String orderDate = scanner.next();
                System.out.print("Enter product ID: ");
                int productID = scanner.nextInt();

                orderController.addOrder(orderID, customerID, orderDate, productID);

                System.out.println("Order added successfully.");
                break;
            case 2:
                System.out.print("Enter order ID to delete: ");
                int orderID2 = scanner.nextInt();

                // Confirmation to delete
                System.out.print("Are you sure you want to delete this order and associated product orders? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    Order order = new Order(orderID2, 0, "");
                    ProductOrder productOrder = new ProductOrder(0, orderID2);
                    orderController.deleteOrder(orderID2);
                    System.out.println("Order and associated product orders deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                System.out.print("Enter order ID to update: ");
                int orderIdToUpdate = scanner.nextInt();

                Map<String, String> order_updates = new HashMap<>();

                System.out.print("Enter new order date (press Enter to skip): ");
                String newOrderDate = scanner.nextLine().trim();
                if (!newOrderDate.isEmpty()) {
                    order_updates.put("order date", newOrderDate);
                }

                orderController.updateOrder(orderIdToUpdate, order_updates);
                break;
            case 4:
                ArrayList<Order> orders = orderController.getAllOrders();

                if (orders.isEmpty()) {
                    System.out.println("No orders found.");
                } else {
                    System.out.println("List of Orders:");
                    for (Order orderIn : orders) {
                        System.out.println(orderIn);
                    }
                }
                break;
        }
    }
}
