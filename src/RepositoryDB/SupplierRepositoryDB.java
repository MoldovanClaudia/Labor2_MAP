//package Data_Base;
//
//import Data_Base.Database;
//import Domain.Supplier;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SupplierRepositoryDB extends Database {
//
//    public boolean create(Supplier supplier) {
//
//        String sql = "INSERT INTO Supplier(supplierId, supplierName, supplierContact) VALUES(?, ?, ?);";
//
//        try {
//            PreparedStatement stmt = this.conn().prepareStatement(sql);
//            stmt.setString(1, String.valueOf(supplier.getSupplierId()));
//            stmt.setString(2, supplier.getName());
//            stmt.setString(3, supplier.getContact());
//
//            int rows = stmt.executeUpdate();
//            return rows > 0;
//
//        } catch (SQLException e) {
//            return false; // e.printStackTrace();
//        }
//    }
//
//    public Supplier read(String supplierContact) {
//        String sql = "SELECT * FROM Supplier WHERE supplierContact = ?;";
//        try {
//            PreparedStatement stmt = this.conn().prepareStatement(sql);
//            stmt.setString(1, supplierContact);
//            ResultSet resultSet = stmt.executeQuery();
//            Supplier supplier = new Supplier();
//            if (resultSet.next()) {
//                supplier.setSupplierId(resultSet.getInt("supplierId"));
//                supplier.setName(resultSet.getString("supplierName"));
//                supplier.setContact(resultSet.getString("supplierContact"));
//                //customer.setCreatedAt(resultSet.getString("created_at"));
//            }
//            return supplier;
//        } catch (SQLException e) {
//            return new Supplier();
//        }
//    }
//
//    public List<Supplier> readAll() {
//        String sql = "SELECT * FROM Supplier;";
//
//        try {
//            Statement stmt = this.conn().createStatement();
//            List<Supplier> suppliers = new ArrayList<>();
//            ResultSet resultSet = stmt.executeQuery(sql);
//
//            while (resultSet.next()) {
//                Supplier supplier = new Supplier();
//                supplier.setSupplierId(resultSet.getInt("supplierId"));
//                supplier.setName(resultSet.getString("supplierName"));
//                supplier.setContact(resultSet.getString("supplierContact"));
//                suppliers.add(supplier);
//            }
//            return suppliers;
//        } catch (SQLException e) {
//            return new ArrayList<>();
//        }
//    }
//
//    public boolean update(Supplier updatedSupplier, String supplierContact) {
//        String sql = "UPDATE Supplier SET suppleirId=?, supplierName=?, supplierContact=? WHERE supplierContact = ?;";
//
//        try {
//            PreparedStatement stmt = this.conn().prepareStatement(sql);
//            stmt.setString(1, String.valueOf(updatedSupplier.getSupplierId()));
//            stmt.setString(2, updatedSupplier.getName());
//            stmt.setString(3, supplierContact);
//
//            int rows = stmt.executeUpdate();
//            return rows > 0;
//
//        } catch (SQLException e) {
//            return false;
//        }
//    }
//
//
//    public boolean delete(String supplierContact) {
//
//        String sql = "DELETE FROM Supplier WHERE supplierContact = ?;";
//        try {
//            PreparedStatement stmt = this.conn().prepareStatement(sql);
//            stmt.setString(1, supplierContact);
//            int rows = stmt.executeUpdate();
//            return rows > 0;
//        } catch (SQLException e) {
//            return false;
//        }
//    }
//
//    public boolean deleteAll() {
//        String sql = "DELETE FROM Supplier;";
//        try {
//            Statement stmt = this.conn().createStatement();
//            int rows = stmt.executeUpdate(sql);
//            return rows > 0;
//        } catch (SQLException e) {
//            return false;
//        }
//    }
//}

package RepositoryDB;

import Domain.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepositoryDB extends Database implements RepositoryInterface< Supplier> {

    @Override
    public void add(Supplier supplier) {
        String sql = "INSERT INTO supplier(supplierId, supplierName, supplierContact) VALUES(?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(supplier.getSupplierId()));
            stmt.setString(2, supplier.getName());
            stmt.setString(3, supplier.getContact());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Supplier deletedObject) {
        String sql = "DELETE FROM supplier WHERE supplierId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getSupplierId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Supplier oldObject, Supplier newObject) {
        String sql = "UPDATE supplier SET firstName=?, lastName=?, contact=?, billingAddres=? WHERE customerId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getContact());
            stmt.setInt(3, oldObject.getSupplierId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Supplier> readAll() {
        String sql = "SELECT * FROM suppleir;";

        try {
            Statement stmt = conn().createStatement();
            List<Supplier> suppliers = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Supplier supplier = new Supplier(
                        resultSet.getInt("supplierId"),
                        resultSet.getString("supplierName"),
                        resultSet.getString("supplierContact")
                );
                suppliers.add(supplier);
            }
            return (ArrayList<Supplier>) suppliers;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Supplier findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM supplier WHERE supplierId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Supplier(
                        resultSet.getInt("supplierId"),
                        resultSet.getString("supplierName"),
                        resultSet.getString("supplierContact")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


