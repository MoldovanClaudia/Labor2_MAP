package InMemoryRepository;
import Domain.RepairService;
import java.util.ArrayList;

public class RepairServiceRepository implements InMemoryRepository<RepairService> {
    private final ArrayList<RepairService> repairServices = new ArrayList<RepairService>();

    @Override
    public void addItem(RepairService newRepairService) {
        repairServices.add(newRepairService);
    }

    @Override
    public void deleteItem(RepairService repairServiceToBeDeleted) {
        repairServices.remove(repairServiceToBeDeleted);
    }

    @Override
    public void updateItem(RepairService oldRepairService, RepairService newRepairService) {
        int index = repairServices.indexOf(oldRepairService);
        if (index != -1) {
            repairServices.set(index,newRepairService);
        }
    }

    @Override
    public ArrayList<RepairService> getAllItems() {
        return repairServices;
    }
}
