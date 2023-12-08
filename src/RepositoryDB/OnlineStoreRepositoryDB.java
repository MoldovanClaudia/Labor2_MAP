package RepositoryDB;

import Domain.OnlineStore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OnlineStoreRepositoryDB extends Database implements RepositoryInterface<OnlineStore> {

    @Override
    public void add(OnlineStore store) {
        String sql = "INSERT INTO onlinestore(storeId, storeName, storeSite) VALUES(?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(store.getStoreId()));
            stmt.setString(2, store.getName());
            stmt.setString(3, store.getSite());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(OnlineStore deletedObject) {
        String sql = "DELETE FROM onlinestore WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getStoreId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OnlineStore oldObject, OnlineStore newObject) {
        String sql = "UPDATE onlinestore SET storeName=?, storeSite=? WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getSite());
            stmt.setInt(3, oldObject.getStoreId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<OnlineStore> readAll() {
        String sql = "SELECT * FROM onlinestore;";

        try {
            Statement stmt = conn().createStatement();
            List<OnlineStore> stores = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                OnlineStore store = new OnlineStore(
                        resultSet.getInt("storeId"),
                        resultSet.getString("storeName"),
                        resultSet.getString("storeSite")
                );
                stores.add(store);
            }
            return (ArrayList<OnlineStore>) stores;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public OnlineStore findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM onlinestore WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new OnlineStore(
                        resultSet.getInt("storeId"),
                        resultSet.getString("storeName"),
                        resultSet.getString("storeSite")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


