package RepositoryDB;

import Domain.ProductOrder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderRepositoryDB extends Database implements RepositoryInterface<ProductOrder> {

    @Override
    public void add(ProductOrder order) {
        String sql = "INSERT INTO productorder(productId, orderId) VALUES(?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(order.getProductId()));
            stmt.setString(2, String.valueOf(order.getOrderId()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductOrder deletedObject) {
        String sql = "DELETE FROM productorder WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getOrderId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductOrder oldObject, ProductOrder newObject) {
        String sql = "UPDATE productorder SET productId=? WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getProductId());
            stmt.setInt(2, oldObject.getOrderId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ProductOrder> readAll() {
        String sql = "SELECT * FROM productorder;";

        try {
            Statement stmt = conn().createStatement();
            List<ProductOrder> Orders = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                ProductOrder order = new ProductOrder(
                        resultSet.getInt("productId"),
                        resultSet.getInt("orderId")
                );
                Orders.add(order);
            }
            return (ArrayList<ProductOrder>) Orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ProductOrder findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM productorder WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new ProductOrder(
                        resultSet.getInt("productId"),
                        resultSet.getInt("orderId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


