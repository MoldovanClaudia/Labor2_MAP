package Domain;

public class RepairService {
    private int repairId;
    private int productId;
    private int customerId;
    private int employeeId;

    public RepairService(int repairId, int productId, int customerId, int employeeId) {
        this.repairId = repairId;
        this.productId = productId;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public int getRepairId() {
        return repairId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Repair Service{" +
                "repair id=" + repairId +
                "product id=" + productId +
                "customer id=" + customerId +
                "employee id=" + employeeId +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RepairService repairService = (RepairService) obj;
        return repairId == repairService.repairId;
    }

}
