package Domain;

public class Employee {
    private int employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeContact;
    private int jobId;
    private int storeId;

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
}
