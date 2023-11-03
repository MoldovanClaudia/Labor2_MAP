package Controller;

import Domain.Job;
import Domain.RepairService;
import InMemoryRepository.RepairServiceRepository;

import java.util.ArrayList;

public class RepairServiceController {
    private final RepairServiceRepository repairServiceRepository;

    public RepairServiceController(RepairServiceRepository repairServiceRepository) {
        this.repairServiceRepository = repairServiceRepository;
    }

    public void addRepairService(int repairId, int productId, int customerId, int employeeId) {
        RepairService newRepairService = new RepairService(repairId,productId,customerId,employeeId);
        repairServiceRepository.addItem(newRepairService);
    }

    //public void deleteRepairService(RepairService repairService) {
    //    repairServiceRepository.deleteItem(repairService);
    //}

    public void deleteRepairService(int repairServiceId) {
        RepairService repairService = repairServiceRepository.findById(repairServiceId);
        repairServiceRepository.deleteItem(repairService);

    }
    public void updateRepairService(RepairService oldRepairService, RepairService newRepairService) {
        repairServiceRepository.updateItem(oldRepairService, newRepairService);
    }

    public ArrayList<RepairService> getAllRepairServices() {
        return repairServiceRepository.getAllItems();
    }
}
