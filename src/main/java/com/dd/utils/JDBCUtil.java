package com.dd.utils;

import java.sql.*;

public class JDBCUtil {
    private final String URL = "jdbc:postgresql://localhost:5432/testtask_db";
    private final String USERNAME = "test_user";
    private final String PASSWORD = "testpass";

    private Connection connection = null;

    public JDBCUtil() {
    }

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void close (ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
