package RepositoryDB;

import Domain.RepairService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepairRepositoryDB extends Database implements RepositoryInterface<RepairService> {

    @Override
    public void add(RepairService repairService) {
        String sql = "INSERT INTO repairservice(repairId, productId, customerId, employeeId) VALUES(?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(repairService.getRepairId()));
            stmt.setString(2, String.valueOf(repairService.getProductId()));
            stmt.setString(3, String.valueOf(repairService.getCustomerId()));
            stmt.setString(4, String.valueOf(repairService.getEmployeeId()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(RepairService deletedObject) {
        String sql = "DELETE FROM repairservice WHERE repairId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getRepairId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(RepairService oldObject, RepairService newObject) {
        String sql = "UPDATE repairservice SET productId=?, customerId=?, employeeId=? WHERE repairId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getProductId());
            stmt.setInt(2, newObject.getCustomerId());
            stmt.setInt(3, newObject.getEmployeeId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<RepairService> readAll() {
        String sql = "SELECT * FROM repairservice;";

        try {
            Statement stmt = conn().createStatement();
            List<RepairService> services = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                RepairService repairService = new RepairService(
                        resultSet.getInt("repairId"),
                        resultSet.getInt("productId"),
                        resultSet.getInt("customerId"),
                        resultSet.getInt("employeeId")

                );
                services.add(repairService);
            }
            return (ArrayList<RepairService>) services;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public RepairService findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM repairservice WHERE repairId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new RepairService(
                        resultSet.getInt("repairId"),
                        resultSet.getInt("productId"),
                        resultSet.getInt("customerId"),
                        resultSet.getInt("employeeId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

