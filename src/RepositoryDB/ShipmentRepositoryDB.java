package RepositoryDB;

import Domain.Shipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShipmentRepositoryDB extends Database implements RepositoryInterface<Shipment> {

    @Override
    public void add(Shipment shipment) {
        String sql = "INSERT INTO shipment(shipmentId, orderId, company, place) VALUES(?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(shipment.getShipmentId()));
            stmt.setString(2, String.valueOf(shipment.getOrderId()));
            stmt.setString(3, shipment.getCompany());
            stmt.setString(4, shipment.getPlace());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Shipment deletedObject) {
        String sql = "DELETE FROM shipment WHERE shipmentId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getShipmentId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Shipment oldObject, Shipment newObject) {
        String sql = "UPDATE shipment SET orderId=?, company=?, place=? WHERE shipmentId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getOrderId());
            stmt.setString(2, newObject.getCompany());
            stmt.setString(3, newObject.getPlace());
            stmt.setInt(4, oldObject.getOrderId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Shipment> readAll() {
        String sql = "SELECT * FROM shipment;";

        try {
            Statement stmt = conn().createStatement();
            List<Shipment> shipments = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Shipment shipment = new Shipment(
                        resultSet.getInt("shipmentId"),
                        resultSet.getInt("orderId"),
                        resultSet.getString("company"),
                        resultSet.getString("place")
                );
                shipments.add(shipment);
            }
            return (ArrayList<Shipment>) shipments;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Shipment findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM shipment WHERE shipmentId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Shipment(
                        resultSet.getInt("shipmentId"),
                        resultSet.getInt("orderId"),
                        resultSet.getString("company"),
                        resultSet.getString("place")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


