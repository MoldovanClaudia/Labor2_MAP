package RepositoryDB;

import Domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryDB extends Database implements RepositoryInterface<Customer> {

    @Override
    public void add(Customer customer) {
        String sql = "INSERT INTO customer(customerId, firstName, lastName, contact, billingAddress) VALUES(?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(customer.getCustomerIdId()));
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getContact());
            stmt.setString(5, customer.getBillingAddress());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Customer deletedObject) {
        String sql = "DELETE FROM customer WHERE customerId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getCustomerIdId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer oldObject, Customer newObject) {
        String sql = "UPDATE customer SET firstName=?, lastName=?, contact=?, billingAddress=? WHERE customerId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getFirstName());
            stmt.setString(2, newObject.getLastName());
            stmt.setString(3, newObject.getContact());
            stmt.setString(4, newObject.getBillingAddress());
            stmt.setInt(5, oldObject.getCustomerIdId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Customer> readAll() {
        String sql = "SELECT * FROM customer;";

        try {
            Statement stmt = conn().createStatement();
            List<Customer> customers = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("contact"),
                        resultSet.getString("billingAddress")
                );
                customers.add(customer);
            }
            return (ArrayList<Customer>) customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Customer findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM customer WHERE customerId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("contact"),
                        resultSet.getString("billingAddress")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

