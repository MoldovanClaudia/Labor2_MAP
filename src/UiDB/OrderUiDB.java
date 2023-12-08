package UiDB;

import ControllerDB.OrderControllerDB;
import Domain.Order;
import Domain.ProductOrder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderUiDB {
    private static OrderUiDB instance;

    private OrderUiDB() {
    }

    public static synchronized OrderUiDB getInstance() {
        if (instance == null) {
            instance = new OrderUiDB();
        }
        return instance;
    }
    public void OrderCase(OrderControllerDB orderController) {
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

                ArrayList<String> orderIdsToDelete = new ArrayList<>();
                orderIdsToDelete.add(String.valueOf(orderID2));


                System.out.print("Are you sure you want to delete this order and associated product orders? (Y/N): ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("Y")) {
                    orderController.deleteOrder(orderIdsToDelete);
                    System.out.println("Order and associated product orders deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                break;
            case 3:
                System.out.print("Enter order ID to update: ");
                String orderIdToUpdate = scanner.next();

                ArrayList<String> orderIdList = new ArrayList<>();
                orderIdList.add(orderIdToUpdate);

                Map<String, String> order_updates = new HashMap<>();

                System.out.print("Enter new order date (press Enter to skip): ");
                String newOrderDate = scanner.nextLine().trim();
                if (!newOrderDate.isEmpty()) {
                    order_updates.put("order date", newOrderDate);
                }

                orderController.updateOrder(orderIdList, order_updates);
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
