package com.keskin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection(String database_name, String username, String password) {

        String url = "jdbc:mysql://localhost:3306/" + database_name;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;

    }
}
