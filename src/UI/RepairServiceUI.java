package UI;

import Controller.RepairServiceController;
import Domain.RepairService;

import java.util.Scanner;
import java.util.ArrayList;

public class RepairServiceUI {
    public void RepairServiceCase(RepairServiceController repairServiceController) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add Repair Service");
        System.out.println("2. Delete Repair Service");
        System.out.println("3. Update Repair Service");
        System.out.println("4. Get All Repair Services");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter repair service ID: ");
                int repairId = scanner.nextInt();
                System.out.print("Enter product ID: ");
                int productId = scanner.nextInt();
                System.out.print("Enter customer ID: ");
                int customerId = scanner.nextInt();
                System.out.print("Enter employee ID: ");
                int employeeId = scanner.nextInt();

                repairServiceController.addRepairService(repairId, productId, customerId, employeeId);

                System.out.println("Repair Service added successfully.");
                break;
            case 2:
                System.out.print("Enter repair service ID to delete: ");
                int repairId2 = scanner.nextInt();

                RepairService repairService = new RepairService(repairId2, 0, 0, 0);
                repairServiceController.deleteRepairService(repairId2);

                System.out.println("Repair Service deleted successfully.");
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<RepairService> repairServices = repairServiceController.getAllRepairServices();

                if (repairServices.isEmpty()) {
                    System.out.println("No Repair Services found.");
                } else {
                    System.out.println("List of Repair Services:");
                    for (RepairService repairServiceIn : repairServices) {
                        System.out.println(repairServiceIn);
                    }
                }
                break;
        }
    }
}
