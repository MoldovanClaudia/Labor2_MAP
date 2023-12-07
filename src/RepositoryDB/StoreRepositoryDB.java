package RepositoryDB;

import Domain.Store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryDB extends Database implements RepositoryInterface<Store> {

    @Override
    public void add(Store store) {
        String sql = "INSERT INTO store(storeId, storeName, storeAddress) VALUES(?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(store.getStoreId()));
            stmt.setString(2, store.getName());
            stmt.setString(3, store.getAddress());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Store deletedObject) {
        String sql = "DELETE FROM store WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getStoreId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Store oldObject, Store newObject) {
        String sql = "UPDATE store SET firstName=?, lastName=?, contact=?, billingAddres=? WHERE customerId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getAddress());
            stmt.setInt(3, oldObject.getStoreId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Store> readAll() {
        String sql = "SELECT * FROM store;";

        try {
            Statement stmt = conn().createStatement();
            List<Store> stores = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store(
                        resultSet.getInt("storeId"),
                        resultSet.getString("storeName"),
                        resultSet.getString("storeAddress")
                );
                stores.add(store);
            }
            return (ArrayList<Store>) stores;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Store findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM store WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Store(
                        resultSet.getInt("storeId"),
                        resultSet.getString("storeName"),
                        resultSet.getString("storeAddress")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


