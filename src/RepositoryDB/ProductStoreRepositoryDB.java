package RepositoryDB;

import Domain.ProductStore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductStoreRepositoryDB extends Database implements RepositoryInterface<ProductStore> {

    @Override
    public void add(ProductStore productStore) {
        String sql = "INSERT INTO productstore(productId, storeId) VALUES(?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, productStore.getproductStoreIdId());
            stmt.setInt(2, productStore.getProductStoreStoreId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductStore deletedObject) {
        String sql = "DELETE FROM productstore WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getProductStoreStoreId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductStore oldObject, ProductStore newObject) {
        String sql = "UPDATE productstore SET productId=? WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getproductStoreIdId());
            stmt.setInt(2, oldObject.getProductStoreStoreId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ProductStore> readAll() {
        String sql = "SELECT * FROM productstore;";

        try {
            Statement stmt = conn().createStatement();
            List<ProductStore> productStores = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                ProductStore productStore = new ProductStore(
                        resultSet.getInt("productId"),
                        resultSet.getInt("storeId")
                );
                productStores.add(productStore);
            }
            return (ArrayList<ProductStore>) productStores;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ProductStore findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM productstore WHERE storeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new ProductStore(
                        resultSet.getInt("productId"),
                        resultSet.getInt("storeId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

