package Domain;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String supplierContact;

    public Supplier(int id, String name, String contact) {
        this.supplierId = id;
        this.supplierName = name;
        this.supplierContact = contact;
    }

    public int getSupplierId() { return this.supplierId; }

    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public String getName() { return this.supplierName; }

    public void setName(String name) {
        this.supplierName = name;
    }

    public String getContact(){
        return this.supplierContact;
    }

    public void setContact(String contact) {
        this.supplierContact = contact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + supplierId +
                ", name=" + supplierName + "\'" +
                ", contact=" + supplierContact +
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
        Supplier supplier = (Supplier) obj;
        return supplierId == supplier.supplierId;
    }

}
