package RepositoryDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public Connection conn() {
        String url = "jdbc:mysql://localhost:3306/magazin";
        String username = "root";
        String password = "magazin1";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
