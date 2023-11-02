package Controller;

import Domain.Supplier;
import InMemoryRepository.SupplierRepository;

import java.util.ArrayList;

public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void addSupplier(int id, String name, String contact) {
        Supplier newSupplier = new Supplier(id, name,contact);
        supplierRepository.addItem(newSupplier);
    }

    public void deleteSupplier(Supplier supplier) {
        supplierRepository.deleteItem(supplier);
    }

    public void updateSupplier(Supplier oldSupplier, Supplier newSupplier) {
        supplierRepository.updateItem(oldSupplier, newSupplier);
    }

    public ArrayList<Supplier> getAllSuppliers() {
        return supplierRepository.getAllItems();
    }
}
