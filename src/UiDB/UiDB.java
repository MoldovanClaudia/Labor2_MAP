package UiDB;

import java.util.Scanner;
import ControllerDB.*;
import RepositoryDB.*;
import Controller.*;




public class UiDB {
    private static UiDB instance;

    public synchronized static UiDB getInstance() {
        if (instance == null) {
            instance = new UiDB();
        }
        return instance;
    }
    static CustomerRepositoryDB customerRepository = new CustomerRepositoryDB();
    static CustomerControllerDB customerController = new CustomerControllerDB(customerRepository);

    static EmployeeRepositoryDB employeeRepository = new EmployeeRepositoryDB();
    static EmployeeControllerDB employeeController= new EmployeeControllerDB(employeeRepository);

    static JobRepositoryDB jobRepository = new JobRepositoryDB();
    static JobControllerDB jobController = new JobControllerDB(jobRepository);

    static RepairRepositoryDB repairServiceRepository = new RepairRepositoryDB();
    static RepairServiceControllerDB repairServiceController = new RepairServiceControllerDB(repairServiceRepository);

    static ReviewAndRatingRepositoryDB reviewAndRatingRepository = new ReviewAndRatingRepositoryDB();
    static ReviewAndRatingControllerDB reviewAndRatingController = new ReviewAndRatingControllerDB(reviewAndRatingRepository);

    static SupplierRepositoryDB supplierRepository = new SupplierRepositoryDB();
    static SupplierControllerDB supplierController = new SupplierControllerDB(supplierRepository);

    static StoreRepositoryDB storeRepository = new StoreRepositoryDB();
    static OnlineStoreRepositoryDB onlineStoreRepository = new OnlineStoreRepositoryDB();

    static StoreFactory storeFactory = new StoreFactory();
    // !!
    static StoreControllerDB storeController = new StoreControllerDB(storeRepository, onlineStoreRepository, storeFactory);

    static ShipmentRepositoryDB shipmentRepository = new ShipmentRepositoryDB();
    // !!
    static ShipmentControllerDB shipmentController = new ShipmentControllerDB(shipmentRepository);

    static OrderRepositoryDB orderRepository = new OrderRepositoryDB();
    static ProductOrderRepositoryDB productOrderRepository = new ProductOrderRepositoryDB();
    static OrderControllerDB orderController = new OrderControllerDB(orderRepository, productOrderRepository);

    static ProductRepositoryDB productRepository = new ProductRepositoryDB();
    static ProductStoreRepositoryDB productStoreRepository = new ProductStoreRepositoryDB();
    // !!
    static ProductControllerDB productController = new ProductControllerDB(productRepository, productStoreRepository, customerRepository);
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
                    CustomerUiDB customerUI = CustomerUiDB.getInstance();
                    customerUI.CustomerCase(customerController);
                    break;
                case 2:
                    System.out.println("You selected 'Employees.'");
                    EmployeeUiDB employeeUI = EmployeeUiDB.getInstance();
                    employeeUI.EmployeeCase(employeeController);
                    break;
                case 3:
                    System.out.println("You selected 'Jobs.'");
                    JobUiDB jobUI = JobUiDB.getInstance();
                    jobUI.JobCase(jobController);
                    break;
                case 4:
                    System.out.println("You selected 'Orders.'");
                    OrderUiDB orderUI = OrderUiDB.getInstance();
                    orderUI.OrderCase(orderController);
                    break;
                case 5:
                    System.out.println("You selected 'Products.'");
                    ProductUiDB productUI = ProductUiDB.getInstance();
                    productUI.ProductCase(productController);
                    break;
                case 6:
                    System.out.println("You selected 'Repair Service.'");
                    RepairServiceUiDB repairServiceUI = RepairServiceUiDB.getInstance();
                    repairServiceUI.RepairServiceCase(repairServiceController);
                    break;
                case 7:
                    System.out.println("You selected 'Reviews and Ratings.'");
                    ReviewsAndRatingUiDB reviewsAndRatingUI = ReviewsAndRatingUiDB.getInstance();
                    reviewsAndRatingUI.ReviewAndRatingCase(reviewAndRatingController);
                    break;
                case 8:
                    System.out.println("You selected 'Shipments.'");
                    ShipmentUiDB shipmentUI = ShipmentUiDB.getInstance();
                    shipmentUI.ShipmentCase(shipmentController);
                    break;
                case 9:
                    System.out.println("You selected 'Stores.'");
                    StoreUiDB storeUI = StoreUiDB.getInstance();
                    storeUI.StoreCase(storeController);
                    break;
                case 10:
                    System.out.println("You selected 'Suppliers.'");
                    SupplierUiDB supplierUI = SupplierUiDB.getInstance();
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
