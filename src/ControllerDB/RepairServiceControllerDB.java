package ControllerDB;

import Domain.RepairService;
import RepositoryDB.RepairRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class RepairServiceController {
    private final RepairRepositoryDB repairServiceRepository;

    public RepairServiceController(RepairRepositoryDB repairServiceRepository) {
        this.repairServiceRepository = repairServiceRepository;
    }

    public void addRepairService(int repairId, int productId, int customerId, int employeeId) {
        RepairService newRepairService = new RepairService(repairId,productId,customerId,employeeId);
        repairServiceRepository.add(newRepairService);
    }

    public void deleteRepairService(ArrayList<String> repairServiceId) {
        RepairService repairService = repairServiceRepository.findById(repairServiceId);
        repairServiceRepository.delete(repairService);

    }

    public void updateRepairAndService(ArrayList<String> repairAndServiceId, Map<String, String> repairAndService_updates) {
        RepairService oldRepairAndService = repairServiceRepository.findById(repairAndServiceId);

        if (oldRepairAndService != null) {
            RepairService newRepairAndService = new RepairService(
                    oldRepairAndService.getRepairId(),
                    oldRepairAndService.getProductId(),
                    oldRepairAndService.getCustomerId(),
                    oldRepairAndService.getEmployeeId()
            );


            repairServiceRepository.update(oldRepairAndService, newRepairAndService);
            System.out.println("Repair and service updated successfully.");
        } else {
            System.out.println("Repair and service not found.");
        }
    }

    public ArrayList<RepairService> getAllRepairServices() {
        return repairServiceRepository.readAll();
    }
}
