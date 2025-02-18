package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/restaurante", "user", "senha");
        } catch (ClassNotFoundException var1) {
            ClassNotFoundException e = var1;
            throw new SQLException(e.getMessage());
        }
    }
}
