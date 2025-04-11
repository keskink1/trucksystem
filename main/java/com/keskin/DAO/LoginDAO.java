package com.keskin.DAO;

import com.keskin.model.Driver;

import javax.ejb.Stateless;
import java.sql.*;

@Stateless
public class LoginDAO {

    private static final String DB_NAME = "truckdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";


    public boolean checkUser(String firstname, String lastname) {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        connection = DBUtils.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

        //write query
        String query = "SELECT * FROM drivers WHERE first_name = ? AND last_name = ?";
        try {
            //prepare the statement
             psmt = connection.prepareStatement(query);

             //set parameters
            psmt.setString(1,firstname);
            psmt.setString(2,lastname);

            //execute query
            rs = psmt.executeQuery();

            //check if there is a user or not
            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                psmt.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Driver getDriver(String firstname, String lastname) {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        connection = DBUtils.getConnection(DB_NAME, DB_USER,DB_PASSWORD);

        //write query
        String query = "SELECT * FROM drivers WHERE first_name = ? AND last_name = ?";

        try {
            //prepare statement
            psmt = connection.prepareStatement(query);

            //set parameter
            psmt.setString(1, firstname);
            psmt.setString(2, lastname);

            //execute query
            rs = psmt.executeQuery();

            //return value
            if (rs.next()){
                Driver driver = new Driver();
                driver.setId(rs.getInt("id"));
                driver.setFirst_name(rs.getString("first_name"));
                driver.setLast_name(rs.getString("last_name"));
                driver.setAge(rs.getInt("age"));
                return driver;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                psmt.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
