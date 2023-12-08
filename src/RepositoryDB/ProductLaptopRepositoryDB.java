package RepositoryDB;

import Domain.ProductLaptop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductLaptopRepositoryDB extends Database implements RepositoryInterface<ProductLaptop> {

    @Override
    public void add(ProductLaptop laptop) {
        String sql = "INSERT INTO productlaptop(productId, name, description, category, price, supplierId, quantity, keyboardType, trackpad, OS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, laptop.getProductId());
            stmt.setString(2, laptop.getName());
            stmt.setString(3, laptop.getDescription());
            stmt.setString(4, laptop.getCategory());
            stmt.setFloat(5, laptop.getPrice());
            stmt.setInt(6, laptop.getSupplierId());
            stmt.setInt(7, laptop.getQuantity());
            stmt.setString(8, laptop.getKeyboardType());
            stmt.setString(9, laptop.getTrackpad());
            stmt.setString(10, laptop.getOS());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductLaptop deletedObject) {
        String sql = "DELETE FROM productlaptop WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getProductId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductLaptop oldObject, ProductLaptop newObject) {
        String sql = "UPDATE productlaptop SET name=?, description=?, category=?, price=?, supplierId=?, quantity=?, keyboardType=?, trackPad=?, OS=? WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getDescription());
            stmt.setString(3, newObject.getCategory());
            stmt.setFloat(4, newObject.getPrice());
            stmt.setInt(5, newObject.getSupplierId());
            stmt.setInt(6, newObject.getQuantity());
            stmt.setString(7, newObject.getKeyboardType());
            stmt.setString(8, newObject.getTrackpad());
            stmt.setString(9, newObject.getOS());
            stmt.setInt(10, oldObject.getProductId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ProductLaptop> readAll() {
        String sql = "SELECT * FROM productlaptop;";

        try {
            Statement stmt = conn().createStatement();
            List<ProductLaptop> laptops = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                ProductLaptop laptop = new ProductLaptop(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("keyboardType"),
                        resultSet.getString("trackPad"),
                        resultSet.getString("OS")
                );
                laptops.add(laptop);
            }
            return (ArrayList<ProductLaptop>) laptops;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ProductLaptop findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM productlaptop WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new ProductLaptop(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("keyboardType"),
                        resultSet.getString("trackPad"),
                        resultSet.getString("OS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

