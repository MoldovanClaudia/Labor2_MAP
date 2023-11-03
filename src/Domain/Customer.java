package Domain;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String contact;
    private String billingAddress;

    public Customer(int customerId, String firstName, String lastName, String contact, String billingAddress) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.billingAddress = billingAddress;
    }

    public int getCustomerIdId() { return this.customerId; }

    public void setCustomerIdId(int supplierId) { this.customerId = supplierId; }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstNameName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getContact(){
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBillingAddress() { return this.billingAddress; }

    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", first name=" + firstName +
                ", last name=" + lastName +
                ", contact=" + contact +
                ", billing address=" + billingAddress +
                "}";
    }

    //
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer customer = (Customer) obj;
        return customerId == customer.customerId;
    }

}
