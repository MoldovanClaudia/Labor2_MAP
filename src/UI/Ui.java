package UI;

import java.util.Scanner;
import Controller.*;
import Domain.Customer;
import InMemoryRepository.*;




public class Ui {
    static CustomerRepository customerRepository = new CustomerRepository();
    static CustomerController customerController = new CustomerController(customerRepository);

    static EmployeeRepository employeeRepository = new EmployeeRepository();
    static EmployeeController employeeController= new EmployeeController(employeeRepository);

    static JobRepository jobRepository = new JobRepository();
    static JobController jobController = new JobController(jobRepository);

    static RepairServiceRepository repairServiceRepository = new RepairServiceRepository();
    static RepairServiceController repairServiceController = new RepairServiceController(repairServiceRepository);

    static ReviewAndRatingRepository reviewAndRatingRepository = new ReviewAndRatingRepository();
    static ReviewAndRatingController reviewAndRatingController = new ReviewAndRatingController(reviewAndRatingRepository);

    static SupplierRepository supplierRepository = new SupplierRepository();
    static SupplierController supplierController = new SupplierController(supplierRepository);

    static StoreRepository storeRepository = new StoreRepository();
    static StoreController storeController = new StoreController(storeRepository);

    static ShipmentRepository shipmentRepository = new ShipmentRepository();
    static ShipmentController shipmentController = new ShipmentController(shipmentRepository);

    static OrderRepository orderRepository = new OrderRepository();
    static ProductOrderRepository productOrderRepository = new ProductOrderRepository();
    static OrderController orderController = new OrderController(orderRepository, productOrderRepository);

    static ProductRepository productRepository = new ProductRepository();
    static ProductStoreRepository productStoreRepository = new ProductStoreRepository();
    static ProductController productController = new ProductController(productRepository, productStoreRepository);
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Labor2_MAP");
            System.out.println("1. Customers");
            System.out.println("2. Employees");
            System.out.println("3. Jobs");
            System.out.println("4. Orders");
            System.out.println("5. Products");
            System.out.println("6. Repair Service");
            System.out.println("7. Reviews and Ratings");
            System.out.println("8. Shipments");
            System.out.println("9. Stores");
            System.out.println("10. Suppliers");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected 'Customers.'");
                    CustomerUI customerUI = new CustomerUI();
                    customerUI.CustomerCase(customerController);
                    break;
                case 2:
                    System.out.println("You selected 'Employees.'");
                    EmployeeUI employeeUI = new EmployeeUI();
                    employeeUI.EmployeeCase(employeeController);
                    break;
                case 3:
                    System.out.println("You selected 'Jobs.'");
                    JobUI jobUI = new JobUI();
                    jobUI.JobCase(jobController);
                    break;
                case 4:
                    System.out.println("You selected 'Orders.'");
                    OrderUI orderUI = new OrderUI();
                    orderUI.OrderCase(orderController);
                    break;
                case 5:
                    System.out.println("You selected 'Products.'");
                    ProductUI productUI = new ProductUI();
                    productUI.ProductCase(productController);
                    break;
                case 6:
                    System.out.println("You selected 'Repair Service.'");
                    RepairServiceUI repairServiceUI = new RepairServiceUI();
                    repairServiceUI.RepairServiceCase(repairServiceController);
                    break;
                case 7:
                    System.out.println("You selected 'Reviews and Ratings.'");
                    ReviewsAndRatingUI reviewsAndRatingUI = new ReviewsAndRatingUI();
                    reviewsAndRatingUI.ReviewAndRatingCase(reviewAndRatingController);
                    break;
                case 8:
                    System.out.println("You selected 'Shipments.'");
                    ShipmentUI shipmentUI = new ShipmentUI();
                    shipmentUI.ShipmentCase(shipmentController);
                    break;
                case 9:
                    System.out.println("You selected 'Stores.'");
                    StoreUI storeUI = new StoreUI();
                    storeUI.StoreCase(storeController);
                    break;
                case 10:
                    System.out.println("You selected 'Suppliers.'");
                    SupplierUI supplierUI = new SupplierUI();
                    supplierUI.SupplierCase(supplierController);
                    break;
                case 11:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

}
