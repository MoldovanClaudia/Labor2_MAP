package Controller;

import Domain.Customer;
import Domain.Supplier;
import InMemoryRepository.SupplierRepository;

import java.util.ArrayList;
import java.util.Map;

public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void addSupplier(int id, String name, String contact) {
        Supplier newSupplier = new Supplier(id, name,contact);
        supplierRepository.addItem(newSupplier);
    }

    public void deleteSupplier(int supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId);
        supplierRepository.deleteItem(supplier);

    }

    public void updateSupplier(int supplierId, Map<String, String> supplier_updates) {
        Supplier oldSupplier = supplierRepository.findById(supplierId);

        if (oldSupplier != null) {
            Supplier newSupplier = new Supplier(
                    oldSupplier.getSupplierId(),
                    supplier_updates.containsKey("supplierName") ? supplier_updates.get("supplierName") : oldSupplier.getName(),
                    supplier_updates.containsKey("supplierContact") ? supplier_updates.get("supplierContact") : oldSupplier.getContact()
            );


            supplierRepository.updateItem(oldSupplier, newSupplier);
            System.out.println("Supplier updated successfully.");
        } else {
            System.out.println("Supplier not found.");
        }
    }


    public ArrayList<Supplier> getAllSuppliers() {
        return supplierRepository.getAllItems();
    }
}
