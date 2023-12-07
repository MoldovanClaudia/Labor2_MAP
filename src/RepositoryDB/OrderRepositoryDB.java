package RepositoryDB;

import Domain.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryDB extends Database implements RepositoryInterface<Order> {

    @Override
    public void add(Order order) {
        String sql = "INSERT INTO orders(rderId, customerId, orderDate) VALUES(?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(order.getOrderId()));
            stmt.setString(2, String.valueOf(order.getCustomerId()));
            stmt.setString(3, order.getOrderDate());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Order deletedObject) {
        String sql = "DELETE FROM orders WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getOrderId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order oldObject, Order newObject) {
        String sql = "UPDATE orders SET customerId=?, orderDate=? WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getCustomerId());
            stmt.setString(2, newObject.getOrderDate());
            stmt.setInt(3, oldObject.getOrderId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Order> readAll() {
        String sql = "SELECT * FROM orders;";

        try {
            Statement stmt = conn().createStatement();
            List<Order> Orders = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("orderId"),
                        resultSet.getInt("cutomerId"),
                        resultSet.getString("orderDate")
                );
                Orders.add(order);
            }
            return (ArrayList<Order>) Orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Order findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM orders WHERE orderId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Order(
                        resultSet.getInt("orderId"),
                        resultSet.getInt("cutomerId"),
                        resultSet.getString("orderDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


