package com.stock.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DATABASE_URL = "jdbc:sqlite:stock.db";
    private static Connection connection;

    private ConnectionFactory() { }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DATABASE_URL);
            } catch (ClassNotFoundException e) {
                throw new SQLException("SQLite JDBC driver not found.", e);
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}
