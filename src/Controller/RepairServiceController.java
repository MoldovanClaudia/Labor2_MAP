package Controller;

import Domain.Customer;
import Domain.Job;
import Domain.RepairService;
import InMemoryRepository.RepairServiceRepository;

import java.util.ArrayList;
import java.util.Map;

public class RepairServiceController {
    private final RepairServiceRepository repairServiceRepository;

    public RepairServiceController(RepairServiceRepository repairServiceRepository) {
        this.repairServiceRepository = repairServiceRepository;
    }

    public void addRepairService(int repairId, int productId, int customerId, int employeeId) {
        RepairService newRepairService = new RepairService(repairId,productId,customerId,employeeId);
        repairServiceRepository.addItem(newRepairService);
    }

    public void deleteRepairService(int repairServiceId) {
        RepairService repairService = repairServiceRepository.findById(repairServiceId);
        repairServiceRepository.deleteItem(repairService);

    }

    public void updateRepairAndService(int repairAndServiceId,  Map<String, String> repairAndService_updates) {
        RepairService oldRepairAndService = repairServiceRepository.findById(repairAndServiceId);

        if (oldRepairAndService != null) {
            RepairService newRepairAndService = new RepairService(
                    oldRepairAndService.getRepairId(),
                    oldRepairAndService.getProductId(),
                    oldRepairAndService.getCustomerId(),
                    oldRepairAndService.getEmployeeId()
            );


            repairServiceRepository.updateItem(oldRepairAndService, newRepairAndService);
            System.out.println("Repair and service updated successfully.");
        } else {
            System.out.println("Repair and service not found.");
        }
    }

    public ArrayList<RepairService> getAllRepairServices() {
        return repairServiceRepository.getAllItems();
    }
}
