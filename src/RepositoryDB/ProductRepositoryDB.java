package RepositoryDB;

import Domain.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryDB extends Database implements RepositoryInterface<Product> {

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO product(productId, name, description, category, price, supplierId, quantity) VALUES(?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(product.getProductId()));
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getCategory());
            stmt.setFloat(5, product.getPrice());
            stmt.setInt(6, product.getSupplierId());
            stmt.setInt(7, product.getQuantity());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product deletedObject) {
        String sql = "DELETE FROM product WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getProductId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product oldObject, Product newObject) {
        String sql = "UPDATE product SET name=?, descriptiom=?, category=?, price=?, supplierId=?, quantity=? WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getName());
            stmt.setString(2, newObject.getDescription());
            stmt.setString(3, newObject.getCategory());
            stmt.setFloat(4, newObject.getPrice());
            stmt.setInt(5, newObject.getSupplierId());
            stmt.setInt(6, newObject.getQuantity());
            stmt.setInt(7, oldObject.getProductId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> readAll() {
        String sql = "SELECT * FROM product;";

        try {
            Statement stmt = conn().createStatement();
            List<Product> products = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity")

                );
                products.add(product);
            }
            return (ArrayList<Product>) products;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Product findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM product WHERE productId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Product(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("supplierId"),
                        resultSet.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

