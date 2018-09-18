package com.dd.utils;

import java.sql.*;

public class
JDBCUtil {
    private final String URL = "jdbc:postgresql://localhost:5432/testtask_db";
    private final String USERNAME = "postgres"; //"test_user"; --for mac || "postgres" --for win
    private final String PASSWORD = "postgres"; //"testpass"; --for mac || "postgres" --for win

    private Connection connection = null;

    public JDBCUtil() {
    }

    public Connection getMyConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void close (ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}