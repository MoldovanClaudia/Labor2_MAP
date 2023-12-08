package ControllerDB;

import Domain.Supplier;
import RepositoryDB.SupplierRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class SupplierControllerDB {
    private final SupplierRepositoryDB supplierRepository;

    public SupplierControllerDB(SupplierRepositoryDB supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void addSupplier(int id, String name, String contact) {
        Supplier newSupplier = new Supplier(id, name,contact);
        supplierRepository.add(newSupplier);
    }

    public void deleteSupplier(ArrayList<String> supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId);
        supplierRepository.delete(supplier);

    }

    public void updateSupplier(ArrayList<String> supplierId, Map<String, String> supplier_updates) {
        Supplier oldSupplier = supplierRepository.findById(supplierId);

        if (oldSupplier != null) {
            Supplier newSupplier = new Supplier(
                    oldSupplier.getSupplierId(),
                    supplier_updates.containsKey("supplierName") ? supplier_updates.get("supplierName") : oldSupplier.getName(),
                    supplier_updates.containsKey("supplierContact") ? supplier_updates.get("supplierContact") : oldSupplier.getContact()
            );


            supplierRepository.update(oldSupplier, newSupplier);
            System.out.println("Supplier updated successfully.");
        } else {
            System.out.println("Supplier not found.");
        }
    }


    public ArrayList<Supplier> getAllSuppliers() {
        return supplierRepository.readAll();
    }
}
