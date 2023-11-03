package InMemoryRepository;
import Domain.Customer;
import Domain.Supplier;
import java.util.ArrayList;

public class SupplierRepository implements InMemoryRepository<Supplier> {
    private final ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

    @Override
    public void addItem(Supplier newSupplier) {
        suppliers.add(newSupplier);
    }

    @Override
    public void deleteItem(Supplier supplierToBeDeleted) {
        suppliers.remove(supplierToBeDeleted);
    }

    @Override
    public void updateItem(Supplier oldSupplier, Supplier newSupplier) {
        int index = suppliers.indexOf(oldSupplier);
        if (index != -1) {
            suppliers.set(index,newSupplier);
        }
    }

    @Override
    public ArrayList<Supplier> getAllItems() {
        return suppliers;
    }

    @Override
    public Supplier findById(int supplierId) {
        for(Supplier supplier : suppliers) {
            if (supplier.getSupplierId() == supplierId) {
                return supplier;
            }
        }
        return null;
    }
}
