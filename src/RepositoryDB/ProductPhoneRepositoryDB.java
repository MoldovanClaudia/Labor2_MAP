package RepositoryDB;

import Domain.ProductPhone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductPhoneRepositoryDB extends Database implements RepositoryInterface<ProductPhone> {

    @Override
    public void add(ProductPhone phone) {
        String sql = "INSERT INTO productphone(productId, name, description, category, price, supplierId, quantity, touchType, camera, OS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, phone.getProductId());
            stmt.setString(2, phone.getName());
            stmt.setString(3, phone.getDescription());
            stmt.setString(4, phone.getCategory());
            stmt.setFloat(5, phone.getPrice());
            stmt.setInt(6, phone.getSupplierId());
            stmt.setInt(7, phone.getQuantity());
            stmt.setString(8, phone.getTouchType());
            stmt.setString(9, phone.getCamera());
            stmt.setString(10, phone.getOS());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductPhone deletedObject) {
        String sql = "DELETE FROM productphone WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getProductId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductPhone oldObject, ProductPhone newObject) {
        String sql = "UPDATE productphone SET name=?, description=?, category=?, price=?, supplierId=?, quantity=?, touchType=?, camera=?, OS=? WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getDescription());
            stmt.setString(3, newObject.getCategory());
            stmt.setFloat(4, newObject.getPrice());
            stmt.setInt(5, newObject.getSupplierId());
            stmt.setInt(6, newObject.getQuantity());
            stmt.setString(7, newObject.getTouchType());
            stmt.setString(8, newObject.getCamera());
            stmt.setString(9, newObject.getOS());
            stmt.setInt(10, oldObject.getProductId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ProductPhone> readAll() {
        String sql = "SELECT * FROM productphone;";

        try {
            Statement stmt = conn().createStatement();
            List<ProductPhone> phones = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                ProductPhone phone = new ProductPhone(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("touchType"),
                        resultSet.getString("camera"),
                        resultSet.getString("OS")
                );
                phones.add(phone);
            }
            return (ArrayList<ProductPhone>) phones;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ProductPhone findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM productphone WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new ProductPhone(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("touchType"),
                        resultSet.getString("camera"),
                        resultSet.getString("OS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

