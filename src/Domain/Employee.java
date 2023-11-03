package Domain;

public class Employee {
    private int employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeContact;
    private int jobId;
    private int storeId;

    public int getEmployeeId() { return this.employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public String getEmployeeFirstName() { return this.employeeFirstName; }
    public void setEmployeeFirstName(String firstName) { this.employeeFirstName = employeeFirstName; }
    public String getEmployeeLastName() { return this.employeeLastName; }
    public void setEmployeeLastName(String employeeLastName) { this.employeeLastName = employeeLastName; }
    public String getEmployeeContact() { return this.employeeContact; }
    public void setEmployeeContact(String employeeContact) { this.employeeContact = employeeContact; }
    public int getJobId() { return this.jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    public int getStoreId() { return this.storeId; }
    public void setStoreId(int storeId) { this.storeId = storeId; }


    public Employee(int employeeId, String employeeFirstName, String employeeLastName, String employeeContact) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeContact = employeeContact;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employeeId +
                ", first name=" + employeeFirstName +
                ", last name=" + employeeLastName +
                ", contact=" + employeeContact +
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
        Employee employee = (Employee) obj;
        return employeeId == employee.employeeId;
    }
}
