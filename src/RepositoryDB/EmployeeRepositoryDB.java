package RepositoryDB;

import Domain.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryDB extends Database implements RepositoryInterface<Employee> {

    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee(employeeId, employeeFirstName, employeeLastName, employeeContact, jobId, storeId) VALUES(?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(employee.getEmployeeId()));
            stmt.setString(2, employee.getEmployeeFirstName());
            stmt.setString(3, employee.getEmployeeLastName());
            stmt.setString(4, employee.getEmployeeContact());
            stmt.setString(5, String.valueOf(employee.getJobId()));
            stmt.setString(6, String.valueOf(employee.getStoreId()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee deletedObject) {
        String sql = "DELETE FROM employee WHERE employeeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getEmployeeId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee oldObject, Employee newObject) {
        String sql = "UPDATE employee SET employeeFirstName=?, employeeLastName=?, employeeContact=?, jobId=?, storeId=? WHERE employeeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getEmployeeFirstName());
            stmt.setString(2, newObject.getEmployeeLastName());
            stmt.setString(3, newObject.getEmployeeContact());
            stmt.setInt(4, newObject.getJobId());
            stmt.setInt(5, newObject.getStoreId());
            stmt.setInt(6, oldObject.getEmployeeId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Employee> readAll() {
        String sql = "SELECT * FROM employee;";

        try {
            Statement stmt = conn().createStatement();
            List<Employee> employees = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("employeeFirstName"),
                        resultSet.getString("employeeLastName"),
                        resultSet.getString("employeeContact"),
                        resultSet.getInt("jobId"),
                        resultSet.getInt("storeId")
                );
                employees.add(employee);
            }
            return (ArrayList<Employee>) employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Employee findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM employee WHERE employeeId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("employeeFirstName"),
                        resultSet.getString("employeeLastName"),
                        resultSet.getString("employeeContact"),
                        resultSet.getInt("jobId"),
                        resultSet.getInt("storeId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

